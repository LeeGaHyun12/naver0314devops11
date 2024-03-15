package day0315;

public class Ex1_DataType {

	public static void main(String[] args) {
		
		boolean t=true; // 기본형 boolean
		boolean t2; // 기본형 boolean
		t2=false;

		System.out.print("t=");
		System.out.println(t);

		System.out.print("!t=");
		System.out.println(!t);

		System.out.print("t2=");
		System.out.println(t2);
		
		System.out.print("!t2=");
		System.out.println(!t2);
		
		System.out.print("t&&t2=");
		System.out.println(t&&t2);

		System.out.print("t||t2=");
		System.out.println(t||t2);
	
		
	}

}

/*  
1. 자바 실행 구조
자바는 컴파일 언어이면서 인터프리터 방식으로 출력을 하기도 한다.
다만, C++은 인터프리터 언어임
자바스크립트는 컴파일 언어가 아님 ( 오타 발생하면 에러가 안 나오는데 결과가 안 나오는 경우도 있음.)
*/

/*
 * 기본 자료형 공부
 * 함수 (구역{}) 안에서 선언하는 변수들은 자동초기화가 되지 않으므로 (지역 변수기 때문) 
 * 초기값을 지정하거나 나중에 변수에 값을 전달해야 출력 가능
 *
 *
 * 오버로딩 메소드: println이 여러개
 * 오버라이딩 :
 * 
 * && : 주어진 조건들이 모두 True 일 때만 True
 * || : 주어진 조건들 중 하나라도 true면 true
 * ! : true는 false로 false는 true로
*/

