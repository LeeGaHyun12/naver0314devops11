package day0315;

import java.util.Scanner;

public class Ex5_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); //system.in은 키보드로부터 입력을 받는 인스턴스 변수
		String msg="";
		System.out.println("메세지를 입력하세요");
		msg=sc.nextLine();//한줄을 통째로 읽는다(문자열로)
		System.out.println("입력한 문자열은 \'"+msg+"\' 입니다"); // 따옴표 앞에 역슬래쉬 치면 따옴표가 출력된다
		
		int age;
		System.out.println("당신의 나이는?");
		//age=sc.nextInt();
		//System.out.println("내 나이는 "+age+"세 입니다");
		
		//숫자로 읽는 것보다 문자열로 읽는 것이 오류가 덜 하다
		
		age=Integer.parseInt(sc.nextLine());
		System.out.println("내 나이는 "+age+"세 입니다");
	
	}

}
