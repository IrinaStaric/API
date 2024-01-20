import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
public class ApiPage {
    private static final String BaseURI = "https://dev.emeli.in.ua/wp-json/wp/v2/posts";
    private static String Username = "username";
    private static String Password = "Password";

    public ApiPage() {
        initialize();
    }
    public ApiPage (String baseUri, String username, String password) {
        RestAssured.baseURI = baseUri;
        Username = username;
        Password = password;
        initialize();
    }
    private void initialize() {
        RestAssured.baseURI = BaseURI;
    }
    public Response createNewPost(String title, String content) {
        String requestBody = "{\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"content\": \"" + content + "\"\n" +
                "}";
        return RestAssured.given()
                .header("Content-Type", ContentType.JSON)
                .header("Authorization", "Basic " + getEncodedCredentials())
                .body(requestBody)
                .post();
                }
    private String getEncodedCredentials(){
        return new String(Base64.encodeBase64((Username + ":" + Password).getBytes()));
    }
}
