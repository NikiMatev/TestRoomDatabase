package com.nikiprojecttestroom.testroom;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.nikiprojecttestroom.testroom.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
//    ArrayList<User> users;
    //private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        recyclerView = findViewById(R.id.recycle_view);

//        users = new ArrayList<>();
//        for (int i =0; i < 10; i++){
//            User user = new User("Nikolay #" +i,"Matev","n_matev@mail.bg" );
//            users.add(user);
//        }
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .build();
        List<User> users =  db.userDao().getAllUsers();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);



        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG,"onClick:pressed");
                startActivity(new Intent(MainActivity.this, CreateUser.class));
            }
        });


    }

    }
