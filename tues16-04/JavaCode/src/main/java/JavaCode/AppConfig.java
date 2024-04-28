package JavaCode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("JavaCode")
@PropertySource("classpath:values.properties")
public class AppConfig {

    @Bean
    public SwimmingCoach sCoach(){
        return new SwimmingCoach(sFortune());
    }

//    @Bean
//    public FootballCoach fCoach(){
//        return new FootballCoach();
//    }

    @Bean
    public SadFortune sFortune(){
        return new SadFortune();
    }



}
