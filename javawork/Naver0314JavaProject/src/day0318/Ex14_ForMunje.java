package day0318;

import java.util.Scanner;

public class Ex14_ForMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 
		 * 5개의 점수(score)를 입력하면 갯수(count)와 합계(sum)를 출력하기
		 * (단, 1~100이 아닐 경우는 갯수에서 제외하고 합계에서도 제외하기 -continue 사용)
		 * 
		 * 예)
		 * 점수는 ? 80
		 * 점수는 ? 120
		 * 점수는 ? 70
		 * 점수는 ? 20
		 * 점수는 ? 40
		 * 
		 * 입력한 점수 갯수 : 5
		 * 총 합계: 330
		 * 
		 */

		Scanner sc=new Scanner(System.in);

		int score, count=0, sum=0;

		for(int i=1; i<=5;i++) {
			System.out.println("점수는? ");
			score=sc.nextInt();
			sum+=score;

			if(score>0) {
				count++;
			}
		}
		System.out.println("입력한 점수 갯수: "+count);
		System.out.println("총 합계: "+sum);
	}

}
