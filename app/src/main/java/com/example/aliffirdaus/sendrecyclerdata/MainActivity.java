package com.example.aliffirdaus.sendrecyclerdata;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aliffirdaus.sendrecyclerdata.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<User> ninjas;
    RecyclerView recyclerView;
    UserAdapter adapter;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Bind view
        ActivityMainBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Populate recycler data at first time
        ninjas = populateList();

        //Set user adapter
        adapter = new UserAdapter(this, ninjas);

        //set recyclerview adapter
        bind.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bind.recyclerView.setAdapter(adapter);

        //on submit button click
        bind.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (User ninja : ninjas){
                    //Send user
                    Toast.makeText(MainActivity.this, "Send " + ninja.getName() + " to a mission", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private List<User> populateList() {
        List<User> list = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            User user = new User();
            user.setName(String.valueOf(i));
            list.add(user);
        }
        return list;
    }
}
