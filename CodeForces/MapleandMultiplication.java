//https://codeforces.com/contest/2139/problem/A

import java.util.*;
public class MapleandMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(solve(a, b));
        }
    }

    private static int solve(int a, int b) {
        if(a == b) return 0;
        if(a % b == 0 || b % a == 0) return 1;
        return 2;
    }
}
