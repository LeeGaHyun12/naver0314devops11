package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component //첫글자 소문자인 koreaTire가 아이디가 된다
public class KoreaTire implements Tire{
    @Override
    public String getTireName(){
        return "한국타이어";
    }

}
