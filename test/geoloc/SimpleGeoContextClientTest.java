package geoloc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import play.test.UnitTest;

import com.simplegeo.client.SimpleGeoContextClient;
import com.simplegeo.client.SimpleGeoPlacesClient;
import com.simplegeo.client.callbacks.SimpleGeoCallback;
import com.simplegeo.client.types.Feature;
import com.simplegeo.client.types.FeatureCollection;

public class SimpleGeoContextClientTest extends UnitTest {

	@Test
	public void test() throws IOException, JSONException {
		com.simplegeo.client.SimpleGeoContextClient client = new SimpleGeoContextClient();
		// client.getHttpClient().setToken(TestEnvironment.getKey(),
		// TestEnvironment.getSecret());
		client.getHttpClient().setToken("KaPVaH25Tee6LZF86tfp4Vuv5xmJxkTC",
				"TYXAansfrHVq6rbGLQdMN9wgMLDD96yL");
		// System.out.println(client.getContextByIP("", null));
		String jsonString = client.getContextByIP("", null);
		JSONObject json = new JSONObject(jsonString);

		System.out.println("json = " + json);

		jsonString = client.getContextByAddress(
				"1 rue Edouard VAillant, 33600 PESSAC", null);
		System.out.println("jsonString = " + jsonString);
		json = new JSONObject(jsonString);

		System.out.println("json = " + json);

		jsonString = client.getContext(39.624475, -79.764951, null);

		JSONObject json2 = new JSONObject(jsonString);

		System.out.println("json2 = " + json2);
		System.out.println(json.equals(json2));

	}

	public static void main(String[] args) {
		SimpleGeoPlacesClient client = new SimpleGeoPlacesClient();
		client.getHttpClient().setToken("KaPVaH25Tee6LZF86tfp4Vuv5xmJxkTC",
				"TYXAansfrHVq6rbGLQdMN9wgMLDD96yL");
		try {
			HashMap<String, String[]> queryParams = new HashMap<String, String[]>();
			queryParams.put("radius", new String[] { "25" });
			client.searchByIP(queryParams, new SimpleGeoCallback() {
				public void onSuccess(String jsonResponse) {
					FeatureCollection collection = null;
					try {
						collection = FeatureCollection
								.fromJSONString(jsonResponse);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ArrayList<Feature> features = collection.getFeatures();
					for (Feature feature : features) {
						System.out.println("TEST = "
								+ feature.getProperties().get("name"));
					}
				}

				public void onError(String errorMessage) {
					System.out.println(errorMessage);
				}
			});
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
