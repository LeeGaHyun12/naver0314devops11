package day0319;

import java.util.Scanner;

public class Ex11_StringMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 
		 * String 타입의 문자열(msg)를 입력받아
		 * 그 문자열안에 대문자, 소문자, 숫자가 몇개가 포함되어있는지 출력하시오
		 * 예)
		 * Happy Day 123!!
		 * 대문자: 2개
		 * 소문자: 6개
		 * 숫 자: 3개
		 * String의 charAt과 length를 사용하면 됨  
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		String msg;
		
		msg=sc.nextLine();
		int space=0;
		int num=0,small=0,large=0;
		
		 for(int i=0; i<msg.length(); i++) {
 			if(msg.charAt(i) == ' ') 
 				space++;
 			else if('a'<=msg.charAt(i) && 'z'>=msg.charAt(i)) 
 				small++;
 			else if('A'<=msg.charAt(i) && 'Z'>=msg.charAt(i)) 
 				large++;
 			else if(0<=(int)msg.charAt(i)-48 && 9>=(int)msg.charAt(i)-48) 
 				num++;
 		}
		 
		 System.out.println("대문자: "+large);
		 System.out.println("소문자: "+small);
		 System.out.println("숫 자: "+num);
		 
	}

}
