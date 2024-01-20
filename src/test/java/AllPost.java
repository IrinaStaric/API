import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;

public class AllPost {
    private static final String post_add_Point = "/wp-json/wp/v2/posts";
    public static final String based_URL = "https://dev.emeli.in.ua/";

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = based_URL;
    }
    @Test
    public void validateFirstPost() {
        SoftAssertions softly = new SoftAssertions();
        Response response = when().get(post_add_Point);
        response.then();

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body().asString()).isNotEmpty();
        assertThat(response.jsonPath().getList("$")).hasSize(10);
        assertThat(response.jsonPath().getList("id")).allSatisfy(id ->
                softly.assertThat((Integer) id).isNotNull().isGreaterThan(0)
        );
        assertThat(response.jsonPath().getList("date")).allSatisfy(date ->
                softly.assertThat(date).isNotNull().isInstanceOf(String.class)
        );
        assertThat(response.jsonPath().getList("title.rendered")).allSatisfy(title ->
                softly.assertThat(title).isNotNull()
        );
    }
}
