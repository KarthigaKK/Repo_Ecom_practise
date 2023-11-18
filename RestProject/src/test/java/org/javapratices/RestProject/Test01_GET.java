package org.javapratices.RestProject;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Test01_GET {
	
	@Test
	public void test_01(){
		
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
		System.out.println(response.getHeader(baseURI));
		System.out.println(response.andReturn());
		
		Assert.assertEquals(response.getStatusCode(), 200);
}
	

	@Test
	public void test_02_Get(){
		
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data[1].id", equalTo(8)).
			body("data.first_name", hasItems("Lindsay","George"));
			
		
}
	@Test
	public void test_03_post()
	{
		Map<String,Object> data=new HashMap<>();
		data.put("name", "karthiga");
		data.put("job", "SDET lead");
		
		JSONObject request=new JSONObject();
		request.put("name", "karthiga");
		request.put("job", "SDET lead");
		
		System.out.println(request.toString());
		
		given().
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
					
}
@Test
	public void test_03_put()
	{
		Map<String,Object> data=new HashMap<>();
		data.put("name", "karthiga");
		data.put("job", "SDET lead");
		
		JSONObject request=new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "SDET Senior lead");
		
		System.out.println(request.toJSONString());
		
		given().
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200);
					
}

@Test
public void test_03_delete()
{
	Map<String,Object> data=new HashMap<>();
	data.put("name", "karthiga");
	data.put("job", "SDET lead");
	
	
	given().
		
	when().
		delete("https://reqres.in/api/users/2").
	then().
		statusCode(204);
				
}
}
