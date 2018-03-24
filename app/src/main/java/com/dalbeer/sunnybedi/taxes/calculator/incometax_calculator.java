package com.dalbeer.sunnybedi.taxes.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.MenuPopupWindow;
import android.widget.Button;
import android.widget.EditText;

import com.dalbeer.sunnybedi.taxes.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static android.provider.Settings.System.DATE_FORMAT;

public class incometax_calculator extends AppCompatActivity {
    EditText due_date, actual_date;
    String category, resident_status, gender;
    int incomefromsalaary, incomefromhp, incomefromcapitalgain,
            incomefrompgbp, agriculturalincome,deduction, tds, advancetax1,advancetax2,advancetax3,advancetax4;
    double nettaxableincome,grosstaxableincome,taxatnormalrate,stcpat111a,ltcgat20,ltcgat10,winingsat30
            ,releifus87a,surcharge,educationcess, seceducess,totaltaxliability,reliefotherthan87a,
            selfasstax, interestus234a, interestus234b, interestus234c;
    Button calculate,reset;
    MenuPopupWindow.MenuDropDownListView assement_year, duedate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incometax_calculator);


        long month243a = getDaysBetweenDates(due_date.getText().toString(),actual_date.getText().toString());


        interestus234a = totaltaxliability * .01 * ((month243a / 31) +1 );

// We have to use Master Data Flow for this income tax calculator

    }
    public static long getDaysBetweenDates(String start, String end) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
        Date startDate, endDate;
        long numberOfDays = 0;
        try {
            startDate = dateFormat.parse(start);
            endDate = dateFormat.parse(end);
            numberOfDays = getUnitBetweenDates(startDate, endDate, TimeUnit.DAYS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return numberOfDays;
    }

    private static long getUnitBetweenDates(Date startDate, Date endDate, TimeUnit unit) {
        long timeDiff = endDate.getTime() - startDate.getTime();
        return unit.convert(timeDiff, TimeUnit.MILLISECONDS);
    }

    private void data(){
        int days = 28;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = due_date.getText().toString();
        Calendar calendar1 = Calendar.getInstance();
        try {
            calendar1.setTime(sdf.parse(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar1.add(Calendar.MONTH, 1);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        calendar1.add(Calendar.DATE, -1);
        SimpleDateFormat format1 = new SimpleDateFormat("MM");
        Date ll = calendar1.getTime();
        int monthNumber = Integer.parseInt(format1.format(ll));
        String  tromorrow = actual_date.getText().toString();
        Calendar calendar2 = Calendar.getInstance();
        try {
            calendar2.setTime(sdf.parse(tromorrow));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar2.add(Calendar.MONTH, 1);
        calendar2.set(Calendar.DAY_OF_MONTH, 1);
        calendar2.add(Calendar.DATE, -1);
        SimpleDateFormat format2 = new SimpleDateFormat("MM");
        Date check = calendar2.getTime();
        int checkmonth = Integer.parseInt(format1.format(check));



        List<Integer> oddmonths = new ArrayList<>();

// How you add your data in string list
        oddmonths.add(1);
        oddmonths.add(3);
        oddmonths.add(5);
        oddmonths.add(7);
        oddmonths.add(8);
        oddmonths.add(10);
        oddmonths.add(12);
        for (int i = 0; i < oddmonths.size(); i++) {
            //    Log.i("Value of element "+i,oddmonths.get(i));
            if (oddmonths.contains(monthNumber)) {
                days = 31;
            }
        }
        List<Integer> evenmonths = new ArrayList<>();

// How you add your data in string list
        evenmonths.add(4);
        evenmonths.add(6);
        evenmonths.add(9);
        evenmonths.add(11);


// retrieving data from string list array in for loop
        for (int i = 0; i < evenmonths.size(); i++) {
            if (evenmonths.contains(monthNumber)) {
                days = 30;
            }
            // Log.i("Value of element "+i,evenmonths.get(i));
        }


    }
}
