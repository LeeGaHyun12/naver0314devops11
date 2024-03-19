package day0319;

public class Ex2_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 2. 
		 * 
		 * 1! = 1
		 * 2! = 2
		 * 3! = 6
		 * 4! = 24
		 * (단일 for문)
		 *
		 */
				int fact=1;
				for(int x=1;x<=10;x++) {
					
					fact*=x;
					System.out.println(x+"! = "+fact);
		
				}

	}

}
