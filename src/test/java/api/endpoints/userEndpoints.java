package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import java.util.Map;

import org.testng.annotations.Test;

import api.payload.user;
import io.restassured.http.ContentType;


public class userEndpoints {

	public static Response createUser(user payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)

				.when()
				.post(Routes.postUrl)

		;
		return response;

	}
	
	
	
	public static Response readUser(String UserName) {

		Response response = given()
				.pathParam("username", UserName)
				.when()
				.get(Routes.getURl)

		;
		return response;

	}
	
	public static Response updateUser(String UserName, user payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", UserName)

				.when()
				.put(Routes.updateUrl)

		;
		return response;

	}
	
	public static Response deleteUser(String UserName) {

		Response response = given()
				.pathParam("username", UserName)
				.when()
				.get(Routes.deleteUrl)

		;
		return response;

	}
	
	
	
	
	
	
	
	
	
	
	
	

}
