package com.ramazangulsen.landmarkbook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.ramazangulsen.landmarkbook.databinding.ActivityDetailsBinding;
import com.ramazangulsen.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    ArrayList<Landmark> landmarkArrayList;

    private ActivityMainBinding binding;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        landmarkArrayList = new ArrayList<>();

        Landmark galata = new Landmark("galata kulesi","turkey",R.drawable.galata);
        Landmark kizkulesi = new Landmark("kız kulesi","turkey",R.drawable.kizkulesi);
        Landmark sarnic = new Landmark("yerebatan sarnici","turkey",R.drawable.sarnic);
        Landmark camlica = new Landmark("camlica parki","turkey",R.drawable.camlica);


        landmarkArrayList.add(galata);
        landmarkArrayList.add(kizkulesi);
        landmarkArrayList.add(sarnic);
        landmarkArrayList.add(camlica);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this)); // grid mi yoksa linear mi listeleyecek
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);




        /* // with listview. don't use it.  use recyclerview for performance.
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark", landmarkArrayList.get(position));
                startActivity(intent);

            }
        });


*/

    }
}