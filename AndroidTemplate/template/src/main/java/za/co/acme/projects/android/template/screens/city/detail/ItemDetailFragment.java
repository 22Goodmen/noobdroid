package za.co.acme.projects.android.template.screens.city.detail;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import za.co.acme.projects.android.template.R;
import za.co.acme.projects.android.template.data.models.City;
import za.co.acme.projects.android.template.rest.RestClient;
import za.co.acme.projects.android.template.rest.models.Weather;
import za.co.acme.projects.android.template.rest.models.WeatherResponse;

import java.util.List;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link za.co.acme.projects.android.template.screens.city.list.ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private City mItem;

    /**
     * The controls on the layout for this fragment.
     */
    TextView textViewName;
    ImageView imageViewIcon;
    TextView textViewDescription;

    ProgressDialog progress;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = City.findById(City.class, Long.valueOf((String) getArguments().get(ARG_ITEM_ID)));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        textViewName = (TextView) rootView.findViewById(R.id.city_detail_name);
        imageViewIcon = (ImageView) rootView.findViewById(R.id.city_detail_icon);
        textViewDescription = (TextView) rootView.findViewById(R.id.city_detail_description);

        progress = new ProgressDialog(ItemDetailFragment.this.getActivity());
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.show();

        if (mItem != null) {
            populateViewForCity(mItem);
        }

        return rootView;
    }

    private void populateViewForCity(final City city) {

        RestClient restClient = new RestClient();
        restClient.getWeatherApi().getWeather(city.getName(), new Callback<WeatherResponse>() {
            @Override
            public void success(WeatherResponse weatherResponse, Response response) {
                List<Weather> weathers = weatherResponse.getWeather();
                String weatherApiUrl = ItemDetailFragment.this.getActivity().getPreferences(Context.MODE_PRIVATE).getString(getString(R.string.pref_title_display_weather_url), getString(R.string.pref_default_display_weather_url));
                for (Weather weather : weathers) {
                    textViewName.setText(city.getName());
                    Picasso.with(ItemDetailFragment.this.getActivity()).load(weatherApiUrl + weather.getIcon()).into(imageViewIcon);
                    textViewDescription.setText(weather.getDescription());
                }
                progress.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("App", "o, man! " + error.getMessage());
            }
        });

    }
}
