import java.util.Scanner;

public class PopAndInsert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int N = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            System.out.println(solve(N ,str));
        }
        sc.close();
    }

    private static long solve(int N ,String S){
        char ch = S.charAt(0);
        int max = 0;
        int counter = 1;

        char tar = S.charAt(0);
        int end = 0;

        for(int idx = 1; idx < N; idx++){
            if(S.charAt(idx) == ch){
                counter++;
            }else{
                if(counter > max){
                    end = idx - 1;
                    max = counter;
                    tar = ch;
                }
                counter = 1;
                ch = S.charAt(idx);
            }
        }

        if(counter > max){
            end = N - 1;
            max = counter;
            tar = ch;
        }

        if(max == N){
            return 0L;
        }
        long res = 0;
        for(int i = 0; i <= (end - max); i++){
            if(S.charAt(i) != tar){
                res++;
            }
            res++;
        }
        for(int i = N - 1; i > end; i--){
            if(S.charAt(i) == tar){
                res++;
            }
            res++;
        }
        return res;
    }
}
