package com.dalbeer.sunnybedi.taxes.rates;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dalbeer.sunnybedi.taxes.R;
import com.dalbeer.sunnybedi.taxes.listviews.CustomList;

public class tds_category extends AppCompatActivity {

    ListView list;
    String[] web = {
            "Individuals",
            "Company",
            "Non Resident",

    } ;
    Integer[] imageId = {
            R.drawable.individual,
            R.drawable.company,
            R.drawable.nonresident,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tds_category);

        CustomList adapter = new
                CustomList(tds_category.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(position == 0){
                Intent a = new Intent(tds_category.this, tds.class);
                startActivity(a);}
                Toast.makeText(tds_category.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

    }

}
