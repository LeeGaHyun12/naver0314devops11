package day0315;

import java.util.Scanner;

public class Ex7_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner sc=new Scanner(System.in);
	        int kor,eng;
	        String name;
	        
	        System.out.println("국어 점수는? ");
	        kor=Integer.parseInt(sc.nextLine());
	        System.out.println("영어 점수는? ");
	        eng=Integer.parseInt(sc.nextLine());
	        //버퍼의 엔터를 읽어서 소멸
	        System.out.println("이름은? ");
	        name=sc.nextLine(); // 점수 뒤에 엔터를 읽어온다 (엔터가 버퍼에 저장되어 있는 상태)
	        
	        // 정수 다음에 문자열을 읽으면 이런 문제 발생
	        
	        System.out.println("이름: "+name);
	        System.out.printf("국어점수: %d점, 평균: %d점\n", kor,eng);
	        System.out.printf("총점: %d점, 평균: %3.1f점",kor+eng,(kor+eng)/2.0);
		    // int와 double 계산은 묵시적으로 double로 계산된다
	        // 변수 중 최소 하나느 double로 놔야함
	        
	}

}
