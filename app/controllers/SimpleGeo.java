package controllers;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import play.mvc.Controller;

import com.simplegeo.client.SimpleGeoContextClient;

public class SimpleGeo extends Controller {

	public static void arcgis() {

		render();

	}

	public static void showJSON(double lat, double lon) throws IOException,
			JSONException {
		SimpleGeoContextClient client = new SimpleGeoContextClient();
		client.getHttpClient().setToken("KaPVaH25Tee6LZF86tfp4Vuv5xmJxkTC",
				"TYXAansfrHVq6rbGLQdMN9wgMLDD96yL");

		String jsonString = client.getContext(lat, lon, null);

		JSONObject json = new JSONObject(jsonString);

		render(json);

	}

	public static void showWSJSON(double lat, double lon) throws IOException,
			JSONException {
		SimpleGeoContextClient client = new SimpleGeoContextClient();
		client.getHttpClient().setToken("KaPVaH25Tee6LZF86tfp4Vuv5xmJxkTC",
				"TYXAansfrHVq6rbGLQdMN9wgMLDD96yL");

		String jsonString = client.getContext(lat, lon, null);

		System.out.println("jsonString = " + jsonString);
		renderJSON(jsonString);

	}

}