package day0318;

import java.util.Scanner;

public class Ex8_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 상품명(sang)과 수량(su), 단가(dan) 입력받은 후
		 * 총금액(total)을 구하고 만약 수량ㅇ이 5개 이상이면
		 * "10프로 할인입니다" 와 함께 할인된 금액(dctotal)을 출력하시오
		 * 상품면?
		 * 딸기
		 * 수량?
		 * 6
		 * 단가?
		 * 2000
		 * 
		 * 총금액:12000
		 * 10프로 할인된 금액:10800
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		int su,dan,total=0;
		int dctotal=0;
		String sang;

		System.out.println("상품명? ");
		sang=sc.nextLine();
		System.out.println("수량? ");
		su=sc.nextInt();
		System.out.println("단가? ");
		dan=sc.nextInt();

		total=su*dan;
		dctotal=(int) (total*0.9);

	    if(su>=5) {
	    	System.out.println("10프로 할인입니다");
	    	System.out.println("10프로 할인된 금액: "+dctotal);
	    }else {
		System.out.printf("%s %d개의 총 금액: %d\n",sang,su,total);
	    }
		
	}

}
