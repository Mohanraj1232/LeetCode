import java.util.*;

public class Solution {

    public static void main(String [] args){

        
    }

    public static int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> counter=new HashMap<>();

        int res=0,score=0,ptr=0,ptr1=0;

        while(ptr<nums.length){
            if(counter.get(nums[ptr])==null){
                counter.put(nums[ptr],1);
                score+=nums[ptr];
                ptr++;
            }else{
                res=Math.max(score,res);
                
                while(ptr1<ptr && counter.get(nums[ptr])!=null){
                    counter.remove(nums[ptr1]);
                    score-=nums[ptr1++];
                }
            }
        }


        return res;
    }
}