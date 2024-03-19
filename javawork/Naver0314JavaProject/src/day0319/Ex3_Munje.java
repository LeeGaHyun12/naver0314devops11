package day0319;

public class Ex3_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		/*
		//		 * 3. 
		//		 * xy+yx=121이 나오는 x,y모두 구하기 단,xy는 1-9 사이의 한자리숫자임
		//		 * 예) 29+92=121
		//		 */
		//		

				for(int x=1; x<10;x++) {
					for(int y=1;y<10;y++) {
						int susik=(x*10+y)+(y*10+x);
		
						if(susik==121) {
		
							System.out.printf("%d%d+%d%d=121\n",x,y,y,x);
		
						}
		
					}
		
				}
	}

}
