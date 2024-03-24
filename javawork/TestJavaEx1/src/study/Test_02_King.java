package study;

import java.util.Scanner;

public class Test_02_King {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	int king,queen,look,bishop,night,phone;
	
	Scanner sc=new Scanner(System.in);
	
	king=sc.nextInt();
	queen=sc.nextInt();
	look=sc.nextInt();
	bishop=sc.nextInt();
	night=sc.nextInt();
	phone=sc.nextInt();
	
	if(king>=0||king<=10) {
		king=1-king;
	}
	if(queen>=0||queen<=10) {
		queen=1-queen;
	}
	if(look>=0||look<=102) {
		look=2-look;
	}
	if(bishop>=0||bishop<=10) {
		bishop=2-bishop;
	}
	if(night>=0||night<=10) {
		night=2-night;
	}
	if(phone>=0||phone<=10) {
		phone=8-phone;
	}	
	
	System.out.printf("%d %d %d %d %d %d ",king, queen,look, bishop, night,phone);
	
	}

}

/*
 * 동혁이는 오래된 창고를 뒤지다가 낡은 체스판과 피스를 발견했다.

체스판의 먼지를 털어내고 걸레로 닦으니 그럭저럭 쓸만한 체스판이 되었다. 하지만, 검정색 피스는 모두 있었으나, 흰색 피스는 개수가 올바르지 않았다.

체스는 총 16개의 피스를 사용하며, 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개로 구성되어 있다.

동혁이가 발견한 흰색 피스의 개수가 주어졌을 때, 몇 개를 더하거나 빼야 올바른 세트가 되는지 구하는 프로그램을 작성하시오.


첫째 줄에 동혁이가 찾은 흰색 킹, 퀸, 룩, 비숍, 나이트, 폰의 개수가 주어진다. 이 값은 0보다 크거나 같고 10보다 작거나 같은 정수이다

첫째 줄에 입력에서 주어진 순서대로 몇 개의 피스를 더하거나 빼야 되는지를 출력한다. 만약 수가 양수라면 동혁이는 그 개수 만큼 피스를 더해야 하는 것이고, 음수라면 제거해야 하는 것이다.
 */