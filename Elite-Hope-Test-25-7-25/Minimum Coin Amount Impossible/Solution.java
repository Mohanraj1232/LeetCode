import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N =sc.nextInt();

        int DP=0;
        int coins[] = new int[N];

        for(int i=0;i<N;i++){
            coins[i] = sc.nextInt();
        }
        
        Arrays.sort(coins);

        for(int i=0;i<N;i++){

            if(coins[i] - 1 >DP){
                System.out.println(DP + 1);
                return;
            }
            DP += coins[i];
        }

        System.out.println(DP + 1);

        sc.close();
    }
}
