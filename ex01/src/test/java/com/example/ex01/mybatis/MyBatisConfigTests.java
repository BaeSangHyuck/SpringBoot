package com.example.ex01.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@Slf4j
public class MyBatisConfigTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testDataSource(){
//        try statement 문법 (외부 연결 객체 자동 close())
        try
                (
                        Connection conn = dataSource.getConnection();
                )
        {
            log.info("----------------------------------------------------------------------------------------------------------");
            log.info("datasource connection : " + conn);
            log.info("----------------------------------------------------------------------------------------------------------");

        } catch (Exception e){
            log.info(e.getMessage());
        }
    }

    @Test
    public void testSqlSession(){
        log.info("----------------------------------------------------------------------------------------------------------");
        log.info("SqlSessionFactory : " + sqlSessionFactory);
        log.info("----------------------------------------------------------------------------------------------------------");

        try
                (
                        SqlSession sqlSession = sqlSessionFactory.openSession(true);
                        Connection conn = sqlSession.getConnection();
                )
        {
            log.info("----------------------------------------------------------------------------------------------------------");
            log.info("SqlSession : " + sqlSession);
            log.info("SqlSession connection : " + conn);
            log.info("----------------------------------------------------------------------------------------------------------");

        } catch(Exception e){
            log.info(e.getMessage());
        }

    }
}













