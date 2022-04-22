package com.example.ex02.controllers;

import com.example.ex02.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Random;

@Controller // 스프링의 객체로 등록
@Slf4j
@RequestMapping("/ex/*") //현재 클래스 내에 모든 메소드들의 기본 경로 설정 (예: /ex/aaa, /ex/bbb 등)
public class ExampleController {

    @RequestMapping(value = "/example", method = {RequestMethod.GET, RequestMethod.POST})
    public void ex01() {
        log.info("ex01 get and post...........");
    }

    @RequestMapping(value = "/ex02", method = {RequestMethod.GET, RequestMethod.POST})
    public void ex02(HttpServletRequest request) {
        log.info("ex02 " + request.getMethod().toLowerCase() + ".............");
    }

    //    GET, POST 상관 없이 Controller 로직을 수행한다면 method 옵션을 사용하지 않는다.
//    value 속성 한 개만 사용할 때에는 아래와 같이 값만 전달한다.
    @RequestMapping("")
    public void ex03() {
        log.info("ex03.............");
    }

    @GetMapping("/ex04")
    public void ex04() {
        log.info("ex04 :: only get.............");
    }

    @GetMapping("/ex05")
//    전달받은 파라미터는 자동으로 매개변수의 객체와 mapping되어 주입된다.
//    리턴 타입이 void라면 요청한 URL의 경로로 html파일을 찾게 된다.
//    원하는 경로가 있다면 경로를 String으로 리턴한다.
    public void ex05(@ModelAttribute("exampleVO") ExampleVO exampleVO) {
//        @ModelAttribute("KEY") 자료형 매개변수
//        매개변수에 전달된 파라미터를 화면쪽에서 KEY로 사용할 수 있게 된다.

        log.info("-----------------------------");
        log.info(exampleVO.toString());
        log.info("-----------------------------");
    }

    @GetMapping("/ex06")
//    매개변수자리에 클래스타입의 매개변수가 한 개 선언되어 있다면 앞글자만 소문자로 바뀐 값을
//    화면에서 KEY로 사용할 수 있다. 이 때에는 따로 Model 객체를 사용하지 않는다.
//    매개변수 : ExampleVO
//    화면 : exampleVO
    public void ex06(ExampleVO exampleVO, @ModelAttribute("gender") String gender) {
        log.info("-----------------------------");
        log.info(exampleVO.toString());
        log.info("gender : " + gender);
        log.info("-----------------------------");
    }

    //    외부에서 4개의 파라미터를 전달받은 후 화면에 전부 출력
    @GetMapping("/ex07")
    public String ex07(ExampleVO exampleVO, String gender, double weight, Model model) {

        log.info("-----------------------------");
        log.info(exampleVO.toString());
        log.info("gender : " + gender);
        log.info("weight : " + weight);
        log.info("-----------------------------");

        model.addAttribute("gender", gender);
        model.addAttribute("weight", weight);
        return "ex07";
    }

    //    ex/ex08 요청에 실행될 메소드 선언
//    GET 방식
    @GetMapping("/ex08")
    public void ex08(TaskVO taskVO, Model model) {
//        int total = taskVO.getMath()+taskVO.getEng()+taskVO.getKor();
//        double avgInt =total/3.0;
//        double avg = Math.round(avgInt*100)/100.0;

        log.info("-----------------------------");
        log.info(taskVO.toString());
//        log.info("total : " + total);
//        log.info("avg : " + avg);
        log.info("-----------------------------");
//        model.addAttribute("total",total);
//        model.addAttribute("avg",avg);
    }

    @GetMapping("/ex09")
    public void ex09(ExampleVO exampleVO, @ModelAttribute("gender") @RequestParam("data") String gender, Model model){
        log.info("-----------------------------");
        log.info(exampleVO.toString());
        log.info("gender : " + gender);
        log.info("-----------------------------");
        model.addAttribute("gender",gender);
    }

    @GetMapping("/ex10")
    public void ex10(@ModelAttribute("gender") @RequestParam("data") String gender, Model model){
        model.addAttribute("gender",gender);
    }

//    실습1
    /*
     *   아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
     *   아이디가 user일 경우 user.html로 이동
     *
     *   login.html : 아이디와 비밀번호 입력 페이지 출력
     *   admin.html : 관리자 페이지 출력
     *   user.html : 일반 회원 페이지 출력
     */

    @GetMapping("/login")
    public String login() {
        return "app/task01/login";
    }

    @PostMapping("/login")
    public String login(LoginDTO loginDTO) {
        return loginDTO.getId().equals("admin") ? "app/task01/admin" : "app/task01/user";
    }

    @GetMapping("/ex11")
    public void ex11(){}

    @PostMapping("/ex11")
    public String ex11(LoginDTO loginDTO){
        return loginDTO.getId().equals("user") ? "ex/ex12":"ex/ex13";
    }

    // 실습2
    /*
     *   이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
     *   출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
     *   출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
     *   퇴근 버튼 클릭 시 17시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
     *
     *   - getToWork.html
     *   - leaveWork.html
     *   - late.html
     *   - work.html
     */
    @GetMapping("/office")
    public String office() {
        return "app/task02/office";
    }

    @GetMapping("/getToWork")
    public String getToWork(@ModelAttribute("name") String name) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        boolean lateCheck = hour >= 9 && minute > 0;

        return "app/task02/" + (lateCheck ? "late" : "getToWork");

    }

    @GetMapping("/leaveWork")
    public String leaveWork(@ModelAttribute("name") String name) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        boolean leaveWorkCheck = hour >= 17 && minute >= 0;

        return "app/task02/" + (leaveWorkCheck ? "leaveWork" : "work");
    }

//    실습3
    /*
     *   무기를 강화하기 위해 아래에 있는 강화 주문서를 사용할 수 있다.
     *
     *   10% 공격력 주문서 : 공격력 + 80
     *   60% 공격력 주문서 : 공격력 + 40
     *   100% 공격력 주문서 : 공격력 + 10
     *
     *   한 번만 강화할 수 있으며, 10% 확률로 대성공을 한다.
     *   대성공 시 해당 주문서 공격력의 5배가 증가한다.
     *
     *   강화하기 버튼을 눌렀을 때 알맞는 결과를 출력한다.
     *
     *   fail.html
     *   success.html
     *   superSuccess.html
     *
     */

    @GetMapping("/upgrade")
    public String upgrade(){
        return "app/task03/shop";
    }

    @PostMapping("/upgrade")
    public String upgrade(WeaponVO weaponVO, int choice, Model model){
        ScrollVO scroll = new ScrollVO();
        boolean result = false;
        int attack = weaponVO.getAttack();
        String path = "app/task03/fail";

        switch (choice){
            case 1:
                result = getChance(1);
                attack = scroll.getScroll_10();
                break;
            case 2:
                result = getChance(6);
                attack = scroll.getScroll_60();
                break;
            case 3:
                result = getChance(10);
                attack = scroll.getScroll_100();
                break;
        }
        if(result){
            if(getChance(1)){
                attack *= 5;
                weaponVO.setAttack(attack);
                model.addAttribute("attack", weaponVO.getAttack());
                path="app/task03/superSuccess";
            }else {
                weaponVO.setAttack(attack);
                model.addAttribute("attack", weaponVO.getAttack());
                path="app/task03/success";
            }
        }
        model.addAttribute("attack", weaponVO.getAttack());
        return path;
    }

    private boolean getChance(int rating){
        int[] numbers = new int[10];
        Random r = new Random();

        for (int i=0; i < rating; i++){
            numbers[i] = 1;
        }

        return numbers[r.nextInt(numbers.length)] == 1;
    }
}
