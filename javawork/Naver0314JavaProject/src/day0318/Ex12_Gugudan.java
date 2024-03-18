package day0318;

import java.util.Scanner;

public class Ex12_Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 구구단? 11
		 * 	잘못된 숫자입니다 (if)
		 * 구구단? 5
		 * 
		 * **5단** (for)
		 *  5 x 1 = 5
		 *  .
		 *  .
		 *  .
		 *  5 x 9 = 45
		 *  
		 */
		Scanner sc=new Scanner(System.in);

		int dan,sum;
		System.out.println("구구단? ");
		dan=sc.nextInt();

		System.out.println();
		if(dan>10) {
			System.out.println("잘못된 숫자입니다.");
			return ;

		}
		System.out.println("** "+dan+"단 **");
		for(int i=1;i<=9;i++) {
//			sum=dan*i;
//			System.out.println(dan+" x "+i+" = "+sum);
			
			System.out.printf("%d x %d = %2d\n",dan,i,dan*i);
		}
		
	}

}
