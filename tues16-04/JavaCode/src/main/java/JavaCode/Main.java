package JavaCode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        //Coach myCoach= context.getBean("myCoach", Coach.class);

        Coach sCoach = context.getBean("sCoach", Coach.class);
        System.out.println(sCoach.getDailyWork());
        System.out.println(sCoach.getDailyFortune());

//        Coach fCoach = context.getBean("fCoach", Coach.class);
//        System.out.println(fCoach.getDailyWork());
//        System.out.println(fCoach.getDailyFortune());
//        if(myCoach instanceof FootballCoach){
//            FootballCoach fCoach = (FootballCoach) myCoach;
//            System.out.println("coach name: "+fCoach.getName());
//            System.out.println("coach email: "+fCoach.getEmail());
//        }

        context.close();

    }
}