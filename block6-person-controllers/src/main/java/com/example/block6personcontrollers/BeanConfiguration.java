package com.example.block6personcontrollers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    //Generamos los 3 bean para crear un conflicto donde el programa no sepa cuál elegir
    //Nótese que los nombres y datos son absurdos y simplemente por rellenar
    //Usamos setter tras crear un constructor normal porque por razones técnicas avanzadas Spring Boot ignora el new
    @Bean
    public PersonBean bean1() {
        PersonBean personBean = new PersonBean();
        personBean.setName("Antonio");
        personBean.setCity("Málaga");
        personBean.setAge(2000);
        return personBean;
    }

    @Bean
    public PersonBean bean2() {
        PersonBean personBean = new PersonBean();
        personBean.setName("Jaskier");
        personBean.setCity("Cualquiera");
        personBean.setAge(30);
        return personBean;
    }

    @Bean
    public PersonBean bean3() {
        PersonBean personBean = new PersonBean();
        personBean.setName("Geralt");
        personBean.setCity("Rivia");
        personBean.setAge(50);
        return personBean;
    }
}
