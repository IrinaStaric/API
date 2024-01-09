import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;

public class Assertions {

    public static void assertCode(SoftAssertions softly, Response response) {
        softly.assertThat(response.getStatusCode()).as("Update Response Code").isEqualTo(201);
    }
    public static void assertId(SoftAssertions softly, Object actualId ){
       softly.assertThat(actualId).as("ID").isNotNull();
       softly.assertThat(actualId).as("ID should be an Integer").isInstanceOf(Integer.class);

    }
}
