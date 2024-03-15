package day0315;

import java.util.Scanner;

public class Ex9_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 백만단위의 금액(money)를 입력받은 후
		 * 만원, 천원, 백원, 십원, 일원
		 * 
		 * 예)
		 * 금액입력
		 * 4567893
		 * 만원: 456개
		 * 천원: 7개
		 * 백원: 8개
		 * 십원: 9개
		 * 일원: 3개
		 * 
		 */

		Scanner sc=new Scanner(System.in);
		System.out.println("금액 입력: ");
		int money=sc.nextInt();
		
		System.out.println("만원: "+money/10000+"장");
		System.out.println("천원: "+(money%10000/1000));
		System.out.println("백원: "+(money%10000/100));
		System.out.println("십원: "+(money%10000/10));
		System.out.println("일원: "+(money%10));
	}

}


