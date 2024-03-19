package day0319;

import java.util.Scanner;

public class Ex7_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * while문을 이용하여 score 점수를 입력받은 후
		 * 0을 입력하면 while문을 빠져나가서 총 갯수와 합계를 구하시오
		 * (단, 1~100 이 아닌 값은 갯수와 합계에서 제외 
		 */

		Scanner sc=new Scanner(System.in);
		int score, count=0,sum=0;
		boolean b=true;

		while(b) {
			System.out.print("점수(종료 0): ");
			score=sc.nextInt();

			if(score<=0||score>100) {
				count--;
				b=false;
			}
			count++;
			sum+=score;
		}

		System.out.println("총 갯수: "+count+" 합계: "+sum);
		
//		 while(b) {
//		    	System.out.print("점수: ");
//		    	score=sc.nextInt();
//		    		    	
//		    	if(score==0) {
//		    		break;
//		    	}
//		    	if(score<0||score>100) {
//		    		continue;
//		    	}
//		    	
//		    	count++;
//		    	sum+=score;
//		    }
//
	}

}
