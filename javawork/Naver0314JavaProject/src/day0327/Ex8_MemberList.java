package day0327;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex8_MemberList {
	List<MemberDto> list=new ArrayList<MemberDto>();
	Scanner sc=new Scanner(System.in);
	static final String FILENAME="/Users/igahyeon/Desktop/naver0314/member.txt";

	public Ex8_MemberList() {
		memberReadFile();
	}
	//파일 읽기-처음 생성시 자동으로 파일에서 멤버 읽어오기
	public void memberReadFile() {
		BufferedReader br=null;
		FileReader fr=null;

		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);

			while(true)
			{
				String s=br.readLine();
				if(s==null)
					break;
				//이효리, 010-2222-3333,서울,ab 이런 형태로 읽어옴
				// ,로 분리하기 
				String[] a=s.split(",");
				//MemberDto 생성후 setter로 데이터 넣기
				MemberDto dto=new MemberDto();

				dto.setName(a[0]);
				dto.setHp(a[1]);
				dto.setAddr(a[2]);
				dto.setBlood(a[3]);

				//list에 추가 
				list.add(dto);
			}
			System.out.println("총 "+list.size()+"명의 멤버 정보를 읽어왔어요!!");
		}catch(FileNotFoundException e) {
			System.out.println("읽어올 멤버 정보가 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			}catch (IOException|NullPointerException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	//종료시 파일 저장
	public void memberFileSave() {
		FileWriter fw=null;
		try {
			fw=new FileWriter(FILENAME);
			for(MemberDto dto:list) {
				String s=dto.getName()+","+dto.getHp()+","+dto.getAddr()+","+dto.getBlood()+"\n";
				fw.write(s);
			}
			System.out.println("총 "+list.size()+" 명의 정보를 파일에 저장하였습니다");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(IOException|NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
	//메뉴 선택
	public int getMenu() {
		int menu=0;
		System.out.println("1. 멤버정보 추가");
		System.out.println("2. 멤버 삭제 ");
		System.out.println("3. 전체멤버 출력");
		System.out.println("4. 이름으로 검색");
		System.out.println("5. 핸드폰으로 검색");
		System.out.println("6. 저장 후 종료");
		System.out.println("=".repeat(20));
		try {
			menu=Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) { //문자 입력시 발생하는 오류 
			// TODO: handle exception
			System.out.println("번호를 숫자로 입력해주세요.");
		}

		return menu;
	}
	//멤버 데이터 추가
	public void addMember() {
		System.out.println("이름을 입력하세요");
		String name=sc.nextLine();
		System.out.println("핸드폰을 입력하세요");
		String hp=sc.nextLine();
		System.out.println("주소을 입력하세요");
		String addr=sc.nextLine();
		System.out.println("혈액형을 입력하세요");
		String blood=sc.nextLine();

		MemberDto dto=new MemberDto(name,hp,addr,blood);
		//list에 추가
		list.add(dto);
		System.out.println(list.size()+"번째 멤버 정보를 추가하였습니다 !! ");

	}
	//멤버 삭제 
	public void deleteMember() {
		/*
		 * 삭제할 이름을 입력후 해당 이름에 해당하는 멤버정보를 삭제한다 
		 * 없을 경우 "xxx님은 명단에 없습니다"
		 * 있을 경우 "xxx님의 정보를 삭제하였습니다"
		 * 
		 */
		boolean f=false;
		System.out.println("삭제할 멤버명을 입력하세요");
		String name=sc.nextLine();
		for(int i=0;i<list.size();i++) {
			MemberDto dto=list.get(i);
			if(dto.getName().equals(name)) {
				f=true;
				list.remove(i);
				break;
			}
		}
		if(f)
			System.out.println(name+"님의 정보를 삭제하였습니");
		else
			System.out.println(name+"님은 명단에 없습니다");


	}
	//전체 멤버 출력 
	public void writeMember() {
		System.out.println("\t** 전체 멤버 명단 **\n");
		System.out.println("=".repeat(50));
		System.out.println("번호\t이름\t핸드폰\t\t주소\t혈액형\t");
		System.out.println("=".repeat(50));
		System.out.println("=".repeat(50));

		for(int i=0;i<list.size();i++) {
			MemberDto dto=list.get(i);
			System.out.println(i+1+"\t"+dto.getName()+"\t"+dto.getHp()+"\t"
					+dto.getAddr()+"\t"+dto.getBlood().toUpperCase()+"");

		}
		System.out.println("=".repeat(50));
	}
	//이름으로 검색 
	public void searchName() {
		/*
		 * 검색할 이름 입력인데 성만 입력해도 해당 성을 가진 사람 출력(startsWith)
		 * 한명도 없을 경우 "xxx님은 명단에 없습니다"
		 * 
		 * 이름: xxx
		 * 핸드폰: xxx
		 * 주소: ㅌㅌㅌ
		 * 혈액형: ㅁ 
		 * ---------------
		 * 이름: xxx
		 * 핸드폰: xxx
		 * 주소: ㅌㅌㅌ
		 * 혈액형: ㅁ 
		 * ---------------
		 * 
		 */
		boolean f=false;
		int searchIndex=0;
		String searchName;

		System.out.println("검색할 이름을 입력하세요");
		searchName=sc.nextLine();


		for(MemberDto dto:list)
		{
			f=true;

			if(dto.getName().startsWith(searchName))
			{
				System.out.println(dto.getName()+"\n"+dto.getHp()+"\n"+dto.getAddr()+"\n"+dto.getBlood().toUpperCase());
				System.out.println("-".repeat(40));
			
			}

		}
		if(!f)
			System.out.println(searchName+"님은 멤버 명단에 없습니다");



	}
	//전화번호로 검색 
	public void searchPhone() {
		/*
		 * 검색할 핸드폰 끝4자리 입력하면 그 번호를 가진 사람 출력(endsWith)
		 * 한명도 없을 경우 "xxxx번호를 가진 멤버는 없습니다"
		 * 
		 * 
		 */
		boolean f=false;
		int searchIndex=0;
		String searchPhone;

		System.out.println("검색할 핸드폰 뒷자리(4개) 입력하세요");
		searchPhone=sc.nextLine();


		for(MemberDto dto:list)
		{
			f=true;

			if(dto.getHp().endsWith(searchPhone))
			{
				System.out.println(dto.getName()+"\n"+dto.getHp()+"\n"+dto.getAddr()+"\n"+dto.getBlood().toUpperCase());
				System.out.println("-".repeat(40));
			
			}

		}
		if(!f)
			System.out.println(searchPhone+"번호를 가진 멤버는 명단에 없습니다");

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex8_MemberList ex=new Ex8_MemberList();

		while(true) {
			int menu=ex.getMenu();

			switch(menu) {
			case 1:
				ex.addMember();
				break;
			case 2:
				ex.deleteMember();
				break;
			case 3:
				ex.writeMember();
				break;
			case 4:
				ex.searchName();
				break;
			case 5:
				ex.searchPhone();
				break;
			case 6:
				ex.memberFileSave();
				System.out.println("** 멤버 정보를 저장 후 종료합니다 **");
				System.exit(0); //위치 상관없이 종료
			default:
				System.out.println("잘못된 번호입니다");
			}
			System.out.println();

		}
	}

}
