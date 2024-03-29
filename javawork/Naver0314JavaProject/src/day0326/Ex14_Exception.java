package day0326;

import java.util.Date;

/*
 * 예외처리할게 많을 때 사용 ! 
 * 
 * 일반 exception은 무조건 써줘야 한다.
 * 아니면 컴파일 오류남.
 */
public class Ex14_Exception {

	//발생하는 예외를 던져서 호출하는 곳에서 처리하도록 한다 
	static public void go1() throws NullPointerException,NumberFormatException{
		//Date date=null;
		Date date=new Date();
		
		System.out.println(date.getYear()+1900);
		
		String a="12a";
		int n=Integer.parseInt(a); //여기서 NumberFormatException
		System.out.println(n+10);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			go1();
		}catch(NullPointerException e) {
			System.out.println("Date 클래스 생성을 안하고 메서드 호출: "+e.getMessage());
		}catch(NumberFormatException e1) {
			System.out.println("문자가 있어서 숫자변환시 오류발생: "+e1.getMessage());
		}finally {
			System.out.println("이 영역은 무조건 실행됩니다! ");
		} // catch실행 여부와 상관없이 finally 무조건 실행된다.
		System.out.println("** 정상종료 **");
		
	
	}

}
