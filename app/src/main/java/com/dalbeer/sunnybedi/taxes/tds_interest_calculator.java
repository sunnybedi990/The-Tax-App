package com.dalbeer.sunnybedi.taxes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class tds_interest_calculator extends AppCompatActivity {
    public static final String DATE_FORMAT = "d/M/yyyy";
    EditText date_of_deduction;
    EditText date_of_deduction_required;
    EditText month_of_deduction;
    Boolean immovbleproperty;
    RadioButton yes, no;
    TextView interestamount, totalamount, duedate;
    String notdeducted;
    String notpaid, lastdate;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tds_interest_calculator);
        setTitle("Interest Calculator");
        date_of_deduction = (EditText)findViewById(R.id.editText_deductiondate);
        date_of_deduction_required = (EditText) findViewById(R.id.editText_reqdeductiondate);
        month_of_deduction = (EditText) findViewById(R.id.editText_actualdate);
        yes = (RadioButton)findViewById(R.id.radioButton_yes_immo);
        no = (RadioButton)findViewById(R.id.radioButton_no_immo);
        interestamount = (TextView)findViewById(R.id.textView_interesrttds);
        totalamount = (TextView)findViewById(R.id.textView_tdstotalamountpayable);
        duedate = (TextView)findViewById(R.id.textview_tdsduedate);
        submit = (Button)findViewById(R.id.button_submit_tdsinterest);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String today = date_of_deduction.getText().toString();
                Calendar calendar = Calendar.getInstance();
                try {
                    calendar.setTime(sdf.parse(today));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                calendar.add(Calendar.MONTH, 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.add(Calendar.DATE, -1);

                Date lastDayOfMonth = calendar.getTime();


                lastdate = sdf.format(lastDayOfMonth);

                Log.e("hua", "onClick: " );
                Log.e("hua", duedate.toString() );
                Log.e("hua", month_of_deduction.getText().toString() );
                Log.e("hua", date_of_deduction.getText().toString() );
                Log.e("hua", date_of_deduction_required.getText().toString() );
                Log.e("huakya", lastdate );
                notdeducted = String.valueOf(getDaysBetweenDates(duedate.getText().toString(),lastdate));
                Log.e("hua", notdeducted );
                notpaid = String.valueOf(getDaysBetweenDates(date_of_deduction_required.getText().toString(),date_of_deduction.getText().toString()));
                Log.e("hua", notpaid);
                interestamount.setText(notdeducted);
                totalamount.setText(notpaid);
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
