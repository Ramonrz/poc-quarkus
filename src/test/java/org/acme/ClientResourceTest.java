package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.Response.Status;

import org.acme.enums.PersonType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientResourceTest {

	private static String create = "{\n" 
			+ "\"name\": \"Klarck Moore\",\n" 
			+ "\"personType\": \"LEGAL_PERSON\",\n"
			+ "  \"taxIdNumber\": \"960.075.040-85\"\n" + "}";
	
	private static String update = "{\n" 
			+ "\"name\": \"Klarck Moore\",\n" 
			+ "\"personType\": \"NATURAL_PERSON\",\n"
			+ "  \"taxIdNumber\": \"960.075.040-85\"\n" + "}";
			
	@Test
	@Order(1)
	void testCreate() {

		given()
		.contentType(ContentType.JSON)
		.body(create)
		.post("/clients")
		.then()
		.statusCode(Status.CREATED.getStatusCode())
		.extract()
		.response();
	}
	
	@Test
	@Order(2)
	void testList() {
		
		given()
		 .when()
	     .get("/clients")
	     .then()
	     .statusCode(Status.OK.getStatusCode())
	     .body("size()", is(1));
	}
	
	@Test
	@Order(3)
	void testById() {
		
		given()
		 .when()
		 .get("/clients/{id}", 1)
		 .then()
		 .statusCode(Status.OK.getStatusCode())
		 .body("get('name')", is("Klarck Moore"));
	}
	
	@Test
	@Order(4)
	void testUpdate() {
		
		given()
		 .contentType(ContentType.JSON)
		 .body(update)
		 .put("/clients/{id}", 1)
		 .then()
		 .statusCode(Status.OK.getStatusCode())
		 .body("get('personType')", is(PersonType.NATURAL_PERSON.name()));
	}
	
	@Test
	@Order(5)
	void testDelete() {
		
		given()
		 .delete("/clients/{id}", 1)
		 .then()
		 .statusCode(Status.NO_CONTENT.getStatusCode());
	}

}