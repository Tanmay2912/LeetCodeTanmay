class Solution {
    public boolean isUgly(int n) {
       return calcUgly(n);
    }
    public static boolean calcUgly(int n)
    {
        int uglyNum = n;
        while (uglyNum > 0) { 
            if(uglyNum % 2 == 0)
            {
                uglyNum /= 2;
            }
            else if(uglyNum % 3 == 0)
            {
                uglyNum /= 3;
            }else if(uglyNum % 5 == 0)
            {
                uglyNum /= 5;
            }
            else {
                if(uglyNum == 1)
                {
                    System.out.println("Ugly Number");
                    return true;
                }
                else
                {
                    System.out.println("Not Ugly Number");
                    return false;
                }
            }
        }
        return false;
    }
     
}