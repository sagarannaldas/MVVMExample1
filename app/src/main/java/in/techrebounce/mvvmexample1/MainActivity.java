package in.techrebounce.mvvmexample1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import in.techrebounce.mvvmexample1.adapters.RecyclerAdapter;
import in.techrebounce.mvvmexample1.models.NicePlace;
import in.techrebounce.mvvmexample1.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView placesRecyclerView;
    private RecyclerAdapter recyclerAdapter;
    private FloatingActionButton fab;
    private ProgressBar mProgressBar;

    //viewmodel 1
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        placesRecyclerView = findViewById(R.id.places_recyclerview);
        mProgressBar = findViewById(R.id.progressBar);

        //viewmodel 2 new method.
        mainActivityViewModel = new ViewModelProvider(this) .get(MainActivityViewModel.class);

        //init values in viewmodel
        mainActivityViewModel.init();

        mainActivityViewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                recyclerAdapter.notifyDataSetChanged();
            }
        });

        mainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    showProgressBar();
                } else {
                    hideProgressBar();
                    placesRecyclerView.smoothScrollToPosition(mainActivityViewModel.getNicePlaces().getValue().size() - 1);
                }
            }
        });

        initRecyclerView();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityViewModel.addNewValue(new NicePlace("washington","https://i.imgur.com/ZcLLrkY.jpg"));
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
    }

    private void initRecyclerView() {
        placesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(this, mainActivityViewModel.getNicePlaces().getValue());
        placesRecyclerView.setAdapter(recyclerAdapter);
    }

    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }
}