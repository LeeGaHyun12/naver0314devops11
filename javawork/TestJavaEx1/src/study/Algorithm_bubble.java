package study;

import java.util.Scanner;

public class Algorithm_bubble {
    /*
    N개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성

    1번째 줄에 수의 개수 N(1<=N<=1000) 2번째줄부터 N개의 줄에 숫자가 주어진다.
    이 수는 절댓값이 1000보다 작거나 같은 정수다. 수는 중복 X

     */
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int a[]=new int[n];

        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n-1;i++){ //돌릴 루프
            for(int j=0;j<n-i-1;j++) { //루프가 도는 만큼 남은 루프가 줄어들기 때문에 최대치를 i만큼 빼주어야 한다
                if (a[j] > a[j + 1]) {
                    int temp=a[j];
                    a[j] = a[j + 1];
                    a[j+1]=temp;
                }
            }
        }
        for(int i=0; i<n;i++) {
            System.out.println(a[i]);
        }


    }
}
