package day0322;

class Orange{
	//private 접근지정자는 같은 클래스 내에서만 접근이 가능
	//멤버변수는 자동 초기화 
	private String name;
	private int age;
	
	private static String company="삼성";
	
	//getter메서드: 멤버변수값을 반환하는 메서드(규칙 getName,getAge)
	public String getName() {
		return this.name;//this: 자기자신을 의미하는 인스턴스 변수(일반 멤버메서드에만 존재, static메서드에는 없음 
		//return name; //같은 구역안에 같은 이름이 없을 경우에만 this생략 가능 
		
	}
	public int getAge() {
		return age; //this는 생략 가능 
	}
	//외부로부터 값을 받아서 멤버변수의 값을 변
	public void setName(String name) {
		this.name=name; //인자에 있는 name값을 멤버변수 name으로 전달 
		
	}
	public void setAge(int age) {
		this.age=age; //인자에 있는 name값을 멤버변수 name으로 전달 
		
	}
	//static 변수를 반환하는 메서드 
	public static String getCompany()
	{
		return company;
	}
	
}

public class Ex2_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   Orange or = new Orange();
	   //초기값 확인 
	   System.out.println(or.getName());
	   System.out.println(or.getAge());
	   
	   System.out.println("이름과 나이 변경 후 출력");
	   or.setName("옥순");
	   or.setAge(23);
	   System.out.println(or.getName());
	   System.out.println(or.getAge());
	   
	  System.out.println(or.getCompany());
	   
	}

}
