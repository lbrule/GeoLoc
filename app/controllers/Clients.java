package controllers;

import java.io.IOException;

import models.Client;

import org.json.JSONException;
import org.json.JSONObject;

import play.mvc.Controller;

import com.simplegeo.client.SimpleGeoContextClient;

public class Clients extends Controller {

	public static void show(Long id) {
		Client client = Client.findById(id);
		System.out.println(client.getId());
		render(client);
	}

	public static void showJSON(Long id) throws IOException, JSONException {
		SimpleGeoContextClient client = new SimpleGeoContextClient();
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

		render(json2);

	}

	public static void delete(Long id) {
		Client client = Client.findById(id);
		client.delete();
		render(client);
	}

}