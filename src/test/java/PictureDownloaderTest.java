import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.codeborne.selenide.Selenide.*;

public class PictureDownloaderTest {

    @BeforeAll
    static void setUpAll() {
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        Configuration.downloadsFolder = "./test";
    }

    @BeforeEach
    void setUp() {
        open("https://google.com/");

    }

    @Test
    public void shouldDownloadPicture() throws InterruptedException, IOException, URISyntaxException {

        $("[aria-label='Найти']").setValue("Инна Хабирова").pressEnter();
        $("[data-hveid='CAEQAw']").click();
        $("[data-ri='2']").click();
        SelenideElement imgElement = $x("//body/div[2]/c-wiz[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/c-wiz[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]/img[1]");
        File image = Selenide.download(imgElement.getAttribute("src"));
        Thread.sleep(2000);
    }

}
