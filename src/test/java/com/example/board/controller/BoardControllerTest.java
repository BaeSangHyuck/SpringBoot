package com.example.board.controller;


import com.example.board.BoardApplication;
import com.example.board.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


// JUnit5 사용
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BoardApplication.class})
@Slf4j
public class BoardControllerTest {

//    가짜 MVC
//    마치 브라우저에서 URL을 요청한 것 처럼 환경을 만들어준다.
    private MockMvc mockMvc;

//    사용자의 요청을 처리해주는 WebApplicationContext를 불러온다.
    @Autowired
    public WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//    @Test
//    public void testModifyGet() throws Exception{
//        String responseURI = mockMvc.perform(MockMvcRequestBuilders.get("/board/modify")
//                .param("bno",String.valueOf(11))).andReturn().getModelAndView().getViewName();
//        log.info(responseURI);
//    }

//    @Test
//    public void testReadGet() throws Exception{
//        String responseURI = mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
//                .param("bno",String.valueOf(11))).andReturn().getModelAndView().getViewName();
//        log.info(responseURI);

//    }


//    @Test
//    public void testRegisterGet() throws Exception{
//        String responseURI = mockMvc.perform(MockMvcRequestBuilders.get("/board/register")).andReturn().getModelAndView().getViewName();
//        log.info(responseURI);
//    }



//    @Test
//    public void testModify() throws Exception{
//        String checkModify = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//                .param("bno", String.valueOf(10L))
//                .param("title","수정된 테스트 제목스")
//                .param("content","수정된 테스트 내용")).andReturn().getFlashMap().toString();
//        log.info(checkModify);
//    }


//    @Test
//    public void testRemove() throws Exception{
//        String removeCheck = mockMvc.perform(MockMvcRequestBuilders.get("/board/remove").param("bno", String.valueOf(13L))).andReturn().getFlashMap().toString();
//        log.info(removeCheck);
//    }




//    @Test
//    public void checkReade() throws  Exception{
//        String readCheck = mockMvc.perform(MockMvcRequestBuilders.get("/board/read").param("bno", String.valueOf(14L))).andReturn().getModelAndView().getModelMap().toString();
//        log.info(checkReade);
//    }


//    @Test
//    public void testRegister() throws Exception{
//        String checkBno = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//                .param("title","테스트 새 글 제목")
//                .param("content","테스트 새 글 내용")
//                .param("writer","hds1234")
//        ).andReturn().getFlashMap().toString();
//        log.info(checkBno);
//    }


    @Test
    public void testList() throws Exception{
//        perform(method방식()) : 해당 요청을 전달해주는 메소드
//        get("URL") : get method 방식으로 해당 URL 요청
//        post("URL") : post method 방식으로 해당 URL 요청
//        andReturn() : 요청 결과 객체 가져오기
//        getModelAndView() : 화면의 경로 또는 Model 데이터 전달자의 파라미터 확인
//        getModelMap() Model 데이터 전달자에 추가해놓은 파라이머틀 Map 구조로 확인 가능
       log.info( mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
               .param("pageNum","1")
               .param("amount","10")
               .param("type","T")
               .param("keyword","상혁"))
               .andReturn().getModelAndView().getModelMap().toString());
    }

}


