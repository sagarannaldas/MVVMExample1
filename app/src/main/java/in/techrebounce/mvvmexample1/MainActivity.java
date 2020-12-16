package in.techrebounce.mvvmexample1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import in.techrebounce.mvvmexample1.adapters.RecyclerAdapter;
import in.techrebounce.mvvmexample1.models.NicePlace;

public class MainActivity extends AppCompatActivity {

    private RecyclerView placesRecyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<NicePlace> nicePlaceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        placesRecyclerView = findViewById(R.id.places_recyclerview);

        initRecyclerView();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initRecyclerView() {
        placesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(this, nicePlaceList);
        placesRecyclerView.setAdapter(recyclerAdapter);
    }
}