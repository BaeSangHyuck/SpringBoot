package com.example.board.domain.vo;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
@RequiredArgsConstructor
public class Criteria { /*Criteria : 검색의 기준*/
//    생성자로 초기화 시 pageNum과 amount만 초기화하기 위해서 @NonNull을 붙인다.
    @NonNull private int pageNum;
    @NonNull private int amount;
    private String type;
    private String keyword;

//    롬복을 통해 생성된 초기화 생성자를 기본 생성자에서 기본 값을 설정한 뒤 호출해준다.
    public Criteria() {this(1, 10);}

    public Criteria(@NonNull int pageNum, @NonNull int amount, String type, String keyword) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.type = type;
        this.keyword = keyword;
    }

    //    "경로1/경로2?KEY=VALUE&KEY=VALUE"
//    위와 같이 여러 개의 파라미터를 GET방식으로 전달할 때 사용되는 문법을 쿼리 스트링이라고 한다.
//    하지만 여러 경로에서 동일한 파라미터를 쿼리 스트링으로 전달하게 되면 가독성이 떨어지고 유지보수가 어렵다.
//    따라서 JAVA 서버 단에서 UriComponentsBuilder를 통해, 제작한 쿼리 스트링을 재사용할 수 있게 된다.
//    URI : "경로1"
//    fromPath("/경로2").queryParam("KEY", "VALUE).queryParam("KEY", "VALUE")
//    결과 : "경로1/경로2?KEY=VALUE&KEY=VALUE"
    public String getListLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", this.pageNum)
                .queryParam("amount", this.amount)
                .queryParam("type", this.type)
                .queryParam("keyword", this.keyword);
        return builder.toUriString();
    }

    public String[] getTypes(){
        return type == null ? new String[] {} : type.split("");
    }
}

























