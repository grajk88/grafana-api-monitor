package com.tests.push_android;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import utils.MySQLBeans;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class PushNotificationsAndroid {

	@Test
	public void pushNotificationsAndroid() {

		try {
			
			ValidatableResponse response = given()
			.when().get("http://ergast.com/api/f1/2017/circuits.json")
			.then().assertThat().statusCode(200)
			.and()
			.contentType(ContentType.JSON).and().header("Content-Length", equalTo("4551"));
						
			float responseTime = given()
					.when().get("http://ergast.com/api/f1/2017/circuits.json").getTimeIn(TimeUnit.MILLISECONDS);
					
					MySQLBeans mySQLBeans = new MySQLBeans();
					mySQLBeans.setResponseTime(responseTime);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
