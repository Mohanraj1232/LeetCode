import java.util.HashMap;
import java.util.Scanner;

public class MonoCorp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t -- > 0){
            int N = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(solve(N ,s));
        }
        sc.close();
    }

    private static int solve(int N ,String s){
        int nDiff = 0;

        for(char ch: s.toCharArray()){
            if(ch == 'a') nDiff++;
            else nDiff--;
        }

        if(nDiff == 0){
            return 0;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0 ,-1);
        int diff = 0;
        int res = N;
        for(int i = 0; i < N; i++){
            if(s.charAt(i) == 'a') diff++;
            else diff--;

            if(map.get(diff - nDiff) != null){
                res = Math.min(res ,i - map.get(diff - nDiff));
            }
            map.put(diff ,i);
        }

        return res == N ? -1 : res;
    }

}
