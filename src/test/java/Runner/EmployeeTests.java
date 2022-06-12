package Runner;

import org.testng.annotations.Test;

import Payloads.PayLoads;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class EmployeeTests extends Base {

	String response;
	JsonPath jsonPath;
	@Test
	public void createEmployee() {
		response = Post("/create", PayLoads.getCreateEmployeePayload()).then().log().all().extract().response()
				.asString();
		jsonPath=new JsonPath(response);
		Assert.assertEquals(jsonPath.getString("status"), "success");
	}
	
	@Test
	public void getAllEmployeeDetails() {
		response=Get("employees").then().log().all().extract().response().asString();
		jsonPath=new JsonPath(response);
		Assert.assertEquals(jsonPath.getString("status"), "success");
	}
}
