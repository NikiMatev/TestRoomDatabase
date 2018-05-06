package com.nikiprojecttestroom.testroom;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nikiprojecttestroom.testroom.databinding.ActivityCreateUserBinding;

public class CreateUser extends AppCompatActivity {
    private ActivityCreateUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_user);
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .build();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Save in Database

                db.userDao().insertAll(new User(binding.txtFirstName.getText().toString()
                        ,binding.txtLastName.getText().toString()
                        ,binding.txtEmail.getText().toString()));

                startActivity(new Intent(CreateUser.this, MainActivity.class));


            }
        });
    }
}
