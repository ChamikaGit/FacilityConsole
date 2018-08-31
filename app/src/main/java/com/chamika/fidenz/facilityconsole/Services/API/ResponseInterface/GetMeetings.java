package com.chamika.fidenz.facilityconsole.Services.API.ResponseInterface;

import com.chamika.fidenz.facilityconsole.Models.Booking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by fidenz on 2/20/18.
 */

public interface GetMeetings {


    @GET("OI/FacilityAPI-2/{category}")
    Call<Booking> getBookings(

            @Path("category") String category,
            @Query("FacilityID") String FacilityID,
            @Query("apikey") String apikey
    );
}
