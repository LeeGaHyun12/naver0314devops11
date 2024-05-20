package study.ex3;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Person {
    final private String name;
    @NonNull
    private String phone;

//    public Person(String name){
//        this.name=name;
//    }
//    public void setPhone(String phone){
//        this.phone=phone;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }


    public String getPhone() {
        return phone;
    }
}
