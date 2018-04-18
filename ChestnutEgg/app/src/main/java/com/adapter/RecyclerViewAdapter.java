package com.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.dan.chestnutegg.R;
import com.example.dan.chestnutegg.TicketActivity;
import com.sql.modal.Ticket;

import java.util.Calendar;
import java.util.List;

/**
 * Created by dan on 2018/4/14.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NewsViewHolder>{

    private List<Ticket> tickets;
    private Context context;

    public RecyclerViewAdapter(List<Ticket> tickets,Context context) {
        this.tickets = tickets;
        this.context=context;
    }


    //自定义ViewHolder类
    static class NewsViewHolder extends RecyclerView.ViewHolder{

        CardView card_train;

        TextView train_number;
        TextView departure_date;
        TextView departure_time;
        TextView departure_place;
        TextView destination_place;
        TextView seat_number;

        TextView later_time;

        Button share;
        Button readMore;



        public NewsViewHolder(final View itemView) {
            super(itemView);
            card_train = (CardView) itemView.findViewById(R.id.card_train);

            train_number = (TextView) itemView.findViewById(R.id.train_number);
            departure_date = (TextView) itemView.findViewById(R.id.departure_date);
            departure_time = (TextView) itemView.findViewById(R.id.departure_time);
            departure_place = (TextView) itemView.findViewById(R.id.departure_place);
            destination_place = (TextView) itemView.findViewById(R.id.destination_place);
            seat_number = (TextView) itemView.findViewById(R.id.seat_number);

            later_time = (TextView) itemView.findViewById(R.id.later_time);

            share= (Button) itemView.findViewById(R.id.btn_share);
            readMore= (Button) itemView.findViewById(R.id.btn_more);
            //设置TextView背景为半透明
            //news_title.setBackgroundColor(Color.argb(20, 0, 0, 0));

        }


    }
    @Override
    public RecyclerViewAdapter.NewsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.card_train,viewGroup,false);
        NewsViewHolder nvh=new NewsViewHolder(v);
        return nvh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.NewsViewHolder personViewHolder, int i) {
        final int j=i;

        personViewHolder.train_number.setText(tickets.get(i).getTrain_number());
        personViewHolder.departure_date.setText(tickets.get(i).getDeparture_date());
        personViewHolder.departure_time.setText(tickets.get(i).getDeparture_time());
        personViewHolder.departure_place.setText(tickets.get(i).getDeparture_place());
        personViewHolder.destination_place.setText(tickets.get(i).getDestination_place());
        personViewHolder.seat_number.setText(tickets.get(i).getSeat_number());

        //计算时间
        Calendar calendar = Calendar.getInstance();
        int now_year = calendar.get(Calendar.YEAR);
        int now_month = calendar.get(Calendar.MONTH)+1;
        int now_day = calendar.get(Calendar.DAY_OF_MONTH);
        int now_hour = calendar.get(Calendar.HOUR_OF_DAY);
        int now_minute = calendar.get(Calendar.MINUTE);

        //计算日期
        String date = tickets.get(i).getDeparture_date();
        String month1;
        String day1;

        int m = date.indexOf('月');
        int n = date.indexOf('日');

        month1 = date.substring(0,m);
        day1 = date.substring(m+1,n);

        Log.i("all", date);
        Log.i("month", month1);
        Log.i("day", day1);

        int month = 0;
        int day = 0;

        try{

            month = Integer.parseInt(month1);
            day = Integer.parseInt(day1);

        }catch(Exception e){

        }


        //计算时间
        String time = tickets.get(i).getDeparture_time();
        String hour1;
        String minute1;

        int h = time.indexOf(':');

        hour1 = time.substring(0,h);
        minute1 = time.substring(h+1);

        Log.i("all", time);
        Log.i("hour", hour1);
        Log.i("minute", minute1);

        int hour = 0;
        int minute = 0;

        try{

            hour = Integer.parseInt(hour1);
            minute = Integer.parseInt(minute1);

        }catch(Exception e){

        }



        int a = month - now_month;
        if(a > 0){
            //几个月后
            personViewHolder.later_time.setText(a+"月后");
        }else if(a == 0){
            int b = day - now_day;
            if(b > 0){
                //几天后
                personViewHolder.later_time.setText(b+"天后");
            }else if(b == 0){
                int c = hour - now_hour;
                if(c > 0){
                    //几小时后
                    personViewHolder.later_time.setText(c+"小时后");
                }else if(c == 0){
                    int d = minute - now_minute;
                    if(d > 0){
                        //几分钟后
                        personViewHolder.later_time.setText(d+"分钟后");
                    }else if(d == 0){
                        personViewHolder.later_time.setText("即将完成");
                    }else{
                        personViewHolder.later_time.setText("已过期");
                    }
                }else{
                    personViewHolder.later_time.setText("已过期");
                }
            }else{
                personViewHolder.later_time.setText("已过期");
            }
        }else{
            personViewHolder.later_time.setText("已过期");
        }


        //为btn_share btn_readMore cardView设置点击事件
        personViewHolder.card_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,TicketActivity.class);
                intent.putExtra("order_number",tickets.get(j).getOrder_number());
                context.startActivity(intent);
            }
        });

        personViewHolder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, tickets.get(j).getSeat_number());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Intent.createChooser(intent, tickets.get(j).getTrain_number()));
            }
        });

        personViewHolder.readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,TicketActivity.class);
                intent.putExtra("order_number",tickets.get(j).getOrder_number());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }
}