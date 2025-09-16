class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int N = piles.length;
        
        int res = getMax(piles ,N);

        int st = 1 , end = res;

        while(st <= end){
           int mid = st + (end - st) / 2;

           boolean possible = isPossible(piles ,h ,mid);

           if(possible){
               end = mid - 1;
               res = mid;
           }else{
               st = mid + 1;
           }
        }

        return res;
    }

    private static boolean isPossible(int[] piles, int h ,int k){
        long hours = 0;

        for(int bananas : piles){
            hours += (bananas - 1) / k + 1;
        }

        return hours <= h;
    }

    private static int getMax(int []piles ,int N){
        int res = 0;

        for(int bananas : piles){
            res = Math.max(res , bananas);
        }

        return res;
    } 
}