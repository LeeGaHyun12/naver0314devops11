package day0315;

import java.util.Scanner;

public class check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); //system.in은 키보드로부터 입력을 받는 인스턴스 변수
		
		System.out.print("두 개의 숫자 입력");
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		
		if(a>b) {
		    System.out.println(">");
		}
		else if(a<b) {
			System.out.println("<");
		}
		else if(a==b) {
			System.out.println("==");
		}
	
	}

}
