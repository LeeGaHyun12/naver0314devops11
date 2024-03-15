package day0315;

import java.util.Scanner;

public class Ex12_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 점수(score)를 입력받아
		 * 점수가 90 이상이면 "참 잘했어요"
		 * 점수가 80 이상이며 "수고했어요"
		 * 점수가 70 이상이면 "조금 더 노력하세요"
		 * 나머지 "재시험 입니다"
		 *  메세지를 지칭할 문자열: msg
		 */
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("점수를 입력하세요: ");
		int score=sc.nextInt();
		String msg;
		
		msg = score>90 ? "참잘했어요":
			  score<90&&score>80 ? "수고했어요":
			  score<80&&score>70 ? "조금 더 노력하세요": "재시험 입니다";
		
		System.out.println(msg);
	}

}
