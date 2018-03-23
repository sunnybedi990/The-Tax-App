package com.dalbeer.sunnybedi.taxes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class tds extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    HashMap<List<String>, List<String>> listChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tds);
        setTitle("TDS");

        // get the listview


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, listChild);

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


    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();

        listDataChild = new HashMap<String, List<String>>();

        // Adding child data

        listDataHeader.add("Section 192");
        listDataHeader.add("Section 193");
        listDataHeader.add("Section 194");
        listDataHeader.add("Section 194A");
        listDataHeader.add("Section 194B");
        listDataHeader.add("Section 194BB");
        listDataHeader.add("Section 194C");
        listDataHeader.add("Section 194D");
        listDataHeader.add("Section 194DA");
        listDataHeader.add("Section 194EE");
        listDataHeader.add("Section 194F");
        listDataHeader.add("Section 194G");
        listDataHeader.add("Section 194H");
        listDataHeader.add("Section 194I");
        listDataHeader.add("Section 194IA");
        listDataHeader.add("Section 194IB");
        listDataHeader.add("Section 194J");
        listDataHeader.add("Section 194LA");
        listDataHeader.add("Section 194LBA");



        // Adding child data


        List<String> Section192 = new ArrayList<String>();Section192.add("Section192: Payment of salary ");Section192.add(" RATE =Slab Rate");
        List<String> Section193 = new ArrayList<String>();Section193.add("Section193: Interest on securities. a) any debentures or securities for money issued by or on behalf of any local authority or a corporation established by a Central, State or Provincial Act; b) any debentures issued by a company where such debentures are listed on a recognized stock exchange in accordance with the Securities Contracts (Regulation) Act, 1956 (42 of 1956) and any rules made there under; c) any security of the Central or State Government; d) interest on any other security ");Section193.add(" RATE =10%");
        List<String> Section194 = new ArrayList<String>();Section194.add("Section194: Dividend other than the dividend as referred to in Section115-O ");Section194.add(" RATE =10%");
        List<String> Section194A = new ArrayList<String>();Section194A.add("Section194A: Income by way of interest other than “Interest on securities” ");Section194A.add(" RATE =10%");
        List<String> Section194B = new ArrayList<String>();Section194B.add("Section194B: Income by way of winnings from lotteries, crossword puzzles, card games and other games of any sort ");Section194B.add(" RATE =30%");
        List<String> Section194BB = new ArrayList<String>();Section194BB.add("Section194BB: Income by way of winnings from horse races ");Section194BB.add(" RATE =30%");
        List<String> Section194C = new ArrayList<String>();
        Section194C.add("Section194C: Payment to contractor/sub-contractors. ");
        Section194C.add("RATE FOR Individual 1%");
        Section194C.add("RATE FOR HUF 2%");
        List<String> Section194D = new ArrayList<String>();Section194D.add("Section194D: Insurance commission ");Section194D.add(" RATE =5%");
        List<String> Section194DA = new ArrayList<String>();Section194DA.add("Section194DA: Payment in respect of life insurance policy ");Section194DA.add(" RATE =1%");
        List<String> Section194EE = new ArrayList<String>();Section194EE.add("Section194EE: Payment in respect of deposit under National Savings scheme ");Section194EE.add(" RATE =10%");
        List<String> Section194F = new ArrayList<String>();Section194F.add("Section194F: Payment on account of repurchase of unit by Mutual Fund or Unit Trust of India ");Section194F.add(" RATE =20%");
        List<String> Section194G = new ArrayList<String>();Section194G.add("Section194G: Commission, etc., on sale of lottery tickets ");Section194G.add(" RATE =5%");
        List<String> Section194H = new ArrayList<String>();Section194H.add("Section194H: Commission or brokerage ");Section194H.add(" RATE =5%");
        List<String> Section194I = new ArrayList<String>();
        Section194I.add("a) Rent on Plant & Machinery - Rate = 2%");
        Section194I.add("b) Land or building or furniture or fitting - Rate = 10%");
        List<String> Section194IA = new ArrayList<String>();Section194IA.add("Section194-IA: Payment on transfer of certain immovable property other than agricultural land ");Section194IA.add(" RATE =1%");
        List<String> Section194IB = new ArrayList<String>();Section194IB.add("Section194 -IB   :  Rent payable by an individual or HUF not covered u/s. 194I (w.e.f from 01.06.2017) ");Section194IB.add(" RATE =5%");
        List<String> Section194J = new ArrayList<String>();Section194J.add("Section194J: Any sum paid by way of:a) Fee for professional services b) Fee for technical services c) Royalty d) Remuneration/fee/commission to a director ore) For not carrying out any activity in relation to any businessf) For not sharing any know-how, patent, copyright etc. ");Section194J.add(" RATE =10%");
        List<String> Section194LA = new ArrayList<String>();Section194LA.add("Section194LA: Payment of compensation on acquisition of certain immovable property ");Section194LA.add(" RATE =10%");
        List<String> Section194LBA = new ArrayList<String>();Section194LBA.add("Section194LBA: Certain income distributed by a business trust to its unit holder ");Section194LBA.add(" RATE =10%");
        // Header, Child data
        listDataChild.put(listDataHeader.get(0),Section192 );
        listDataChild.put(listDataHeader.get(1),Section193 );
        listDataChild.put(listDataHeader.get(2),Section194 );
        listDataChild.put(listDataHeader.get(3),Section194A );
        listDataChild.put(listDataHeader.get(4),Section194B );
        listDataChild.put(listDataHeader.get(5),Section194BB );
        listDataChild.put(listDataHeader.get(6),Section194C );
        listDataChild.put(listDataHeader.get(7),Section194D );
        listDataChild.put(listDataHeader.get(8),Section194DA );
        listDataChild.put(listDataHeader.get(9),Section194EE );
        listDataChild.put(listDataHeader.get(10),Section194F );
        listDataChild.put(listDataHeader.get(11),Section194G );
        listDataChild.put(listDataHeader.get(12),Section194H );
        listDataChild.put(listDataHeader.get(13),Section194I );
        listDataChild.put(listDataHeader.get(14),Section194IA );
        listDataChild.put(listDataHeader.get(15),Section194IB );
        listDataChild.put(listDataHeader.get(16),Section194J );
        listDataChild.put(listDataHeader.get(17),Section194LA );
        listDataChild.put(listDataHeader.get(18),Section194LBA );
    }
}
