package day0318;

import java.util.Scanner;

public class Ex1_Munje {
	// 삼항연산자 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  점수 (score)를 입력 후 점수가 
		 *  90 이상이면 "A"
		 *  80 이상이면 "B"
		 *  70 이상이면 "C"
		 *  60 이상이면 "D"
		 *  나머지는 "F"를 출력
		 *  (조건 연산자를 이용해서 구하기)
		 *  
		 *   예
		 *   점수는 ?
		 *   89
		 *   
		 *   89점은 B학점입니다. 
		 *  
		 */
		Scanner sc=new Scanner(System.in);
		
		System.out.print("점수는 : ");
		int score=sc.nextInt();
		String grade;
		
		grade = score>=90&&score<=100 ? "A":
			  score<90&&score>=80 ? "B":
			  score<80&&score>=70 ? "C": 
			  score<70&&score>=60 ?  "D": "F";
		
		System.out.println(score+"점은 "+grade+"학점입니다. ");
		
		//if 문을 이용해서 점수를 잘못 입력했을 경우 메서드 종료를 하자
		if(score<1||score>100)
		{
			System.out.println("잘못된 점수입니다.");

			return ; // main 메서드를 종료(곧 프로그램이 종료됨)
		}
		
		
	}

}
