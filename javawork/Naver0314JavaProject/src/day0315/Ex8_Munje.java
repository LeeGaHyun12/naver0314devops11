package day0315;

import java.util.Scanner;

public class Ex8_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 이름(name),핸드폰(hp),태어난년도(birthYear) 입력받은 후
		 * 이름 핸드폰 태어난년도 나이(age, 2024-태어난년도)를 출석하는 프로그램을 작성
		 * 선언 - 입력 - 계산 - 출력
		 */
		
		Scanner sc=new Scanner(System.in);
		String name, hp;
		int birthYear;
		
		System.out.print("이름: ");
		name=sc.nextLine();
		
		System.out.print("핸드폰: ");
		hp=sc.nextLine();
		
		System.out.print("태어난 년도: ");
		birthYear=Integer.parseInt(sc.nextLine());
		
		System.out.println("=====================");
		System.out.println("이름: "+name);
		System.out.println("핸드폰: "+hp);
		System.out.println("나이: "+(2024-birthYear));
		System.out.println("=====================");
		
	}

}
