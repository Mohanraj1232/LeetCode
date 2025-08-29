import java.util.*;

public class Solution{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int res = 0 , sum = 0;

        for(int i = 0 ; i < N ; i++){
            int sal = sc.nextInt();

            if(sal == 0){
                Math.max(res, sum);
                sum = 0;
            }

            sum += sal;
        }

        System.out.print(res);

        sc.close();
    }
}