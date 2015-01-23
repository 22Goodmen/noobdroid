package za.co.acme.projects.android.template.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import za.co.acme.projects.android.template.rest.services.WeatherApi;

/**
 * Created by rishal on 15/01/20.
 */
public class RestClient {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5";
    private WeatherApi weatherApi;

    public RestClient() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        weatherApi = restAdapter.create(WeatherApi.class);
    }

    public WeatherApi getWeatherApi() {
        return weatherApi;
    }

}
