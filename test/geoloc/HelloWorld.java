package geoloc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;

import com.simplegeo.client.SimpleGeoPlacesClient;
import com.simplegeo.client.types.Feature;
import com.simplegeo.client.types.FeatureCollection;

public class HelloWorld {
	public static void main(String[] args) {
		SimpleGeoPlacesClient placesClient = new SimpleGeoPlacesClient();
		placesClient.getHttpClient().setToken(
				"KaPVaH25Tee6LZF86tfp4Vuv5xmJxkTC",
				"TYXAansfrHVq6rbGLQdMN9wgMLDD96yL");

		HashMap<String, String[]> queryParams = new HashMap<String, String[]>();
		queryParams.put("category", new String[] { "sushi" });
		try {
			String sushiString = placesClient.search(37.800426, -122.439516,
					queryParams);
			FeatureCollection sushiFeatureCollection = FeatureCollection
					.fromJSONString(sushiString);
			ArrayList<Feature> sushiFeatures = sushiFeatureCollection
					.getFeatures();
			for (Feature feature : sushiFeatures) {
				System.out.println(feature.getProperties().get("name"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}