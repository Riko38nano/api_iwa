package api.route.apigateway;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {ApiGatewayApplication.class})
public class ApiGatewayApplicationTests {

    private WebClient webClient = new WebClient(BrowserVersion.CHROME);

    @Test
    public void testAvailableAccountMS() throws IOException {
        HtmlPage page = this.webClient.getPage("http://localhost:9090/api/users/");
        Assert.assertTrue(page.getBaseURI().contains("8081"));
    }

    @Test
    public void testAvailableRootMS() throws IOException {
        HtmlPage page = this.webClient.getPage("http://localhost:9090/");
        Assert.assertTrue(page.getBaseURI().contains("8080"));
    }

    @Test
    public void testAvailableCovidAlertMS() throws IOException {
        HtmlPage page = this.webClient.getPage("http://localhost:9090/alert/admin/");
        Assert.assertTrue(page.getBaseURI().contains("8082"));
    }
}
