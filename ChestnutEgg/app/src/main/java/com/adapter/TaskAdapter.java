package com.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.dan.chestnutegg.FixPenActivity;
import com.example.dan.chestnutegg.PenActivity;
import com.example.dan.chestnutegg.R;
import com.example.dan.chestnutegg.TaskActivity;
import com.sql.modal.Task;
import org.litepal.crud.DataSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dan on 2018/4/19.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TasksViewHolder>{
    private List<Task> tasks;
    private Context context;

    public TaskAdapter(List<Task> tasks, Context context) {
        this.tasks = tasks;
        this.context=context;
    }


    //自定义ViewHolder类
    static class TasksViewHolder extends RecyclerView.ViewHolder{

        CardView card_task;

        TextView task_title;
        TextView task_later;
        TextView task_content;

        Button task_share;
        Button task_more;
        Button task_del;


        public TasksViewHolder(final View itemView) {
            super(itemView);
            card_task = (CardView) itemView.findViewById(R.id.card_task);

            task_title = (TextView) itemView.findViewById(R.id.task_title);
            task_later = (TextView) itemView.findViewById(R.id.task_later);
            task_content = (TextView) itemView.findViewById(R.id.task_content);


            task_share= (Button) itemView.findViewById(R.id.task_share);
            task_more= (Button) itemView.findViewById(R.id.task_more);
            task_del= (Button) itemView.findViewById(R.id.task_del);
            //设置TextView背景为半透明
            //news_title.setBackgroundColor(Color.argb(20, 0, 0, 0));

        }


    }
    @Override
    public TaskAdapter.TasksViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.card_task,viewGroup,false);
        TaskAdapter.TasksViewHolder nvh=new TaskAdapter.TasksViewHolder(v);
        return nvh;
    }

    @Override
    public void onBindViewHolder(TaskAdapter.TasksViewHolder personViewHolder, int i) {
        final int j=i;

        personViewHolder.task_title.setText(tasks.get(i).getTask_title());
        personViewHolder.task_content.setText(tasks.get(i).getTask_content());


        //计算时间
        Calendar calendar = Calendar.getInstance();
        int now_year = calendar.get(Calendar.YEAR);
        int now_month = calendar.get(Calendar.MONTH)+1;
        int now_day = calendar.get(Calendar.DAY_OF_MONTH);
        int now_hour = calendar.get(Calendar.HOUR_OF_DAY);
        int now_minute = calendar.get(Calendar.MINUTE);

        int year = 0;
        int month = 0;
        int day = 0;
        int hour = 0;
        int minute = 0;

        try{

            year = Integer.parseInt(tasks.get(i).getTask_year());
            month = Integer.parseInt(tasks.get(i).getTask_month());
            day = Integer.parseInt(tasks.get(i).getTask_day());
            hour = Integer.parseInt(tasks.get(i).getTask_hour());
            minute = Integer.parseInt(tasks.get(i).getTask_minute());

        }catch(Exception e){

        }



        personViewHolder.task_later.setText(different(year,month,day,hour,minute));


        //为btn_share btn_readMore cardView设置点击事件
//        personViewHolder.card_task.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                    Intent intent_TaskToPen = new Intent(context,PenActivity.class);
//                intent_TaskToPen.putExtra("task_title",tasks.get(j).getTask_title());
//                context.startActivity(intent_TaskToPen);
//            }
//        });

        personViewHolder.task_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, tasks.get(j).getTask_title()+"\n"+tasks.get(j).getTask_content());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Intent.createChooser(intent, tasks.get(j).getTask_title()+"\n"+tasks.get(j).getTask_content()));
            }
        });

        personViewHolder.task_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_TaskToFix = new Intent(context,FixPenActivity.class);

                intent_TaskToFix.putExtra("task_id",tasks.get(j).getId());
                intent_TaskToFix.putExtra("task_title",tasks.get(j).getTask_title());
                intent_TaskToFix.putExtra("task_content",tasks.get(j).getTask_content());
                intent_TaskToFix.putExtra("task_year",tasks.get(j).getTask_year());
                intent_TaskToFix.putExtra("task_month",tasks.get(j).getTask_month());
                intent_TaskToFix.putExtra("task_day",tasks.get(j).getTask_day());
                intent_TaskToFix.putExtra("task_hour",tasks.get(j).getTask_hour());
                intent_TaskToFix.putExtra("task_minute",tasks.get(j).getTask_minute());
                context.startActivity(intent_TaskToFix);
            }
        });

        personViewHolder.task_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(context)
                        .setTitle("删除")
                        .setMessage("你确定要删除此便签吗？")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.i("del", "del1 ");
                                //Task task = new Task(tasks.get(j).getTask_title(),tasks.get(j).getTask_content(),tasks.get(j).getTask_year(),tasks.get(j).getTask_month(),tasks.get(j).getTask_day(),tasks.get(j).getTask_hour(),tasks.get(j).getTask_minute(),0);
                                //String ss = ""+tasks.get(j).getId();
                                //task.updateAll("id = ?",ss);
                                //Log.i("del", "id:"+ss);

                                List<Task> task1 = DataSupport.where("id == ?",""+tasks.get(j).getId()).find(Task.class);
                                task1.get(0).setIsshow(0);
                                task1.get(0).save();

                                Intent intent = new Intent(context, TaskActivity.class);
                                context.startActivity(intent);

                            }
                        })
                        .setNegativeButton("否", null)
                        .show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }


    public static String different(int year,int month,int day,int hour,int minute){

        String date_str = ""+year+"-"+month+"-"+day+" "+hour+":"+minute+":00";

        String diff = "";

        Calendar calendar = Calendar.getInstance();
        int now_year = calendar.get(Calendar.YEAR);
        int now_month = calendar.get(Calendar.MONTH)+1;
        int now_day = calendar.get(Calendar.DAY_OF_MONTH);
        int now_hour = calendar.get(Calendar.HOUR_OF_DAY);
        int now_minute = calendar.get(Calendar.MINUTE);

        String date_now = ""+now_year+"-"+now_month+"-"+now_day+" "+now_hour+":"+now_minute+":00";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try
        {
            Date date2 = format.parse(date_str);
            Date date = format.parse(date_now);

            int diff_num = differentDays(date,date2);


            if(diff_num > 0)
                diff = differentDays(date,date2)+"天后";
            else if(diff_num < 0)
                diff = -differentDays(date,date2)+"天前";
            else{
                //相差不到一天
                int diffhour_num = differentHour(date,date2);
                if(diffhour_num > 0)
                    diff = differentHour(date,date2)+"小时后";
                else if(diffhour_num < 0)
                    diff = -differentHour(date,date2)+"小时前";
                else{
                    //相差不到一小时
                    int diffminute_num = differentMinute(date,date2);
                    if(diffminute_num > 0)
                        diff = differentMinute(date,date2)+"分钟后";
                    else if(diffminute_num < 0)
                        diff = -differentMinute(date,date2)+"分钟前";
                    else{
                        //到达时间
                        diff = "时间到";
                    }
                }
            }

            //未设置日期
            if(year == 0){
                diff = "";
            }

            //System.out.println("两个日期的差距：" + differentDays(date,date2));
            //Log.i("diff", diff);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return diff;
    }



    public static int differentDays(Date date1, Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

    public static int differentHour(Date date1, Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600));
        return days;
    }

    public static int differentMinute(Date date1, Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*60));
        return days;
    }

}