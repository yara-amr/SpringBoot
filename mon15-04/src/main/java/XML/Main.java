package XML;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // create context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file.xml");

        // get bean by id
        Coach myCoach= context.getBean("football", Coach.class);

        // invoke bean business
        System.out.println(myCoach.getDailyWork());
        System.out.println(myCoach.getDailyFortune());
        if(myCoach instanceof FootballCoach){
            FootballCoach fCoach = (FootballCoach) myCoach;
            System.out.println("coach name: "+fCoach.getName());
            System.out.println("coach email: "+fCoach.getEmail());
        }
        System.out.println("-------------------------------------");

//        Coach swimCoach= context.getBean("swimming", Coach.class);
//
//        // invoke bean business
//        System.out.println(swimCoach.getDailyWork());
//        System.out.println(swimCoach.getDailyFortune());

        context.close();

    }
}