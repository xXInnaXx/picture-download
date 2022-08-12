package page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchPage {

    public void goToGoogleSearch(){
        open("https://google.com/");
    }

    public void searchUser(String user){
        $("[aria-label='Найти']").setValue(user).pressEnter();
    }
}
