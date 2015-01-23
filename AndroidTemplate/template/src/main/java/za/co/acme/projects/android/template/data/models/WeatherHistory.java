package za.co.acme.projects.android.template.data.models;

import za.co.acme.projects.android.template.data.helpers.AbstractDataModel;

import java.util.Date;

/**
 * Created by rishal on 15/01/07.
 */
public class WeatherHistory extends AbstractDataModel<WeatherHistory> {

    City city;
    String description;
    Date timestamp;

    public WeatherHistory() {
        super();
    }

    public WeatherHistory(String description, City city, Date timestamp) {
        super();
        this.description = description;
        this.city = city;
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
