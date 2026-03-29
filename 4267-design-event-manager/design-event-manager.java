class EventManager {
    PriorityQueue<int[]> pq;
    HashMap<Integer, Integer> mp;
    public EventManager(int[][] events) {
        int eve[][] = events;
        mp = new HashMap<>();
        pq = new PriorityQueue<>((a, b)->{
            if(b[0] != a[0]) return b[0] - a[0];
            return a[1] - b[1];
        });
        for(int e[] : eve) {
            int id = e[0];
            int prio = e[1];
            mp.put(id, prio);
            pq.offer(new int[]{prio, id});
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        mp.put(eventId, newPriority);
        pq.offer(new int[]{newPriority, eventId});
    }
    
    public int pollHighest() {
        while(!pq.isEmpty()) {
            int top[] = pq.poll();
            int prio = top[0];
            int id = top[1];
            if(mp.containsKey(id) && mp.get(id) == prio) {
                mp.remove(id);
                return id;
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */