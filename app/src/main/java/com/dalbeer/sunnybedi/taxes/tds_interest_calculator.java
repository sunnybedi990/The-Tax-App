package com.dalbeer.sunnybedi.taxes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class tds_interest_calculator extends AppCompatActivity {
    public static final String DATE_FORMAT = "d/M/yyyy";
    EditText date_of_deduction;
    EditText date_of_deduction_required;
    EditText actualdedcution;
    Boolean immovbleproperty;
    RadioButton yes, no;
    TextView interestamount, totalamount, duedate;
    long notdeducted;
    long notpaid;
            String lastdate,date_of_deduction1, date_of_deduction_required1,actualdedcution1;
    int actualamount1;
    double interestamount1;
    double totalamount1;
    private Button submit;
    private EditText actualamount;
    private Period period;
    private long noofmonths = 1;
    private int normaldays;
    private int days;
    private SimpleDateFormat sdf;
    private String today;
    private long lastdatecheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tds_interest_calculator);
        setTitle("Interest Calculator");
        date_of_deduction = (EditText)findViewById(R.id.editText_deductiondate);
        date_of_deduction_required = (EditText) findViewById(R.id.editText_reqdeductiondate);
        actualdedcution = (EditText) findViewById(R.id.editText_actualdate);
        actualamount = (EditText) findViewById(R.id.editText_amounttds);
        yes = (RadioButton)findViewById(R.id.radioButton_yes_immo);
        no = (RadioButton)findViewById(R.id.radioButton_no_immo);
        interestamount = (TextView)findViewById(R.id.textView_interesrttds);
        totalamount = (TextView)findViewById(R.id.textView_tdstotalamountpayable);
        duedate = (TextView)findViewById(R.id.textview_tdsduedate);
        submit = (Button)findViewById(R.id.button_submit_tdsinterest);
        no.setChecked(true);
        immovbleproperty = false;

        yes.setOnClickListener(new RadioButton.OnClickListener() {
            @Override
            public void onClick(View v) {

                yes.setChecked(true);
                no.setChecked(false);
                immovbleproperty = true;
            }
        });
        no.setOnClickListener(new RadioButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                no.setChecked(true);
                yes.setChecked(false);
                immovbleproperty = false;
            }
        });
                submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_of_deduction1 = date_of_deduction.getText().toString();
                date_of_deduction_required1 = date_of_deduction_required.getText().toString();
                actualdedcution1 = actualdedcution.getText().toString();
                actualamount1 = Integer.parseInt(actualamount.getText().toString());

                sdf = new SimpleDateFormat("dd/MM/yyyy");
                today = date_of_deduction_required.getText().toString();
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
              String  tromorrow = actualdedcution.getText().toString();
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


                if (immovbleproperty) {
                    normaldays = 29;
                } else {
                    if (monthNumber == 3) {
                        normaldays = 29;
                    } else {
                        normaldays = 6;
                    }
                }
                days = 28;
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


                Calendar calendar = Calendar.getInstance();
                try {
                    calendar.setTime(sdf.parse(today));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                calendar.add(Calendar.MONTH, 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.add(Calendar.DATE, normaldays);

                Date lastDayOfMonth = calendar.getTime();
                lastdate = sdf.format(lastDayOfMonth);

                // motnth

                Log.e("hua", actualdedcution.getText().toString());
                Log.e("hua", date_of_deduction.getText().toString());
                Log.e("hua", date_of_deduction_required.getText().toString());
                Log.e("huakya", lastdate);
                Log.e("huakyaye", String.valueOf(monthNumber));
                Log.e("dyas", String.valueOf(days));

                // calculate months

                lastdatecheck = getDaysBetweenDates(lastdate, actualdedcution1);
                notdeducted = getDaysBetweenDates(date_of_deduction_required1, actualdedcution1);
                Log.e("hua", String.valueOf(notdeducted));
                notpaid = getDaysBetweenDates(date_of_deduction_required1, date_of_deduction1);
                Log.e("hua", String.valueOf(notpaid));
                duedate.setText(lastdate);
                if (notdeducted > 31) {
                    long s = (notdeducted / 31) + 1;
                    noofmonths = s;
                    Log.e("months", String.valueOf(noofmonths));
                } else {
                    noofmonths = 1;
                }
                if (notdeducted > 0) {
                    if (checkmonth == monthNumber) {
                        Log.e("months", String.valueOf(checkmonth));
                        Log.e("months", String.valueOf(monthNumber));
                        interestamount.setText("No Interest");
                        totalamount.setText(String.valueOf(actualamount1));
                    } else {
                        if (lastdatecheck > 0) {
                            Log.e("months1", String.valueOf(notdeducted));
                            interestamount1 = actualamount1 * 0.015 * noofmonths;
                            interestamount.setText(String.valueOf(interestamount1));
                            totalamount1 = actualamount1 + interestamount1;
                            totalamount.setText(String.valueOf(totalamount1));
                        } else {
                            interestamount.setText("No Interest");
                            totalamount.setText(String.valueOf(actualamount1));


                        }

                    }
                } else {
                    interestamount.setText("No Interest");
                    totalamount.setText(String.valueOf(actualamount1));


                }
            }
        });


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

}
