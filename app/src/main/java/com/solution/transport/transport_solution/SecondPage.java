package com.solution.transport.transport_solution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondPage extends AppCompatActivity {

    String[] cycle_type = {"Sporty", "Step-Through"};
    String[] user_type = {"All","Guest", "Volunteer", "Aurovillian"};
    CustomArrayAdapter customArrayAdapter;
    ListView listView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
//        initializing main method.......
        initializing();


    }

   //main method.................
    public void initializing(){
        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.tooBarText);

        //Spinner codes..............
        Spinner spinner = findViewById(R.id.Guest);
        Spinner spinner2 = findViewById(R.id.Volunteer);

        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cycle_type));
        spinner2.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, user_type));
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    getposition(position);
                    Log.d("Seleted Item", "Id: " + Integer.toString(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondPage.this,MainActivity.class));
                finish();
            }
        });
    }
//...........................................

//Filter portion code.............

    private void getposition(int i){
        ArrayList<CustomAdapter> filteredData= new ArrayList<>();
        if (i == 0){
            customArrayAdapter = new CustomArrayAdapter(this,R.layout.card_view,allData());
        }else{
            for (CustomAdapter cosmicBody : allData()){
                if (cosmicBody.getId() == i){
                    filteredData.add(cosmicBody);
                }
            }
            customArrayAdapter = new CustomArrayAdapter(this,R.layout.card_view,filteredData);
        }
        listView.setAdapter(customArrayAdapter);
    }


    //All Data..............

    private ArrayList<CustomAdapter> allData(){
        ArrayList<CustomAdapter> data= new ArrayList<>();
        data.clear();
        data.add(new CustomAdapter("1-15" , "200" , 1));
        data.add(new CustomAdapter("16-30","170",1));
        data.add(new CustomAdapter("31-90","145",1));
        data.add(new CustomAdapter("91-180","125",1));
        data.add(new CustomAdapter("1-15","225",1));
        data.add(new CustomAdapter("16-30","195",1));
        data.add(new CustomAdapter("31-90","170",1));
        data.add(new CustomAdapter("91-180","150",1));
        data.add(new CustomAdapter("1-15","135",2));
        data.add(new CustomAdapter("16-30","125",2));
        data.add(new CustomAdapter("31-90","110",2));
        data.add(new CustomAdapter("91-180","90",2));
        data.add(new CustomAdapter("1-15","140",2));
        data.add(new CustomAdapter("16-30","140",2));
        data.add(new CustomAdapter("31-90","125",2));
        data.add(new CustomAdapter("91-180","105",2));
        data.add(new CustomAdapter("16-30","100",3));
        data.add(new CustomAdapter("31-90","100",3));
        data.add(new CustomAdapter("91-180","100",3));
        data.add(new CustomAdapter("1-15","100",3));
        data.add(new CustomAdapter("16-30","100",3));
        data.add(new CustomAdapter("31-90","100",3));
        data.add(new CustomAdapter("91-180","100",3));

        return data;
    }
}


