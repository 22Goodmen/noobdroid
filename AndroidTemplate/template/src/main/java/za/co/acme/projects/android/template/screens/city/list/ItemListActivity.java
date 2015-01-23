package za.co.acme.projects.android.template.screens.city.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import za.co.acme.projects.android.template.R;
import za.co.acme.projects.android.template.screens.city.create.AddCityActivity;
import za.co.acme.projects.android.template.screens.city.detail.ItemDetailActivity;
import za.co.acme.projects.android.template.screens.city.detail.ItemDetailFragment;
import za.co.acme.projects.android.template.screens.settings.SettingsActivity;


/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link za.co.acme.projects.android.template.screens.city.detail.ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ItemListFragment} and the item details
 * (if present) is a {@link za.co.acme.projects.android.template.screens.city.detail.ItemDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link ItemListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ItemListActivity extends Activity
        implements ItemListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    //private WeatherLocationService weatherLocationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ItemListFragment) getFragmentManager()
                    .findFragmentById(R.id.item_list))
                    .setActivateOnItemClick(true);
        }

        /*City.deleteAll(City.class);
        City city1 = new City("Johannesburg", "234234", "234234");
        city1.save();
        City city2 = new City("Washington", "234234", "234234");
        city2.save();
        City city3 = new City("Paris", "234234", "234234");
        city3.save();

        for(City city : City.listAll(City.class)) {
            Log.i("WEATHERAPP", city.getName());
            Log.i("WEATHERAPP", String.valueOf(city.getId()));
        }*/

        //weatherLocationService = new WeatherLocationService(getApplicationContext());
        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link ItemListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add_city, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_city:
                startActivity(new Intent(ItemListActivity.this, AddCityActivity.class));
                return true;
            case R.id.action_current_location_weather:
                //Location location = weatherLocationService.getCurrentLocation();
                //Log.i("WEATHER_LOCATION", location.toString());
                return true;
            case R.id.action_settings:
                startActivity(new Intent(ItemListActivity.this, SettingsActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
