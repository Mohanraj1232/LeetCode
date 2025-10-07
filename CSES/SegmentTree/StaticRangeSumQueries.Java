import java.util.*;

public class StaticRangeSumQueries{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt() ,Q = sc.nextInt();

        int N = getNextPow2(n);
        int[] segArr = new int[2 * N];
        
        for(int i = N; i < N + n; i++){
            segArr[i] = sc.nextInt();
        }

        for(int i = N - 1; i >= 1; i--){
            segArr[i] = (segArr[2 * i] + segArr[2 * i + 1]);
        }

        while(Q-- > 0){
            int left = sc.nextInt() ,right = sc.nextInt();
            System.out.println(find(segArr ,1 ,1 ,N ,left ,right));
        }
    }

    private static int find(int []segArr ,int idx ,int nodeLeft ,int nodeRight ,int queryLeft ,int queryRight){
        if(nodeRight < queryLeft || nodeLeft > queryRight){
            return 0;
        }

        if(queryLeft <= nodeLeft && queryRight >= nodeRight){
            return segArr[idx];
        }
        int mid = (nodeLeft + nodeRight) / 2;
        
        return find(segArr ,idx * 2 ,nodeLeft ,mid ,queryLeft ,queryRight) + 
                    find(segArr ,idx * 2 + 1,mid + 1 ,nodeRight ,queryLeft ,queryRight);
    }

    private static int getNextPow2(int n){
        int pow = 0;
        while((1 << pow) < n){
            pow++;
        }
        return 1 << pow;
    }
}