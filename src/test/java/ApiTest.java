import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class ApiTest {
    private final ApiPage apiPage = new ApiPage();
    private static final String expectedTitle = "Article";
    private static final String expectedContent = "Content";
    private Object actualId;

    @Test
    public void createNewPostTest() {
        SoftAssertions softly = new SoftAssertions();
        Response response = apiPage.createNewPost(expectedTitle, expectedContent);
        // Print response details
        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assertions.assertCode(softly, response);
        actualId = response.path("id");
        Assertions.assertId(softly, actualId);

        softly.assertAll();
 }
}
