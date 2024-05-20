package study.ex2;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor //final이나 NonNull이 붙은 멤버변수만 생성자 주입
@Setter
public class Student {
    private String schoolName;
    @NonNull //이거나 final 써서 선택해서 주입을 시키면 됨
    MyInfo myInfo;

    //MyInfo 정보는 생성자 주입
//    public Student(MyInfo info){
//        myInfo=info;
//    }
//    //학교명은 setter주입
//    public void setSchoolName(String schoolName){
//        this.schoolName=schoolName;
//    }
    public void show(){
        System.out.println(myInfo);//toString 호출
        System.out.println("학교명 : "+schoolName);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
