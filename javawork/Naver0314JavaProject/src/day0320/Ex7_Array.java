package day0320;

public class Ex7_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {23,100,200,-20,90,2,3,4,10,33};
		int max,min;
		max=min=data[0]; // 무조검 첫 데이타를 max또는 min으로 지
		System.out.println(data.length);
		
	    for(int i=1;i<data.length;i++) {
	    	if(max<data[i])
	    		max=data[i];
	    }
	    System.out.println("최대값: "+max);
	    
	    for(int i=1;i<data.length;i++) {
	    	if(min>data[i])
	    		min=data[i];
	    }
	    System.out.println("최소값: "+min);
	    
	    int pcnt=0,mcnt=0;
	    //배열데이터 중 양수의 갯수와 음수의 갯수를 구하여서 출력해보시오.
	    
	   for(int i=0;i<data.length;i++) {
		   if(data[i]>0) {
			   pcnt++;
		   } else if(data[i]<0) {
			   mcnt++;
		   }
	   }
	   System.out.println("양수 갯수: "+pcnt);
	   System.out.println("음수 갯수: "+mcnt);
	}

}
