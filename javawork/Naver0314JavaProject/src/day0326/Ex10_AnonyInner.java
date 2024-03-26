package day0326;

abstract class Hello{
	abstract public void study();
}
interface Happy{
	public void insert();
	public void delete();
}

class Kiwi{
	
	Hello h=new Hello() {

		@Override
		public void study() {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	Happy ha=new Happy() {

		@Override
		public void insert() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete() {
			// TODO Auto-generated method stub
			
		}
		
	};
}
public class Ex10_AnonyInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kiwi k=new Kiwi();
		k.h.study();
		
	}

}
