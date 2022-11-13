package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button btn1;
    String strfortv = "";

    List<Track> tracks = new ArrayList<>();
    List<String> students = Arrays.asList("Harry", "Ron", "Harmione");

    Map<String, Track> assignments  = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tracks.add(new Track("Mobile", "Tommy"));
        tracks.add(new Track("Web", "Brian"));
        tracks.add(new Track("Games", "Colton"));

        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });


    }
    void change() {
        Random random = new Random();
        for (String student : students) {
            int index = random.nextInt(tracks.size());
            assignments.put(student, tracks.get(index));
        }

        for (Map.Entry<String, Track> entry : assignments.entrySet()) {
            Track track = entry.getValue();
            String debugMsg = entry.getKey() + " got " + track.getName() + " with " +
                    track.getInstructor();
            Log.d("cs50", debugMsg );
            strfortv += debugMsg + "\n";

        }
        tv1.setText(strfortv);
        strfortv = "";
    }
}