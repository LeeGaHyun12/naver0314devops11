package day0315;

public class Ex3_Output {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year=2024;
		int month=3;
		int day=15;

		String msg="Have a Nice Day!!";
		char blood='B';
		double avg=97.4567;

		System.out.println("** 출력 1 **");
		System.out.println("날짜"+year+"-"+month+"-"+day);
		System.out.println("혈액형: " +blood+"형");
		System.out.println("평균: "+avg);
		System.out.println("============================");

		// printf  를 이용해서 출력해보자
		// 변환기호를 이용해서 출력한다
		// 정수: %d, 실수: %f, 문자: %c, 문자열: %s
		
		System.out.printf("**%40s**\n\n",msg);
		System.out.printf("**%-40s**\n\n",msg); // -넣으면 우측기준 공백
		System.out.printf("**%s**\n",msg);
		
		System.out.printf("날짜: %d-%d-%d\n",year,month,day);
		System.out.printf("날짜: %2d-%2d-%2d\n",year,month,day); // 숫자만 쓰면 앞에는 공백으로 채워진다
		System.out.printf("날짜: %02d-%02d-%02d\n",year,month,day); // 공백인 곳은 0숫자로 채워진다
		
		System.out.printf("나의 혈액형은 %c형 입니다.\n",blood);
		
		System.out.printf("평균: %f점\n",avg);//%f: 소수점 이하가 6자리로 출력
		System.out.printf("평균: %3.1f점\n",avg);// 전체자리수 3자리, 소수점이하 자리수 1자리
		System.out.printf("평균: %10.2f점\n",avg);// 전체자리수 10자리, 소수점이하 자리수 2자리 (남는 건 공백처리)
		System.out.printf("평균: %-10.2f점\n",avg);// 열자리의 왼쪽으로 붙이고 오른쪽에 공백
		
		
	}

}
