package day0315;

public class Ex2_DataType {

	public static void main(String[] args) {

		// 정수 타입
		
		byte a=127;
		byte b=(byte) 200; // (byte): cast 연산자: 강제로 형변환, 값손실발생

		System.out.println(a);
		System.out.println(b); // 값손실이 발생할 경우 엉뚱한 값이 출력(내부적으로는 2의 보수) -56
		
		float f1=123.567891234f; // float에 값을 넣을 땐 마지막에 꼭 f 붙이셈 
		double f2=123.567891234;
		
		System.out.println(f1);
		System.out.println(f2);
		
		// float은 소수점 포함 8자리까지 정확하게 나온다.
		// double은 15자리까지 정확하게 나온다.
		
		// 1글자 지정은 char='' , 문자열은 String(객체타입)=""
		
		char ch1='c' ;
		char ch2='가';
		
		System.out.println(ch1);
		System.out.println(ch2);
		
		// 문자열 지정하는 방법
		
		String str1=new String("happy"); // 방법1
		String str2="가현"; // 방법2
		String str3="나는 오늘도 자바를 공부한다 즐거운 금요일 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ";
		String str4="줄 나누기로 하려면 \n"
				+"이렇게\n"
				+"하면 한 줄 띄우기 가능";
		
		// jdk 15 부터 가능, 텍스트 블록	
		String str5="""
				따옴표 세개짜리를 쓰면
				알아서
				띄워진다 ?
				여러줄 쓰기 가능해
				""";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str5);
	}

}
