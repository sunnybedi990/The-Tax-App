package com.dalbeer.sunnybedi.taxes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.dalbeer.sunnybedi.taxes.calculator.tds_interest_calculator;
import com.dalbeer.sunnybedi.taxes.listviews.ExpandableListAdapter;
import com.dalbeer.sunnybedi.taxes.rates.tds_category;
import com.dalbeer.sunnybedi.taxes.userprofile.profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<List<String>, List<String>> listChild;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        expListView = (ExpandableListView) findViewById(R.id.maincomponents);

        // preparing list data
        prepareListData();
        Integer[] imageId = {
                R.drawable.taxrate,
                R.drawable.tax,
                R.drawable.calculator,
                R.drawable.important_date2,
                R.drawable.payments,


        };

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, listChild, imageId);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String clicked = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                if (clicked.equals("TDS ")) {
                    Intent a = new Intent(ScrollingActivity.this, tds_category.class);
                    startActivity(a);
                } else if (clicked.equals("TDS Calculator ")) {
                    Intent a = new Intent(ScrollingActivity.this, tds_interest_calculator.class);
                    startActivity(a);
                }
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

    }



    private void prepareListData() {
        listDataHeader = new ArrayList<String>();

        listDataChild = new HashMap<String, List<String>>();
        listChild = new HashMap<List<String>, List<String>>();

        // Adding child data

        listDataHeader.add("Rates");
        listDataHeader.add("Returns");
        listDataHeader.add("Calculator");
        listDataHeader.add("Important Dates");
        listDataHeader.add("Payments");


        // Adding child data


        List<String> rates = new ArrayList<String>();
        rates.add("TDS ");
        rates.add("GST ");
        rates.add("INCOME TAX SLAB RATE ");
        List<String> returns = new ArrayList<String>();
        returns.add("INCOME TAX RETURNS");
        returns.add("GST RETURNS");
        List<String> calculator = new ArrayList<String>();
        calculator.add("TDS Calculator ");
        calculator.add("GST Calculator ");
        calculator.add("INCOME TAX Calculator ");
        List<String> importantdates = new ArrayList<String>();
        importantdates.add("TDS");
        importantdates.add("GST");
        importantdates.add("ADVANCE TAX");
        List<String> payments = new ArrayList<String>();
        payments.add("Pay TDS");
        payments.add("Pay INCOME TAX");
        payments.add("Pay GST Challans");

        // Header, Child data
        listDataChild.put(listDataHeader.get(0), rates);
        listDataChild.put(listDataHeader.get(1), returns);
        listDataChild.put(listDataHeader.get(2), calculator);
        listDataChild.put(listDataHeader.get(3), importantdates);
        listDataChild.put(listDataHeader.get(4), payments);

        // third level
    /*    List<String> stringList = new ArrayList<String>();
        stringList.add("Individual");
        stringList.add("Company");
        stringList.add("Non - Resident");
        listChild.put(listDataChild.get(0), stringList);
*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, profile.class));
         //   LocationFound();
            return true;
        }
        if (id == R.id.action_user) {
            //   LocationFound();
            return true;
        }
        if (id == R.id.action_logout) {
          //  firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
         //   startActivity(new Intent(this, login.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


