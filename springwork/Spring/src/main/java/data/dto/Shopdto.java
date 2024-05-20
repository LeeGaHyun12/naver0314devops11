package data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
//@ToString
@Data //Setter+Getter+ToString
public class Shopdto {
    private String sang;
    private String photo;
    private int price;
    private int su;


}
