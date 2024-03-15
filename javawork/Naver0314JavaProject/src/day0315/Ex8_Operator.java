package day0315;

import java.util.Scanner;

public class Ex8_Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("두 개의 숫자 입력");
		int su1=sc.nextInt();
		int su2=sc.nextInt();
		
		System.out.println("더하기: "+(su1+su2));
		System.out.println("빼기: "+(su1-su2));
		System.out.println("곱하기: "+(su1*su2));
		System.out.println("나누기: "+(su1/(double)su2));
		System.out.println("나머지: "+((double)su1%su2));
		}

}
