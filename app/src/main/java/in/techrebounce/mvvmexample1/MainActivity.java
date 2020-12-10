package in.techrebounce.mvvmexample1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

        placesRecyclerView = findViewById(R.id.places_recyclerview);

        initRecyclerView();

    }

    private void initRecyclerView() {
        placesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(this, nicePlaceList);
        placesRecyclerView.setAdapter(recyclerAdapter);
    }
}