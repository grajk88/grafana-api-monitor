package com.tests.email;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import utils.MySQLBeans;
import utils.MySQLUpdateResults;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class EmailNotifications {
	


	@Test
	public void emailNotificationsTest() {

		try {
			
			given()
			.when().get("http://ergast.com/api/f1/2017/circuits.json")
			.then().assertThat().statusCode(200);
			
			float responseTime = given()
			.when().get("http://ergast.com/api/f1/2017/circuits.json").getTimeIn(TimeUnit.MILLISECONDS);
			
			MySQLBeans mySQLBeans = new MySQLBeans();
			mySQLBeans.setResponseTime(responseTime);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
