import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class XorSumInARange {
    public static void main(String[] args) {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int n = sc.readLine() ,Q = sc.nextInt();

        int N = getNext2Pow(n);

    }

    private static int getNext2Pow(int N){
        int pow = 0;

        while((1 << pow) < N){
            pow++;
        }

        return 1 << pow;
    }
}
