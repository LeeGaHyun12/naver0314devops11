package day0322;

class Apple{
	String msg="Happy Day!!"; //인스턴스 멤버변수 
	static String MESSEGE="오늘은 금요일!!";  //static 멤버변수 
}
class Banana{
	int kor=100;
	int eng=90;
	String name="dlrkgus";
}

public class Ex1_Object {
	String name="홍길동";
	final static int MAX=100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * static 멤버 메서드는 static 멤버변수나 static 멤버메서드만 
		 * 접근이 가능하다 
		 * 일반 인스턴스 메서드나 변수를 접근하기 위해서는 new로 생성 후
		 * 그 변수를 이용해서 호출해야만 한다
		 *
		 */
		// System.out.println(name);//오류발생 
		System.out.println(Ex1_Object.MAX); //static변수는 클래스명.변수명
		System.out.println(MAX); //같은클래스일경우에는 앞에 클래스명은 생략이 가능하다. 
		
		//name을 출력하려면 new 생성한 인스턴스 변수가 필요하다 
		Ex1_Object ex=new Ex1_Object();
		//ex가 인스턴스 변수이다. 이 변수를 이용해야만 name이 접근이 가능하다. 
		System.out.println(ex.name);
		
		//Appleㅇ이 가진 2개의 멤버변수를 출력해보시오. 
		System.out.println(Apple.MESSEGE);
		Apple ap=new Apple();
		System.out.println(ap.msg);
		System.out.println(ap.MESSEGE);
		
		//Banana 클래스의 kor,eng점수 출력하고 합계도 출력
		Banana bn=new Banana();
		
		int sum=bn.kor+bn.eng;
		System.out.println(bn.kor);
		System.out.println(bn.eng);
		System.out.println(sum);
		//Banana 클래스의 name도 출력 
	}

}
