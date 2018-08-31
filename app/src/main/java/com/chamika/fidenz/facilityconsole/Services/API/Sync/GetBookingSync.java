package com.chamika.fidenz.facilityconsole.Services.API.Sync;

import android.content.Context;
import android.widget.Toast;

import com.chamika.fidenz.facilityconsole.Helpers.Conts;
import com.chamika.fidenz.facilityconsole.Models.Booking;
import com.chamika.fidenz.facilityconsole.Services.API.ResponseInterface.GetMeetings;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fidenz on 2/20/18.
 */

public class GetBookingSync {

    public static String API_KEY = "SC:mobiletestbed:6d2cb442c55e2ebf";
    public static String FACILITYID = "S17";
    public static String CATEGORY = "GetTodayBookings";

    private Context context;
    private GetBookingCallback callback;
    private  ArrayList<Booking.BookingsBean> bookingsBeans=new ArrayList<Booking.BookingsBean>();



    public GetBookingSync(Context context, GetBookingCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void getMeetingsretrofit() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Conts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final GetMeetings meetingAPI = retrofit.create(GetMeetings.class);

        Call<Booking> call = meetingAPI.getBookings(CATEGORY, FACILITYID, API_KEY);

        call.enqueue(new Callback<Booking>() {
            @Override
            public void onResponse(Call<Booking> call, Response<Booking> response) {


                Booking booking = response.body();
                bookingsBeans = booking.getBookings();

                Booking.NewsTickerBean newsTickerBeans = booking.getNewsTicker();

                if (response == null && bookingsBeans.size()==0 && bookingsBeans.isEmpty() && bookingsBeans == null) {
                    callback.onBookingFound(false, null);
                }
                else if(response != null && response.isSuccessful()&& bookingsBeans.size() != 0){

                    callback.ontickersFound(true, newsTickerBeans);
                    callback.onBookingFound(true, bookingsBeans);
                    callback.onDataget(true, bookingsBeans);
                }
                else {
                    Toast.makeText(context,"Can't Connect to the API",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Booking> call,Throwable t){

                callback.onBookingFound(false, null);
                callback.onBookingFound(false, null);
            }
        });


    }

    public interface GetBookingCallback {

        void onBookingFound(boolean status, ArrayList<Booking.BookingsBean> response);

        void ontickersFound(boolean status, Booking.NewsTickerBean news);

        void onDataget(boolean status,ArrayList<Booking.BookingsBean> response);
    }


}
