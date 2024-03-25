package day0325;

abstract class Animal{
	abstract public void writeAnimal();
}
class Cat extends Animal{

	@Override
	public void writeAnimal() {
		// TODO Auto-generated method stub
		//super.writeAnimal();
		System.out.println("나는 야옹 고양이임 ");
	}
	public void play() {
		System.out.println("야옹야옹");
	}

}
class Dog extends Animal{

	@Override
	public void writeAnimal() {
		// TODO Auto-generated method stub
		//super.writeAnimal();
		System.out.println("나는 멍멍 강아지임 ");
	}
	public void play() {
		System.out.println("멍ㅇ멍ㅇ");
	}

}
///////////////////////////////////////////
public class Ex9_Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat1=new Cat();
		cat1.writeAnimal();
		cat1.play();

		Dog dog1=new Dog();
		dog1.writeAnimal();
		dog1.play();

		System.out.println("==========");
		//부모클래스로 선언, 자식클래스로 생성 
		//다형ㅎ성이라고 한다 
		//오버라이드 메서드에 한해서만 호출이 가능하다 
		//writeAnimal은 호출이 가능하지만, play메서드는 호출할 수 없다 
		Animal ani=null;
		ani=new Cat();
		ani.writeAnimal();
		//ani.play(); //에러 

		ani=new Dog();
		ani.writeAnimal();

	}

}
