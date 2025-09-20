class Router {
    
    private int memoryLimit;
    private Deque<Packet> queue;
    private Set<String> packetSet;
    private Map<Integer, List<Integer>> destTimestamps;
    private Map<Integer, Integer> destStartIndex;  

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new LinkedList<>();
        this.packetSet = new HashSet<>();
        this.destTimestamps = new HashMap<>();
        this.destStartIndex = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (packetSet.contains(key)) {
            return false;
        }
        if (queue.size() == memoryLimit) {
            Packet old = queue.pollFirst();
            String oldKey = old.source + "#" + old.destination + "#" + old.timestamp;
            packetSet.remove(oldKey);
            destStartIndex.put(old.destination, destStartIndex.getOrDefault(old.destination, 0) + 1);
        }
        Packet newpkt = new Packet(source, destination, timestamp);
        queue.addLast(newpkt);
        packetSet.add(key);
        destTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        destStartIndex.putIfAbsent(destination, 0);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) {
            return new int[]{}; 
        }
        Packet pkt = queue.pollFirst();
        String key = pkt.source + "#" + pkt.destination + "#" + pkt.timestamp;
        packetSet.remove(key);
        destStartIndex.put(pkt.destination, destStartIndex.getOrDefault(pkt.destination, 0) + 1);
        return new int[]{pkt.source, pkt.destination, pkt.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> tsList = destTimestamps.get(destination);
        if (tsList == null) return 0;
        int startIdx = destStartIndex.getOrDefault(destination, 0);
        int lo = lowerBound(tsList, startIdx, startTime);   
        int hi = upperBound(tsList, lo, endTime);           
        return hi - lo;
    }

    private int lowerBound(List<Integer> list, int lo, int target) {
        int l = lo, r = list.size();
        while (l < r) {
            int mid = l + (r - l)/2;
            if (list.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(List<Integer> list, int lo, int target) {
        int l = lo, r = list.size();
        while (l < r) {
            int mid = l + (r - l)/2;
            if (list.get(mid) <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private static class Packet {
        int source, destination, timestamp;
        Packet(int s, int d, int t) {
            source = s; destination = d; timestamp = t;
        }
    }
}

