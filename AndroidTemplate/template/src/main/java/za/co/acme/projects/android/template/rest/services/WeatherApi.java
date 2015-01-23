package za.co.acme.projects.android.template.rest.services;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import za.co.acme.projects.android.template.rest.models.WeatherResponse;

/**
 * Created by rishal on 15/01/20.
 */
public interface WeatherApi {

    @GET("/weather")
    void getWeather(@Query("q") String cityName, Callback<WeatherResponse> callback);

}
