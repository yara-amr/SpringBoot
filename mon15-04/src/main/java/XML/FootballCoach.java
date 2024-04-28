package XML;

public class FootballCoach implements Coach{

     private FortunateService fortunateService;
     private String name;
     private String email;

    public FootballCoach(FortunateService fs){
        System.out.println("constructor");
       // this.fortunateService=fs;
    }

    public FootballCoach() {
        System.out.println("constructor");
    }

    public void init(){
        System.out.println("init");
    }

    public void destroy(){
        System.out.println("destroy");
    }



    public FortunateService getFortunateService() {
        return fortunateService;
    }

    public void setFortunateService(FortunateService fortunateService) {
        System.out.println("setter");
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
