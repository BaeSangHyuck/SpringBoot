package com.example.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@Slf4j
public class TimeController {

//    공통된 상위 경로가 없다면, Controller에 Mapping을 작성하지 않아도 된다.
    @GetMapping("/time")
    @ResponseBody // 일반 컨트롤러에서 html 이동이 아닌 값을 그대로 전달하기 위해서는 @ResponseBody를 사용한다.
//    외부에서 댓글을 작성한 시간을 문자열로 전달받는다.
    public String getReplyDate(String replyDate) throws ParseException {
        //전달받은 문자열 형식을 작성한다.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //현재 시간
        Date today = new Date();
        //댓글을 작성한 시간을 format에 맞추어 Date타입으로 변경시킨다.
        Date rDate = sdf.parse(replyDate);
        //Date를 Calendar타입으로 변경
        Calendar rCalendar = Calendar.getInstance();
        rCalendar.setTime(rDate);

        //현재 시간에서 작성한 시간을 밀리초(getTime())로 변환하여 차이를 구한다.
        long gap = today.getTime() - rDate.getTime();

        int h = rCalendar.get(Calendar.HOUR_OF_DAY);
        int mm = rCalendar.get(Calendar.MINUTE);
        int s = rCalendar.get(Calendar.SECOND);

        int y = rCalendar.get(Calendar.YEAR);
        int m = rCalendar.get(Calendar.MONTH) + 1;
        int d = rCalendar.get(Calendar.DATE);

        String time = null;
        if(gap < 1000 * 60 * 60 * 24){ //시 분 초
//            1의 자리 수는 앞에 0을 붙인다.
            time = (h < 10 ? "0" : "") + h + ":" + (mm < 10 ? "0" : "") + mm + ":" + (s < 10 ? "0" : "") + s;
        }else{ //년 월 일
//            1의 자리 수는 앞에 0을 붙인다.
            time = y + "-" + (m < 10 ? "0" : "") + m + "-" + (d < 10 ? "0" : "") + d;
        }
        return time;
    }
}
