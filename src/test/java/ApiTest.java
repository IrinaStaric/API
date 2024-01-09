import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class ApiTest {
    private ApiPage apiPage = new ApiPage();
    private static final String expectedTitle = "Article";
    private static final String expectedContent = "Content";
    private Object actualId;

    @Test
    public void createNewPostTest() {

        SoftAssertions softly = new SoftAssertions();
        Response response = apiPage.createNewPost(expectedTitle, expectedContent);
        Assertions.assertCode(softly, response);
        actualId = response.path("id");
        Assertions.assertId(softly, actualId);
        System.out.println("Response: " + response.getBody().asString());
        softly.assertAll();
    }
}
