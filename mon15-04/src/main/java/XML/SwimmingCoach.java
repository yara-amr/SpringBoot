package XML;

public class SwimmingCoach implements Coach{

    FortunateService fortunateService;

    public SwimmingCoach(FortunateService fs){
        this.fortunateService=fs;
    }

    public String getDailyWork(){
        return "practice swimming";
    }
    public String getDailyFortune(){
        return fortunateService.getDailyFortune();
    }

}
