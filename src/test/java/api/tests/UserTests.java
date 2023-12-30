package api.tests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndpoints;
import api.payload.user;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	user userPayload;
	
	@BeforeClass
	
	public void setupData() {
	faker=new Faker();
	userPayload=new user();
	
	userPayload.setId(faker.idNumber().hashCode());
	userPayload.setUsername(faker.name().username());	
	userPayload.setFirstName(faker.name().firstName());
	userPayload.setLastName(faker.name().lastName());
	userPayload.setEmail(faker.internet().safeEmailAddress());
	userPayload.setPassword(faker.internet().password(5, 10));
	userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
	}
	
	@Test(priority=1)
	public void testPostUser() {
	Response	response=userEndpoints.createUser(userPayload);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGetUserByUsername() {
	Response	response=userEndpoints.readUser(this.userPayload.getUsername());
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	@Test(priority=3)
	public void testUpdateUser() {
		
		
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response	response=userEndpoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		
	}
	
	
	@Test(priority=4)
	public void testDeleteUserByName() {
	Response response=	userEndpoints.deleteUser(this.userPayload.getUsername());
	}
	
	
	
	
	
	
	
}
