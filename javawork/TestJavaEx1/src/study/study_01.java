package study;

public class study_01 {

	 public String solution(String my_string, String letter) {
	        String answer = "";
	        
	        for(int i=0; i<my_string.length();i++) {
	        	if(letter.charAt(i)!=my_string.charAt(i)) {
	        		answer+=my_string.charAt(i);
	        	}
	        }
	        
	        System.out.println(answer);
	     
	        return answer;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String my_string = "abcdef";
		char letter= 'f';
	
		
		 System.out.println();

	}
}



