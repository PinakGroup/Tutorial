package sqlite.list.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nimgade.pk.mytutorialapplication.R;

import java.util.ArrayList;

import model.classes.MyListItem;

public class SqliteListActivity extends AppCompatActivity {

    private ListView listView;

    /* Difference between IntentService and Service
     * with {@link android.app.IntentService} you can make your multiple request run in a queue,
     * where next task will wait for the current running task to get over(finish)<br></>
     * <p/>
     * with {@link android.app.Service} you can perform multiple requests simultaneously. <br>
     * in  onStartCommand(), you can create a new thread for each request and run them right away (instead of waiting for the previous request to finish).
     * </>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_custom_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeUI();
    }

    private void initializeUI() {

        listView = (ListView) findViewById(R.id.SqliteListActivity_listView);

        ArrayList<MyListItem> myListItems = new ArrayList<>();
        myListItems.add(new MyListItem("SQLite Test One", SqliteTestOneActivity.class));

        ArrayAdapter<MyListItem> adapter =
                new ArrayAdapter<MyListItem>(getApplicationContext(), R.layout.simple_list_item_1, myListItems);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyListItem single = (MyListItem) listView.getItemAtPosition(position);
                Intent my_Intent = new Intent(getApplicationContext(), single.getActivity_class());
                startActivity(my_Intent);
            }
        });

    }

}
