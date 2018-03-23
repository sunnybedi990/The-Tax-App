package com.dalbeer.sunnybedi.taxes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class tds_category extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tds_category);
        setTitle("Category");
        TextView individuals = (TextView)findViewById(R.id.individuals_textview);
        TextView company = (TextView)findViewById(R.id.company_textview);
        TextView nonresident = (TextView)findViewById(R.id.nonresident_textview);
        individuals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(tds_category.this, tds.class);
                startActivity(a);
            }
        });
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(tds_category.this, tds.class);
                startActivity(a);
            }
        });
        nonresident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(tds_category.this, tds.class);
                startActivity(a);
            }
        });

    }



}
