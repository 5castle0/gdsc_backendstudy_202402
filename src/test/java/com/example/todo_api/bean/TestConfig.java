package com.example.todo_api.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //다음 클래스를 스프링 컨테이너에 빈으로 등록해라(설정파일 작성)
@ComponentScan //@component를 찾아서 빈으로 등록 //main함수의 @SpringBootApplication에 포함되어 있기에 실제로 사용할 일은 없음
public class TestConfig {

//    @Bean //다음 반환되는 객체를 빈으로 등록해라
//    public MyBean myBean(){
//        return new MyBean();
//    }
}
