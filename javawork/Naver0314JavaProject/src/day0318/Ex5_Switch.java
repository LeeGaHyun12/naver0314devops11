package day0318;

import java.util.Scanner;

public class Ex5_Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		int year,month,day;
		boolean flag;

		System.out.print("년도를 입력하세요 "); 
		year=sc.nextInt();
		if(year%4==0&&year%100!=0||year%400==0) //윤년공식
		{
			flag=true;
			System.out.println(year+"년은 윤년입니다");
		}else {
			flag=false;
			System.out.println(year+"년은 평년입니다");
		}

		System.out.print("월을 입력하세요 ");
		month=sc.nextInt();

		//1	보다 작거나 12보다 크면 "잘못 입력했어요!" 출력 후 메인함수 종료(return)
		if(month<1||month>12) {
			System.out.println("잘못 입력했어요!");
			return;
		}
		
//		switch(month)
//		{
//		case 2:
//			//day=flag==true?29:28;
//			day=flag?29:28; // 위와 같음 
//			break;
//		case 4:
//		case 6:
//		case 9:
//		case 11:
//			day=30;
//			break;
//		default:
//			day=31;
//		}
//		
		if(month==2)
		{
			day=flag?29:28;
		} else if(month==4||month==6||month==9||month==11) {
			day=30;
		}else{
			day=31;
		}

		System.out.println(year+"년 "+month+"월 "+day+"일까지 있습니다");

	}

}
