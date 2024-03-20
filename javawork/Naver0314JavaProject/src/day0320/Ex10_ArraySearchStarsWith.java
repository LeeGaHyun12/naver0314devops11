package day0320;

import java.util.Scanner;

public class Ex10_ArraySearchStarsWith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		String []members= {"강호동", "한가인","유재석","이승민","강하나","손미나","이영자","박남정","한지혜","손창민"};
		
		/*
		 * 검색할 이름은 ? 강
		 *        1번째: 강호동
		 *        5번째: 강하나
		 *        총 2명 검색
		 * 검색할 이름은? 박이 
		 *    "박이"로 시작하는 멤버는 없습니다 
		 *    
		 *  검색할 이름은 ? Q 
		 *       ** 검색을 종료합니다 **
		 */
		
		int searchIndex,count=0;
		String searchName;
	
		while(true)
		{
			searchIndex=-1;
			System.out.println("검색할 이름를 입력하세요 (종료:q/Q)");
			searchName= sc.nextLine();
			if(searchName.equalsIgnoreCase("q"))
			{
				System.out.println("검색을 종료합니다 ");
				break;
			}
			for(int i=0;i<members.length;i++)
			{
				if(members[i].startsWith(searchName))
				{
					searchIndex=i;
					System.out.println("\t"+(searchIndex+1)+"번째: "+members[searchIndex]);
					count++;
					
				}

			}
			if(searchIndex==-1)
				System.out.println("\t"+searchName+" 은 멤버명단에 없습니다");
			else {	
					System.out.println("\t총"+count+"검");
			}
		}
	}

}
