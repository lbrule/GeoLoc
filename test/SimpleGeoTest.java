import org.junit.Test;

import play.mvc.Http.Response;
import play.test.FunctionalTest;

public class SimpleGeoTest extends FunctionalTest {

	@Test
	public void testSimpleGeoJSON() {
		Response response = GET("/SimpleGeo/showJSON?lat=39.624475&lon=-79.764951");
		assertIsOk(response);
		assertContentType("text/html", response);
		assertCharset(play.Play.defaultWebEncoding, response);
	}

	@Test
	public void testSimpleGeoWSJSON() {
		Response response = GET("/SimpleGeo/showWSJSON?lat=39.624475&lon=-79.764951");
		assertIsOk(response);
		assertContentType("application/json", response);
		assertCharset(play.Play.defaultWebEncoding, response);
	}

}