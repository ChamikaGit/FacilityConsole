package com.chamika.fidenz.facilityconsole.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chamika.fidenz.facilityconsole.Models.Booking;
import com.chamika.fidenz.facilityconsole.R;

import java.util.ArrayList;

/**
 * Created by fidenz on 2/20/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Booking.BookingsBean> Bookinglist;
    private Context context;
    private Getpostion mgetpostion;

    public DataAdapter(ArrayList<Booking.BookingsBean> bookinglist, Context context, Getpostion getpostion) {
        Bookinglist = bookinglist;
        this.context = context;
        this.mgetpostion = getpostion;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_booking, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_meetingperpose.setText(Bookinglist.get(position).getTitle());
        holder.tv_HostName.setText(Bookinglist.get(position).getHostName());
        holder.tv_startTime.setText("Start at " + Bookinglist.get(position).getLabel());

        mgetpostion.getpostion(position);


    }

    @Override
    public int getItemCount() {
        return Bookinglist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_meetingperpose, tv_HostName, tv_startTime;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_meetingperpose = itemView.findViewById(R.id.tvmeetingperpose);
            tv_HostName = itemView.findViewById(R.id.tvHostname);
            tv_startTime = itemView.findViewById(R.id.tvStarttime);
        }
    }

    public interface Getpostion {

        void getpostion(int position);


    }


}
