package APITesting.MAMP;

import org.json.simple.JSONObject;
import org.junit.Test;

import Models.Product;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.hamcrest.beans.SamePropertyValuesAs;

public class APITest {
	
	@Test
	public void getProducts()
	{
		String endpoint="http://10.0.0.128/api_testing/product/read.php";
		ValidatableResponse response = RestAssured.given().when().get(endpoint).then()
				.log().headers()
				.assertThat()
				.header("Content-Type", equalTo("application/json; charset=UTF-8")).
				statusCode(200).body("records.size()", greaterThan(12)).
				body("records.id",everyItem(notNullValue()))
				.body("records.name", everyItem(notNullValue()))
				.body("records.description",everyItem(notNullValue()))
				.body("records.price", everyItem(notNullValue()))
				.body("records.category_id",everyItem(notNullValue()) );
		response.log().body();		
	}
	

	@Test
	public void getProduct()
	{
		String endpoint="http://10.0.0.128/api_testing/product/read_one.php";
		ValidatableResponse response = RestAssured.given().queryParam("id",2).get(endpoint).then().assertThat().
				statusCode(200).body("id", equalTo("2")).body("name", equalTo("Cross-Back Training Tank"))
				.body("description", equalTo("The most awesome phone of 2013!"))
				.body("price", equalTo("299.00"))
				.body("category_id", equalTo("2"))
				.body("category_name", equalTo("Active Wear - Women"));
		response.log().body();
	}
	@Test
	public void updateProduct()
	{
		String endpoint="http://10.0.0.128/api_testing/product/update.php";
		String payload="{\"id\": \"19\",\"name\":\"Water Bottle\",\"description\":\"Water Bottle blue ,120z\",\"price\":\"15.00\",\"category_id\":\"3\"}";
		ValidatableResponse response=RestAssured.given().body(payload).when().put(endpoint).then();
		response.log().body();
		
	}
	
	@Test
	public void createProduct()
	{
		String endpoint="http://10.0.0.128/api_testing/product/create.php";
		String body= "{\"name\" :\"Globe\",\"description\":\"Blue Globe\",\"price\":\"12\",\"category_id\":\"3\"}";
		/*
		 * JSONObject body=new JSONObject(); body.put("id", "18"); body.put("name",
		 * "water bottle"); body.put("description","Water bottle blue with 12oz");
		 * body.put("price","12"); body.put("category id", "3");
		 * body.put("category_name", "Active Wear - Unisex");
		 */
    
		
		
		
		ValidatableResponse response=RestAssured.given().body(body).when().post(endpoint).then();
		response.log().body();
		
	}
	
	@Test
	public void deleteProduct()
	{
		String endpoint="http://10.0.0.128/api_testing/product/delete.php";
		String body= "{\"id\" :\"23\"}";
		/*
		 * JSONObject body=new JSONObject(); body.put("id", "18"); body.put("name",
		 * "water bottle"); body.put("description","Water bottle blue with 12oz");
		 * body.put("price","12"); body.put("category id", "3");
		 * body.put("category_name", "Active Wear - Unisex");
		 */

		ValidatableResponse response=RestAssured.given().body(body).when().delete(endpoint).then();
		response.log().body();
		
	}
	
	//Serialize response body
	@Test
	public void createSerializedProduct()
	{
		String endpoint="http://10.0.0.128/api_testing/product/create.php";
		Product product=new Product("Rose","Nice Flower",12,3);
		
		ValidatableResponse response=RestAssured.given().body(product).when().get(endpoint).then();
		response.log().body();
		
	}
	
	//Create SweatBand Product
	@Test
	public void createSerializedProduct2()
	{
		String endpoint="http://10.0.0.128/api_testing/product/create.php";
		Product product=new Product("Sweatband","Its nice band for everyday use",5,3);
		
		RestAssured.given().body(product).when().get(endpoint).then().assertThat().statusCode(201);
		
		
	}
	
	//Update SweatBand Product
	@Test
	public void updateSerializedProduct()
	{
		String endpoint="http://10.0.0.128/api_testing/product/update.php";
		Product product=new Product(31,"Sweatband","Its nice band for everyday use",6,3,"Super");
		
		ValidatableResponse response=RestAssured.given().body(product).when().put(endpoint).then();
		response.log().body();
		
	}
	
	@Test
	public void getOneProductDetails()
	{
		String endpoint="http://10.0.0.128/api_testing/product/read_one.php";
		
		
		ValidatableResponse response=RestAssured.given().queryParam("id", 31).when().get(endpoint).then();
				 
		response.log().body();
		
	}
	
	@Test
	public void deleteProductDetails()
	{
		String endpoint="http://10.0.0.128/api_testing/product/delete.php";
		String body="{\"id\":28}";
		
		
		ValidatableResponse response=RestAssured.given().body(body).when().delete(endpoint).then();
		response.log().body();
		
	}
	


	 @Test
	    public void getDeserializedProduct(){
	        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
	        //"id":"2","name":"Cross-Back Training Tank","description":"The most awesome phone of 2013!","price":"299.00","category_id":"2","category_name":"Active Wear - Women"}
	        Product expectedProduct = new Product(
	                2,
	                "Cross-Back Training Tank",
	                "The most awesome phone of 2013!",
	                299.00,
	                2,
	                "Active Wear - Women"
	        );

	        Product actualProduct =
	            given().
	                queryParam("id", "2").
	            when().
	                get(endpoint).
	                    as(Product.class);

	        assertThat(actualProduct, samePropertyValuesAs(expectedProduct));
	    }

	 @Test
	 public void getMultiVitaminProduct()
	 {
		 String endpoint="http://10.0.0.128/api_testing/product/read_one.php";
		 
		 RestAssured.given().queryParam("id", "18").when().get(endpoint).then().log().headers().assertThat().statusCode(200)
		 .header("Content-Type", equalTo("application/json"))
		 .body("id", equalTo(18))
		 .body("name", equalTo("Multi-Vitamin (90 capsules)"))
		 .body("description",equalTo("A daily dose of our Multi-Vitamins fulfills a day’s nutritional needs for over 12 vitamins and minerals"))
		 .body("price", equalTo(10.00))
		 .body("category_id", equalTo(4))
		 .body("category_name",equalTo("Supplements"));
	 }
	
}
