package com.example.dan.chestnutegg;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.sql.modal.Task;

import java.util.Calendar;


public class FixPenActivity extends AppCompatActivity {

    private Button fix_time;
    private Button fix_sure;

    private TextView fix_title;
    private TextView fix_content;

    private String plan_title;
    private String plan_content;

    private String plan_year;
    private String plan_month;
    private String plan_day;
    private String plan_hour;
    private String plan_minute;

    private int plan_year_num;
    private int plan_month_num;
    private int plan_day_num;
    private int plan_hour_num;
    private int plan_minute_num;

    private String plan_title_new;
    private String plan_content_new;

    private String plan_year_new;
    private String plan_month_new;
    private String plan_day_new;
    private String plan_hour_new;
    private String plan_minute_new;

    int task_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_pen);

        task_id = getIntent().getIntExtra("task_id",0);

        fix_time = (Button) findViewById(R.id.fix_time);
        fix_sure = (Button) findViewById(R.id.fix_sure);

        fix_title = (TextView) findViewById(R.id.fix_title);
        fix_content = (TextView) findViewById(R.id.fix_content);
        plan_title = fix_title.getText().toString();
        plan_content = fix_content.getText().toString();

        plan_year = getIntent().getStringExtra("task_year");
        plan_month = getIntent().getStringExtra("task_month");
        plan_day = getIntent().getStringExtra("task_day");
        plan_hour = getIntent().getStringExtra("task_hour");
        plan_minute = getIntent().getStringExtra("task_minute");

        plan_year_new = plan_year;
        plan_month_new = plan_month;
        plan_day_new = plan_day;
        plan_hour_new = plan_hour;
        plan_minute_new = plan_minute;

        plan_year_num = 0;
        plan_month_num = 0;
        plan_day_num = 0;
        plan_hour_num = 0;
        plan_minute_num = 0;

        try{

            plan_year_num = Integer.parseInt(plan_year);
            plan_month_num = Integer.parseInt(plan_month);
            plan_day_num = Integer.parseInt(plan_day);
            plan_hour_num = Integer.parseInt(plan_hour);
            plan_minute_num = Integer.parseInt(plan_minute);

        }catch(Exception e){

        }

        fix_title.setText(getIntent().getStringExtra("task_title"));
        fix_content.setText(getIntent().getStringExtra("task_content"));

        String ls = "您选择了：" + plan_year + "年" + plan_month
                + "月" + plan_day + "日";

        if(0 <= plan_minute_num && plan_minute_num <= 9){
            fix_time.setText(ls + " "+plan_hour_num + ":0" + plan_minute_num);
        }
        if(0 <= plan_hour_num && plan_hour_num <= 9){
            fix_time.setText(ls + "0" + plan_hour_num + ":" + plan_minute_num);
        }
        if(0 <= plan_hour_num && plan_hour_num <= 9 && 0 <= plan_minute_num && plan_minute_num <= 9){
            fix_time.setText(ls + "0" + plan_hour_num + ":0" + plan_minute_num);
        }


        fix_time.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Calendar c = Calendar.getInstance();
                // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
                new DatePickerDialog(FixPenActivity.this,
                        // 绑定监听器
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                monthOfYear += 1;

                                plan_year_new = "" + year;
                                plan_month_new = "" + monthOfYear;
                                plan_day_new = "" + dayOfMonth;


                                fix_time.setText("您选择了：" + year + "年" + monthOfYear
                                        + "月" + dayOfMonth + "日");



                                Calendar c = Calendar.getInstance();
                                // 创建一个TimePickerDialog实例，并把它显示出来
                                new TimePickerDialog(FixPenActivity.this,
                                        // 绑定监听器
                                        new TimePickerDialog.OnTimeSetListener() {

                                            @Override
                                            public void onTimeSet(TimePicker view,
                                                                  int hourOfDay, int minute) {
                                                String s = fix_time.getText().toString();

                                                plan_hour_new = "" + hourOfDay;
                                                plan_minute_new = "" + minute;

                                                if(0 <= minute && minute <= 9){
                                                    fix_time.setText(s + " "+hourOfDay + ":0" + minute);
                                                }
                                                if(0 <= hourOfDay && hourOfDay <= 9){
                                                    fix_time.setText(s + "0" + hourOfDay + ":" + minute);
                                                }
                                                if(0 <= hourOfDay && hourOfDay <= 9 && 0 <= minute && minute <= 9){
                                                    fix_time.setText(s + "0" + hourOfDay + ":0" + minute);
                                                }

                                            }
                                        }
                                        // 设置初始时间
                                        , c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),
                                        // true表示采用24小时制
                                        true).show();


                            }
                        }
                        // 设置初始日期
                        , c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
                        .get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        fix_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plan_title_new = fix_title.getText().toString();
                plan_content_new = fix_content.getText().toString();

                Task task = new Task();
                task.setTask_title(plan_title_new);
                task.setTask_content(plan_content_new);
                task.setTask_year(plan_year_new);
                task.setTask_month(plan_month_new);
                task.setTask_day(plan_day_new);
                task.setTask_hour(plan_hour_new);
                task.setTask_minute(plan_minute_new);
                String ss = ""+task_id;
                task.updateAll("id = ?",ss);

                Log.i("fix", "fix success");
                Intent intent_PenToTask = new Intent(FixPenActivity.this,TaskActivity.class);
                startActivity(intent_PenToTask);

            }
        });


    }


}
