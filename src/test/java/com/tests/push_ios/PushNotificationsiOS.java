package com.tests.push_ios;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import utils.MySQLBeans;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class PushNotificationsiOS {

	@Test
	public void pushNotificationsiOS() {

		try {

			given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat().statusCode(200).and()
					.contentType(ContentType.JSON).and().header("Content-Length", equalTo("4551"));

			float responseTime = given().when().get("http://ergast.com/api/f1/2017/circuits.json")
					.getTimeIn(TimeUnit.MILLISECONDS);

			MySQLBeans mySQLBeans = new MySQLBeans();
			mySQLBeans.setResponseTime(responseTime);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
