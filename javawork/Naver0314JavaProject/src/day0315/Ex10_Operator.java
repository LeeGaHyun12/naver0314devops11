package day0315;

public class Ex10_Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 증감연산자
		// 전치일 경우 1순위, 후치일경우 끝순위
		// 단 단항일 경우 상관없음
		
		int m=5, n=5;
		m++;
		++n;
		System.out.println("m="+m); // 6
		System.out.println("n="+n); // 6
		
		int a=10, b=10;
		
		a+=m++; // a=a+m;,m=m+1; 후치는 제일 마지막에 계산한다
		System.out.println("a="+a); // 16
		System.out.println("m="+m); // 7
		
		b+=++n; // n=n+1;, b=b+n; 전치는 먼저 계산한다
		System.out.println("b="+b); // 17
		System.out.println("n="+n); // 7
		
		m=5;
		System.out.println(m++); // 5 먼저 출력 후 증가
		n=5;
		System.out.println(++n); // 6 먼저 증가 후 출력
		System.out.println("m="+m+", n="+n); // 6, 6
		
		// 대입, 증감연산자에는 초기값이 반드시 정해져 있어야 오류 발생 안 함.
		
	}

}
