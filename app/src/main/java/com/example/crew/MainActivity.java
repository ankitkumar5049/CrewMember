package com.example.crew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.crew.database.CrewEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Crew> crewInfoList = new ArrayList<>();
    RecyclerAdapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    RelativeLayout progressLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        progressBar = findViewById(R.id.progressBar);
        progressLayout = findViewById(R.id.progressLayout);
        layoutManager = new LinearLayoutManager(this);

        progressLayout.setVisibility(View.VISIBLE);

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.spacexdata.com/v4/crew";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressLayout.setVisibility(View.GONE);
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jo = jsonArray.getJSONObject(i);

                                Crew crew = new Crew();
                                crew.CrewName = jo.getString("name");
                                crew.CrewAgency = jo.getString("agency");
                                crew.CrewImage = jo.getString("image");
                                crew.CrewWiki = jo.getString("wikipedia");
                                crew.CrewActive = jo.getString("status");

                                crewInfoList.add(crew);

                                recyclerAdapter = new RecyclerAdapter(crewInfoList);
                                recyclerView.setAdapter(recyclerAdapter);
                                recyclerView.setLayoutManager(layoutManager);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Volley Error",Toast.LENGTH_SHORT).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    class Database extends AsyncTask<Void,Void, List<CrewEntity>>{

        @Override
        protected List<CrewEntity> doInBackground(Void... voids) {
            RoomDatabase db = Room.databaseBuilder(getApplicationContext(),
                    RoomDatabase.class, "Database").build();
            return null;
        }
    }
}