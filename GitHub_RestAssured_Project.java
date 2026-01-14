package Example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

public class GitHub_RestAssured_Project {
	
	private RequestSpecification requestSpec;
    private String sshKey;
    private int sshKeyId;
    private final String GITHUB_TOKEN = "";

    @BeforeClass
    public void setup() {
        sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBp52M1e1g4PHCZQl/Ks6NbKgmcq7mcLRt0bsR43MoVL azuread\\\\charishmae@IBM-PF42MMJN";

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + GITHUB_TOKEN)
                .build();
    }

    @Test(priority = 1)
    public void postRequestTest() {
        Map<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("title", "TestAPIKey");
        bodyParams.put("key", sshKey); 

        Response response = given()
                .spec(requestSpec)
                .body(bodyParams)
                .when()
                .post("/user/keys");

        if (response.getStatusCode() != 201) {
            System.out.println("Detailed Error: " + response.asPrettyString());
        }

        Assert.assertEquals(response.getStatusCode(), 201, "JSON parsing failed or key is invalid.");

        sshKeyId = response.then().extract().path("id");
        Reporter.log("Successfully added SSH Key with ID: " + sshKeyId);
    }
    
    @Test(priority = 2, dependsOnMethods = "postRequestTest")
    public void getRequestTest() {
        Response response = given()
                .spec(requestSpec)
                .pathParam("keyId", sshKeyId)
                .when()
                .get("/user/keys/{keyId}");

        Reporter.log("GET Response: " + response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200, "GET status code should be 200");
        Assert.assertEquals((int)response.path("id"), sshKeyId, "IDs do not match!");
    }

    @Test(priority = 3, dependsOnMethods = "getRequestTest")
    public void deleteRequestTest() {
        Response response = given()
                .spec(requestSpec)
                .pathParam("keyId", sshKeyId)
                .when()
                .delete("/user/keys/{keyId}");

        Reporter.log("DELETE Response Status: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 204, "DELETE status code should be 204");
    }
}