package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * score.txt를 읽어서 총갯수와 총점, 평균을 구하시오
 * 단, 점수에 문자가 있는 경우 갯수에서 제외하고 총점에서도 제외하고 결과 출력 허가
 *
 * 갯수: 13개
 * 총점: 990 
 * 평균: 80.99 
 */


public class Ex17_ExceptionMunje {
	static final String FILENAME="/Users/igahyeon/Desktop/naver0314/score.txt";

	static public void readScore() {
		BufferedReader br=null;
		FileReader fr=null;
		
		try {
			fr=new FileReader(FILENAME);
			System.out.println("** score 파일을 읽습니다 **");
			
			while(true) {
				//파일의 내용을 한 줄씩 읽어온다 
				String line=br.readLine();
				int scoreLine=Integer.parseInt(line);
				//만약 더이상 데이터가 없을 경우 null값이 반환된다 
				if(line==null)
					break;
				System.out.println(scoreLine);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("** score 파일이 없어요 **");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close(); // 순서상 나중에 열린 자원을 먼저 닫아야 오류 안 생김. 
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readScore();
	}

}
