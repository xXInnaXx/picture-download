import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.GoogleSearchPage;
import page.SearchResultsPage;

import java.io.IOException;
import java.net.URISyntaxException;

import static utils.Constants.*;

public class FirefoxPictureDownloaderTest {

    @BeforeAll
    static void setUpAll() {
        System.setProperty("selenide.browser", "firefox");
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        Configuration.downloadsFolder = DOWNLOAD_FOLDER;
    }

    @Test
    public void shouldDownloadPictureInFirefox() throws InterruptedException, IOException, URISyntaxException {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.goToGoogleSearch();
        googleSearchPage.searchUser(USER);

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.goToThirdPictureInPicturesTab();

        Thread.sleep(TIMEOUT_MS);

        searchResultsPage.findMaximizedPictureAndDownload();
    }

}
