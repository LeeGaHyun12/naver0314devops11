package day0321;

import java.util.Scanner;

public class Book199_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		int n,student = 0,max_score=0,avg_score=0;
		int []scores = null;
		int sum = 0,m = 0;


		while(true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료 |");
			System.out.println("-----------------------------------------------");

			System.out.println("선택 > ");
			n=sc.nextInt();




			if (n==1) {

				System.out.print("학생수 > ");
				student=sc.nextInt();
				scores = new int[student];

			}
			if(n==2) {

				for(int i=0;i<student;i++) {
					System.out.println("score["+i+"] > ");
					scores[i]=sc.nextInt();

				}

			}

			if(n==3) {

				System.out.println("점수리스트 >");
				for(int i=0;i<student;i++) {
					System.out.println("score["+i+"]: "+scores[i]);
				}
			}
			if(n==4) {


				for(int i=0;i<student;i++) {
					sum+=scores[i];
					if(m<scores[i])
						max_score=scores[i];
				}

				avg_score=sum/student;
				System.out.println("최고점수 > "+max_score);
				System.out.println("평균점수 > "+avg_score);

			}
			else {
				break;
			}

		}
	}


}
