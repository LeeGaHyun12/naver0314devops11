package anno.study.ex4;

//어노테이션으로 수정
//public class Car {
//    private String carName;
//    private Tire tire;
//
//    public Car(Tire tire){
//        this.tire=tire;
//
//    }
//    public void setCarName(String carName){
//        this.carName=carName;
//    }
//
//    public void carInfo(){
//        System.out.println("자동차명:"+carName);
//        System.out.println("타이어:"+tire.getTireName());
//    }
//}

//annotation으로 수정
//@Component //xml에 car로 등록
//public class Car {
//    @Value("아우디")
//    private String carName;
//    @Autowired //자동으로 찾아서 주입을 시켜줌, 이번에는 Tire를 구현한 클래스가 2개이므로 모호성으로 인해 오류 발생
//   // private Tire tire;
//    private KoreaTire tire; //이경우는 정확하게 클래스명으로 선언을 해야만 오류가 발생하지 않는다
//
//    public void carInfo(){
//        System.out.println("자동차명:"+carName);
//        System.out.println("타이어:"+tire.getTireName());
//    }
//}

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//이번에는 tire를 lombok을 이용해서 주입해보자
@Component //xml에 car로 등록
@RequiredArgsConstructor //@NonNull이 붙은 멤버변수만이 생성자로 주입된다
public class Car {
    @Value("아우디")
    private String carName;
    @NonNull
    private KoreaTire tire;

    public void carInfo(){
        System.out.println("자동차명:"+carName);
        System.out.println("타이어:"+tire.getTireName());
    }
}