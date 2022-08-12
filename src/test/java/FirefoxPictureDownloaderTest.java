import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.codeborne.selenide.Selenide.*;

public class FirefoxPictureDownloaderTest {
    @BeforeEach
    void setUp() {
        open("https://google.com/");
    }
    @BeforeAll
    static void setUpAll() {
        System.setProperty("selenide.browser", "firefox");
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        Configuration.downloadsFolder = "./test";
    }
    @Test
    public void shouldDownloadPictureInFirefox() throws InterruptedException, IOException, URISyntaxException {

        $("[aria-label='Найти']").setValue("Инна Хабирова").pressEnter();
        $("[data-hveid='CAEQAw']").click();
        $("[data-ri='2']").click();
        SelenideElement imgElement = $x("//body/div[2]/c-wiz[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/c-wiz[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]/img[1]");
        Thread.sleep(2000);
        File image = Selenide.download(imgElement.getAttribute("src"));
        Thread.sleep(2000);
        open();
        $("[class='btn ml-2']").click();
        $("[href='/xXInnaXx/picture-download/upload/main']");
    }

    }
