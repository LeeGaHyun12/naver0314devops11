package study;

import java.util.Scanner;

/*
문제
자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.

출력
첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.

10 11 12


 */
public class Study_Algorithm_05 {
    static void gob(int a, int b,int c){
        int sum=0;
        System.out.println("a: "+a+"b: "+b+"c: "+c);
        sem(a,b-1);
        System.out.println("sum:"+sum);
        System.out.println("답:"+sum/c);
    }
    static void sem(int a, int b){
        int sum+=a*b;
        return sum;

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int a,b,c;
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();

        gob(a,b,c);
    }

}
