package day0321;

public class Ex5_ArrayAgeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []memberAges= {12,56,34,23,34,59,46,6,11,29,32,49,51,38,44,55,1};
		System.out.println("총 인원수 : "+memberAges.length);
		int []ageCount=new int[6];
		
		/*
		 * 연령별 인원수를 구해서 출력하시오
		 * 10세 미만: 3명
		 * 10대    :5명
		 * 20
		 * ...
		 * 50대    :1명 
		 * 
		 */
	
	     for(int i=0;i<memberAges.length;i++) {
	    	 
	    	 ageCount[memberAges[i]/10]++;
	    	 
	     }
	     System.out.println("** 연령별 인원수 ** ");
	 		for(int i=0;i<ageCount.length;i++) {
	 			if(i==0) {
	 			System.out.println("10세 미만: "+ageCount[i]+"명");
	 			} else {
	 				System.out.println(i*10+"대    : "+ageCount[i]+"명");
	 			}
	 		    
	 		}
	}

}
