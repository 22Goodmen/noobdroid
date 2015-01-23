package za.co.acme.projects.android.template.data.models;

import android.content.Context;
import android.widget.Toast;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;
import za.co.acme.projects.android.template.data.helpers.AbstractDataModel;


/**
 * Created by rishal on 15/01/07.
 */
public class City extends AbstractDataModel<City> {

    @NotNull
    @Size(min = 1)
    String name;
    String longitude;
    String latitude;

    public City() {
        super();
    }

    public City(String name) {
        super();
        this.name = name;
    }

    public City(String name, String longitude, String latitude) {
        super();
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return name;
    }

    public void validateAndSave(Context context) {
        if (isValid()) {
            this.save();
            Toast.makeText(context, name + " has been saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Could not saved", Toast.LENGTH_SHORT).show();
        }
    }
}
