package day0325;

//같은 패키지 내에서는 부모가 가진 메서드는 private을 제외하고 모든 상속을 받음
class Parent{
	void method1() {
		System.out.println("부모의 디폴트 메서드");
	}
	protected void method2()
	{
		System.out.println("부모의 protected 메서드");
	}
	private void method3()
	{
		System.out.println("부모의 private 메서드");
	}
	public void method4()
	{
		System.out.println("부모의 public 메서드");
	}

}

//서브 클래스 구현
class Sub1 extends Parent{
	public void show() {

		/*
		 * 현재 클래스에 같은 이름의 메서드가 존재할 경우 
		 * 부모 메서드 호출시 앞에 super로 호출 
		 * 
		 * 같은 이름의 메소드가 없을 경우 super대신 this로 호출해도 된다
		 * 같은 이름ㅇ의 메서드를 Ovveride Method라고 한다 
		 */
		System.out.println("this로 호출");
		this.method1(); //default, 부모가 다른 패키지에 있다면 default도 호출안됨
		this.method2(); //protected 
		//this.method3(); //private은 상속이 안됨
		this.method4(); //public 

		System.out.println("super로 호출");
		super.method1();
		super.method2();
		super.method4();
	}
}
public class Ex5_Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sub1 s=new Sub1();
		s.show();
	}

}
