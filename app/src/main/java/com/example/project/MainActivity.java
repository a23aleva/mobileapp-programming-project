package com.example.project;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.networking.JsonTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        JsonTask task = new JsonTask(new JsonTask.JsonTaskListener() {
            @Override
            public void onPostExecute(String json) {
                Log.d("json data", json);
            }
        });

        task.execute("https://mobprog.webug.se/json-api?login=a23aleva");
    }

}
