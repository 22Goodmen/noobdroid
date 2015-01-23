package za.co.acme.projects.android.template.rest.models;

import java.util.List;

/**
 * Created by rishal on 15/01/20.
 */
public class WeatherResponse {

    private int cod;
    private String base;
    private List<Weather> weather;

    public WeatherResponse() {
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

}
