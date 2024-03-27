package study;

import java.util.Scanner;

public class Algorithm_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int n;
	
		String sNum;
		
		System.out.println("N 입력");
		n=sc.nextInt();
				
		System.out.println("숫자 입력");
		sNum=sc.next(); // 여기,,, 문제였다 라인으로 받는 건안된다 왜?

		char []cNum=sNum.toCharArray();
		int sum = 0;
		
		for(int i=0;i<cNum.length;i++) {
			sum+=cNum[i]-48;
		}
		System.out.println(sum);
		
	}

}
