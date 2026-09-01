class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBanana = 0;
        for(int pile:piles){
            maxBanana = Math.max(maxBanana,pile);
        }
        int left = 1;
        int right = maxBanana;
        int result = maxBanana;
        while(left<=right){
            int mid = left+(right-left)/2;

            int hoursRequired = 0;
            for(int pile:piles){
                hoursRequired += (pile/mid );
                if(pile%mid!=0)hoursRequired++;
            }

            if(hoursRequired>h){
                left = mid+1;
            } else {
                right = mid-1;
                result = mid;
            }
        }
        return result;
        
    }

    // time = number of banana / speed;
}
