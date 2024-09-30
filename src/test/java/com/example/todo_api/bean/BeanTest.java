package com.example.todo_api.bean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    //스프링 컨테이너 생성
    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class); //어노테이션을 기반으로 한 설정파일 -> 스프링 컨테이너

    @Test //test 용도임을 명시
    public void getAllBeanTest(){
        //스프링 컨테이너를 설정 파일 정보를 이용해서 생성하고, 스프링 컨테이너 안에 있는 모든 빈을 조회하는 테스트

        //컨테이너 내 모든 bean 이름을 가져오게 함
        for (String name: context.getBeanDefinitionNames()){
            System.out.println(name);
        }

        //context 안에 myBean이 들어있는지 검증하는 코드
        //assertion은 무엇을 검증하게 해줌
        //예시에선 context의 bean 이름을 다 가져와서 "myBean"을 포함하고 있는지 아닌지 검증함
        //검증 조건에 부합하면 test가 잘 수행이 되고, 아니라면 error가 발생함
        Assertions.assertThat(context.getBeanDefinitionNames()).contains("myBean");
    }

    //스프링 컨테이너에 들어있는 것은 매번 반환할 때 같은 객체를 반환하는지 확인하는 테스트
    @Test
    public void getOneBeanTest(){
        MyBean myBean1 = context.getBean(MyBean.class); //type으로 조회
        MyBean mybean2 = context.getBean(MyBean.class);

        //sout이라는 축약어 사용가능
        System.out.println(myBean1);
        System.out.println(mybean2);

        //두 객체가 같은지 코드로 확인
        Assertions.assertThat(myBean1).isSameAs(mybean2);
    }

    @Test
    public void dependencyInjection(){
        MyBean myBean = context.getBean(MyBean.class);
        MySubBean mySubBean = context.getBean(MySubBean.class);

        System.out.println(myBean.getMySubBean());
        System.out.println(mySubBean);

        Assertions.assertThat(myBean.getMySubBean()).isSameAs(mySubBean);
    }
}
