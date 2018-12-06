package Managers;

public class AttributeHelper extends PageManager {

    public AttributeHelper (AppManager manager){super(manager.getDriver());}


    public String nameAs(){
        return accountPage.getName();
    }

    public String lastNameAs(){
        return accountPage.getLastName();
    }

    public String emailAs(){
       return accountPage.getEmail();
    }
}
