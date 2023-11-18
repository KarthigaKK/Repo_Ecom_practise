import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="http://localhost:8080";
		
		SessionFilter session=new SessionFilter();
		
	String response=	given().log().all().header("Content-Type","application/json").body("{\r\n"
				+ "    \"username\": \"karthiga\",\r\n"
				+ "    \"password\": \"Wolf123@\"\r\n"
				+ "}").filter(session).post("/rest/auth/1/session").then().log().all().extract().response().asString();
		
	System.out.println(response);
		given().log().all().pathParam("id", "10002").header("Content-Type","application/json").body("{\r\n"
				+ "    \"body\": \"Comment updated from rest api\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/{id}/comment").then().statusCode(201).log().all().extract().response().asString();

	}

}
