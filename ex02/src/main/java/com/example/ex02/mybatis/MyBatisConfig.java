package com.example.ex02.mybatis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@RequiredArgsConstructor
@MapperScan("com.example.ex02.mappers")
public class MyBatisConfig {
    //    커넥션 풀 및 MyBatis에 필요한 요소를 메모리에 할당 및 관리, xml과 java연동에 필요한 경로 관리
    private final ApplicationContext applicationContext;

    @Bean // 메소드의 리턴 객체를 스프링 컨테이너에 등록, @Configuration 또는 @Component가 작성된 클래스의 메소드에 사용
    @ConfigurationProperties(prefix = "spring.datasource.hikari") // 상위 경로 고정
//    application.properties에 작성된 #JDBC datasource 정보 설정
    public HikariConfig hikariConfig(){
        return new HikariConfig();
    }

    @Bean
//    dataSource 객체에 DBMS 정보 설정
    public DataSource dataSource(){
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean(); //세션 팩토리 설정 객체 생성
        sqlSessionFactoryBean.setDataSource(dataSource()); //위에서 설정한 datasource객체를 세션 팩토리 설정에 전달
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:/mappers/*.xml"));

        try {
            SqlSessionFactory factory = sqlSessionFactoryBean.getObject();
            factory.getConfiguration().setMapUnderscoreToCamelCase(true);
            return factory;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
