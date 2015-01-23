package za.co.acme.projects.android.template.screens.city.create;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import za.co.acme.projects.android.template.R;
import za.co.acme.projects.android.template.data.models.City;
import za.co.acme.projects.android.template.screens.city.list.ItemListActivity;


public class AddCityActivity extends Activity {

    Button addCityAction;
    EditText addCityInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
        addCityAction = (Button) findViewById(R.id.action_save_city);
        addCityAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCityInput = (EditText) findViewById(R.id.add_city_name_input);
                String cityName = addCityInput.getText().toString();
                City city = new City(cityName);
                city.validateAndSave(AddCityActivity.this);
                startActivity(new Intent(AddCityActivity.this, ItemListActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_city, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
