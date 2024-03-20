package day0320;

import java.util.Scanner;

public class Ex9_ArraySearchString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String []members= {"강호동", "한가인","유재석","이승민","강하나"};

		/*
		 * 검색할 이름(searchName)을 입력하면 몇번째에 있는지 출력 
		 * 없을 경우 없다고 출력 
		 * (반복해서 검색을 하다가 'q'나 'Q'를 입력시 종
		 */

		int searchIndex;
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
				if(searchName.equals(members[i]))
				{
					searchIndex=i;
					break;
				}
			}
			if(searchIndex==-1)
				System.out.println("\t"+searchName+" 은 멤버명단에 없습니다");
			else	
				System.out.println("\t"+searchName+" 은"+(searchIndex+1)+"번째에 있습니다");
		}


	}

}
