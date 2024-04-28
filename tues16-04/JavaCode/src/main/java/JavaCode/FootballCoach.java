package JavaCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("myCoach")
//@Scope("prototype")
public class FootballCoach implements Coach{

    //@Autowired
   // @Qualifier("happyFortune")
     private FortunateService fortunateService;
    @Value("${name}")
     private String name;
    @Value("${email}")
     private String email;

    @Autowired
    public FootballCoach(FortunateService fs){
      //  System.out.println("constructor");
        this.fortunateService=fs;
    }

    public FootballCoach() {
      //  System.out.println("constructor");
    }

    @PostConstruct
    public void init(){
        //System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
        //System.out.println("destroy");
    }



    public FortunateService getFortunateService() {
        return fortunateService;
    }

    public void setFortunateService(FortunateService fortunateService) {
       // System.out.println("setter");
        this.fortunateService = fortunateService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDailyWork(){
        return "practice football";
    }

    @Override
    public String getDailyFortune(){
        return fortunateService.getDailyFortune();
    }

}
