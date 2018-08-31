package com.chamika.fidenz.facilityconsole.Activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chamika.fidenz.facilityconsole.Adapter.DataAdapter;
import com.chamika.fidenz.facilityconsole.Helpers.Conts;
import com.chamika.fidenz.facilityconsole.Models.Booking;
import com.chamika.fidenz.facilityconsole.R;
import com.chamika.fidenz.facilityconsole.Services.API.Sync.GetBookingSync;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements GetBookingSync.GetBookingCallback, DataAdapter.Getpostion {


    private RecyclerView recyclerView;
    private DataAdapter adapter;
    public GetBookingSync getBookingSync;
    TextView tv, tv_date, textlong, tv_monthhandyear, tvtime, tvyear, mettingTitle, FromtoTo;
    ImageView RimageView;
    private LinearLayout linmain1, linmain2;
    private RelativeLayout relmain;
    public String steDate, month, year;
    private ProgressDialog progressDialog;
    CountDownTimer newtimer;

    View view;

    private String SystemTime;


    //public ArrayList<Booking.BookingsBean> bookingsBeans;
    public ArrayList mbookinglist = new ArrayList<Booking.BookingsBean>();

    long milliseconds;

    Handler handler;
    Activity context = this;
    //int delay = 20000;

    String Label;
    String Duration;
    String MeetingName, Imageurl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        loadJSON();

        tv = (TextView) findViewById(R.id.TextView03);
        textlong = (TextView) findViewById(R.id.TextView03);
        tv.setSelected(true);  // Set focus to the textview

        tv_date = (TextView) findViewById(R.id.tvdate);
        tv_monthhandyear = (TextView) findViewById(R.id.tvmnth);
        tvtime = (TextView) findViewById(R.id.tvtime);
        tvyear = (TextView) findViewById(R.id.tvyear);
        RimageView = (ImageView) findViewById(R.id.profile_image);
        linmain1 = (LinearLayout) findViewById(R.id.lin1);
        linmain2 = (LinearLayout) findViewById(R.id.lin2);
        relmain = (RelativeLayout) findViewById(R.id.maincel);

        mettingTitle = findViewById(R.id.tvMeeting);
        FromtoTo = findViewById(R.id.tvFromTO);
        timeSet();

        handler = new Handler();


        this.handler.postDelayed(m_Runnable, 20000);


    }

    private void timeSet() {


        final Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd ");
        SimpleDateFormat mdformat2 = new SimpleDateFormat("MMMM");
        SimpleDateFormat mdformate3 = new SimpleDateFormat("yyyy");
        final SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm");
        steDate = mdformat.format(calendar.getTime());
        month = mdformat2.format(calendar.getTime());
        year = mdformate3.format(calendar.getTime());

        newtimer = new CountDownTimer(1000000000, 1000) {

            public void onTick(long millisUntilFinished) {
                Calendar c = Calendar.getInstance();

                SystemTime = simpleDateFormat1.format(c.getTime());
                tvtime.setText(SystemTime);
            }

            public void onFinish() {

            }
        };
        newtimer.start();

        tv_date.setText(steDate);
        tv_monthhandyear.setText(month);
        tvyear.setText(year);
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    }

    public void loadJSON() {

        //showProgressDialog();
        getBookingSync = new GetBookingSync(this, this);
        getBookingSync.getMeetingsretrofit();

    }

    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
        }
        progressDialog.setMessage("Loading.....");
        progressDialog.show();
    }

    @Override
    public void onBookingFound(boolean status, ArrayList<Booking.BookingsBean> response) {

        if (status && response != null && !response.isEmpty() && response.size() !=0) {

            progressDialog.dismiss();
            adapter = new DataAdapter(response, context, this);
            recyclerView.setAdapter(adapter);

            Label = response.get(0).getLabel();
            Duration = response.get(0).getDuration();
            MeetingName = response.get(0).getTitle();
            Imageurl = response.get(0).getHostImagePath();


            Toast.makeText(context, Label + " " + Duration, Toast.LENGTH_LONG).show();

            dataloading();

        } else {
            Toast.makeText(getApplicationContext(), "Error loading data", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void ontickersFound(boolean status, Booking.NewsTickerBean news) {

        if (status && news != null) {

            progressDialog.dismiss();
            String newslong = news.getText();
            textlong.setText(newslong);

        } else {
            Toast.makeText(getApplicationContext(), "Error loading data", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDataget(boolean status, ArrayList<Booking.BookingsBean> response) {

        for (Booking.BookingsBean a : response) {
            // TODO: 2/20/18  
        }
    }

    @Override
    public void onBackPressed() {

        newtimer.cancel();

        super.onBackPressed();
    }

    private final Runnable m_Runnable = new Runnable() {
        public void run()

        {
            // Toast.makeText(MainActivity.this, "in runnable", Toast.LENGTH_SHORT).show();
            loadJSON();

            MainActivity.this.handler.postDelayed(m_Runnable, 20000);
        }

    };

    @Override
    public void getpostion(int position) {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")
    public void dataloading() {

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date starttime = null;
        try {
            starttime = df.parse(Label);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(starttime);
        cal.add(Calendar.MINUTE, Integer.parseInt(Duration));//60
        final Date newTime = (cal.getTime());
        String endtime = df.format(newTime);


        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");


        Date CurrentTime = null;
        try {
            CurrentTime = dateFormat.parse(dateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (CurrentTime.after(starttime) && CurrentTime.before(newTime)) {
            Toast.makeText(context, "Meeting time", Toast.LENGTH_LONG).show();

            mettingTitle.setText(MeetingName);
            FromtoTo.setText("From" + " " + Label + " " + "to" + " " + endtime);
            linmain1.setBackgroundColor(Color.RED);
            linmain2.setBackgroundColor(R.color.lightRed);
            view = this.getWindow().getDecorView();
            view.setBackgroundResource(R.color.lightRed);

            Window window = getWindow();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.setStatusBarColor(getColor(R.color.DarkRed));
            }
        } else {
            Toast.makeText(context, "No meetings", Toast.LENGTH_LONG).show();

            mettingTitle.setText("NextMeeting: " + " " + MeetingName);
            FromtoTo.setText("At" + " " + "From" + " " + Label + " " + "to" + " " + endtime);

            Picasso.with(context).load(Conts.BASE_URL + Imageurl).into(RimageView);
            view = this.getWindow().getDecorView();
            view.setBackgroundResource(R.color.colorPrimary);


        }

    }


}
