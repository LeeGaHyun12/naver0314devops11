package day0327;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *  1. 학생정보추가 : 이름, 나이, 3과목 점수입력 
 *  2. 학생정보삭제 : 이름으로 찾아서 삭제(없을 경우 메세지 출력)
 *  3. 전체출력 : 번호, 이름, Java,Spring,HTML,총점,평균,등급 출력 
 *  4. 평균으로 검색 : 평균값을 입력하면 그 평균값 이상의 학생들을 출력
 *  5. 이름으로 검색 : 입력한 이름을 포함하고 있으면 출력(contains) 
 *  6. 저장 후 종료
 */
public class Ex9_VectorMunje {
	List<StudentDto> list=new ArrayList<StudentDto>();
	Scanner sc=new Scanner(System.in);
	static final String FILENAME="/Users/igahyeon/Desktop/naver0314/student.txt";

	public Ex9_VectorMunje() {
		studentReadFile();
	}

	public void studentReadFile() {
		BufferedReader br=null;
		FileReader fr=null;
	}

	public void memberFileSave() {

	}
	public int getMenu() {
		int menu=0;

		System.out.println("1. 학생정보 추가");
		System.out.println("2. 학생정보 삭제");
		System.out.println("3. 전체 학생정보");
		System.out.println("4. 평균으로 검색");
		System.out.println("5. 이름으로 검색");
		System.out.println("6. 저장 후 종료");

		try {
			menu=Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("번호를 다시 입력해주세요");
		}
		return menu;

	}
	// 1. 학생정보추가 : 이름, 나이, 3과목 점수입력 
	public void addStudent() {

		System.out.print("이름: ");
		String name=sc.nextLine();
		System.out.print("나이: ");
		int age=sc.nextInt();
		System.out.print("java: ");
		int java=sc.nextInt();
		System.out.print("spring: ");
		int spring=sc.nextInt();
		System.out.print("html: ");
		int html=sc.nextInt();

		StudentDto dto=new StudentDto(name,age,java,spring,html);

		list.add(dto);

	}
	public void deleteStudent() {
		boolean b=false;

		System.out.println("삭제할 학생 이름: ");
		String dName=sc.nextLine();

		for(int i=0;i<list.size();i++) {
			b=true;
			StudentDto dto=new StudentDto();
			if(dto.getName().equals(dName)) {
				list.remove(i);
			}
		}
		if(b)
			System.out.println(dName+"학생 정보를 삭제했습니다");
		else
			System.out.println(dName+"이 멤버 명단에 없습니다");

	}
	public void writeStudent() {
		System.out.println("\t** 전체 학생 명단 **\n");
		System.out.println("=".repeat(50));
		System.out.println("번호\t이름\tJava\tSpring\tHTML\t총점\t평균\t등급");
		System.out.println("=".repeat(50));
		System.out.println("=".repeat(50));
		
		for(StudentDto dto:list) {
			System.out.println(dto.getName());
			System.out.println(dto.getAge());
			System.out.println(dto.getJava());
			System.out.println(dto.getSpring());
			System.out.println(dto.getHtml());
			System.out.println(dto.getTotal());
			System.out.println(dto.getAvg());
			System.out.println(dto.getGrade());
		}

	}
	public void searchName() {

	}
	public void searchPhone() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

}
