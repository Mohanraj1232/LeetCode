import java.util.Arrays;
import java.util.Scanner;

public class SegmentTree {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int N = getNearest2PowValue(n);

        int[] segArr = new int[2 * N];
        
        Arrays.fill(segArr ,Integer.MAX_VALUE);
        
        for(int i = N; i < N + n; i++){
            segArr[i] = sc.nextInt();
        }

        for(int i = N - 1; i >= 1; i--){
            segArr[i] = Math.min(segArr[2 * i], segArr[2 * i + 1]);
        }
        System.out.println(find(segArr, 1, 1, N, 1, 5));
        //System.out.print(Arrays.toString(segArr));

        sc.close();
    }

    private static int find(int segArr[],int nodeidx ,int nodeLeft ,int nodeRight ,int queryLeft ,int queryRight){
        if(nodeRight < queryLeft || nodeLeft > queryRight){
            return Integer.MAX_VALUE; 
        }
        if(queryLeft <= nodeLeft && nodeRight <= queryRight){
            return segArr[nodeidx];
        }
        int mid = (nodeLeft + nodeRight) / 2;
        return Math.min(find(segArr ,nodeidx * 2 ,nodeLeft ,mid ,queryLeft ,queryRight) ,find(segArr ,nodeidx * 2 + 1,mid + 1,nodeRight ,queryLeft ,queryRight));
    }

    private static int getNearest2PowValue(int n){
        int pow = 0;
        while((1 << pow) < n){
            pow++;
        }
        return 1 << (pow);
    }
}
