package com.example.project;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.danieloskarsson.recyclerviewapp.RecyclerViewAdapter;
import com.example.networking.Berry;
import com.example.networking.JsonTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Gson gson;

    private RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gson = new Gson();
        Button button = findViewById(R.id.nextViewButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        adapter = new RecyclerViewAdapter(this, new ArrayList<Berry>(), new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Berry berry) {
                //Toast.makeText(MainActivity.this, berry.info(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

        JsonTask task = new JsonTask(new JsonTask.JsonTaskListener() {
            @Override
            public void onPostExecute(String json) {
                Type type = new TypeToken<List<Berry>>() {}.getType();
                ArrayList<Berry> listOfBerries = gson.fromJson(json, type);
                adapter.updateData(listOfBerries);
            }
        });

        task.execute("https://mobprog.webug.se/json-api?login=a23aleva");
    }
}
