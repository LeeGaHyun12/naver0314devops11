package day0318;

import java.util.Scanner;

public class Ex7_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 이름(name), 기본급(gibon), 가족수(family)를 키보드로 입력후
		 * 가족수가 3인 이상이면 기본급+(가족수*50000)으로 실수령액을 구하고
		 * 가족수가 3인 미만이면 기본급+30000 원으로 실수령액을 구하시오.
		 * 
		 * 출력은
		 * 이름
		 * 기본급
		 * 실수령액
		 */
		
		Scanner sc=new Scanner(System.in);
		int gibon, family;
		int totpay=0;
		String name;
		
		System.out.println("이름은? ");
		name=sc.nextLine();
		System.out.println("기본급은? ");
		gibon = sc.nextInt();
		System.out.println("가족수는? ");
		family=sc.nextInt();
		
		if(family>=3) {
			totpay=gibon+(family*50000);
		} else if(family<3) {
			totpay=gibon+30000;
		} 
	    System.out.println("-------결과-------");
		System.out.println("이름: "+name);
		System.out.println("기본급: "+gibon);
		System.out.println("실수령액: "+totpay);
		
	}

}
