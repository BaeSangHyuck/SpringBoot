package com.example.board.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PageDTO {
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;

    private Criteria criteria;
    private int total;
    private int pageCount;

    public PageDTO() {;}

    public PageDTO(Criteria criteria, int total) {
        this(criteria, total, 10);
    }

    public PageDTO(Criteria criteria, int total, int pageCount){
        this.criteria = criteria;
        this.total = total;
        this.pageCount = pageCount;

        this.endPage = (int)(Math.ceil(criteria.getPageNum() / 10.0)) * pageCount;
        this.startPage = endPage - pageCount + 1;

        /*realEnd 구하기*/
        this.realEnd = (int)Math.ceil(total / (double)criteria.getAmount());

        /*endPage와 비교*/
        if(this.endPage > this.realEnd) {
            this.endPage = this.realEnd == 0 ? 1 : this.realEnd;
        }

        /*prev, next 구하기*/
        this.prev = this.startPage > 1;
        this.next = this.endPage < this.realEnd;
    }
}












