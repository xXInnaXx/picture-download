package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static utils.Constants.TIMEOUT_MS;

public class SearchResultsPage {

    public void goToThirdPictureInPicturesTab(){
        $("[data-hveid='CAEQAw']").click();
        $("[data-ri='2']").click();
    }

    public void findMaximizedPictureAndDownload() throws IOException, URISyntaxException {
        SelenideElement imgElement = $x("//body/div[2]/c-wiz[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/c-wiz[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]/img[1]");
        File image = Selenide.download(imgElement.getAttribute("src"), TIMEOUT_MS);
    }
}
