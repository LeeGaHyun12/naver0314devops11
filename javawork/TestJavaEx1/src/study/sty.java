package study;

import java.util.*;

public class sty {
    static int n, cnt;
    static void solve(int n){

        if(n == 0) return;
        for(int i = 0; i < 3; i++){

            solve(n - 1);
            cnt++;
        }
        System.out.println(cnt);
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solve(n);

    }
}