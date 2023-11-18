package BasicTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//given-get inputs,when-submit API,then-validate API
		//add program
		RestAssured.baseURI="https://lms-backend-service.herokuapp.com/lms";
		
		String addProgramResponse=given()
			.log().all()
		  .header("Content-Type","application/json")
		  .body(Payload.AddProgram())
		 .when()
		 	.post("/saveprogram")
		 .then()
		 	//.log().all()
		 	.assertThat()
		 	.statusCode(201)
		 	.body("programStatus",equalTo("Active"))
		 	.header("server","Cowboy")
		 	.extract()
		 	.response()
		 	.asString();
		
		System.out.println(addProgramResponse);
		
		//add program-->update program-->get program to verify the updated program 
		
		//Take string as input and convert to actual Json(Parsed Json)
		JsonPath jp=new JsonPath(addProgramResponse);
		//extract program ID
		String getProgramId=jp.getString("programId");
			
		System.out.println(getProgramId);
		
		//Update Program
		
		String updateProgram=given()
			.log().all()
			 .header("Content-Type","application/json")
			.body("{ \"programName\": \"AnalyseOther\",\r\n"
					+ "    \"programDescription\": \"Using Lambda Expression\",\r\n"
					+ "    \"programStatus\": \"Active\",\r\n"
					+ "    \"creationTime\": \"2023-01-17T04:13:00.000+00:00\",\r\n"
					+ "    \"lastModTime\": \"2023-01-17T04:13:00.000+00:00\"}")
		.when()
			.put("/putprogram/"+getProgramId)
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body("programName", equalTo("AnalyseOther"))
			.extract()
			.response()
			.asString();
		
		//get new program name
		
		JsonPath jpa=new JsonPath(updateProgram);
		String newProgramName=jpa.getString("programName");
		
		given()
			.log().all()
		.when()
			.get("/programs/"+getProgramId)
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body("programName", equalTo(newProgramName));
		
	}

}
