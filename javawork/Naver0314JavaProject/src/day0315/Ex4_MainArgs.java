package day0315;

public class Ex4_MainArgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(args[0]); //  hello
		System.out.println(args[1]); // apple
		
		System.out.println(args[2]+args[3]); //10+20 문자열로 읽기 때문에 숫자를 넣어도 그대로 출력
	    
		//문자열 -> 숫자로 변환 후 계산한다
		// Wrapper Class 중 Integer를 이용해 계산한다
		int s1=Integer.parseInt(args[2]); // 10이 숫자 10으로 변환
		int s2=Integer.parseInt(args[3]); // 20이 숫자 20으로 변환
		System.out.println(s1+s2);
	}

}
