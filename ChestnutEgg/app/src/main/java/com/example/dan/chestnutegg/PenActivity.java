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


public class PenActivity extends AppCompatActivity {

    private Button time;
    private Button sure;

    private TextView title;
    private TextView content;

    private String plan_year;
    private String plan_month;
    private String plan_day;
    private String plan_hour;
    private String plan_minute;

    private String plan_title;
    private String plan_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pen);
        time = (Button) findViewById(R.id.time);
        sure = (Button) findViewById(R.id.sure);

        title = (TextView) findViewById(R.id.plan_title);
        content = (TextView) findViewById(R.id.plan_content);

        plan_year = "";
        plan_month = "";
        plan_day = "";
        plan_hour = "";
        plan_minute = "";


        time.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Calendar c = Calendar.getInstance();
                // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
                new DatePickerDialog(PenActivity.this,
                        // 绑定监听器
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                monthOfYear += 1;

                                plan_year = "" + year;
                                plan_month = "" + monthOfYear;
                                plan_day = "" + dayOfMonth;


                                time.setText("您选择了：" + year + "年" + monthOfYear
                                        + "月" + dayOfMonth + "日");



                                Calendar c = Calendar.getInstance();
                                // 创建一个TimePickerDialog实例，并把它显示出来
                                new TimePickerDialog(PenActivity.this,
                                        // 绑定监听器
                                        new TimePickerDialog.OnTimeSetListener() {

                                            @Override
                                            public void onTimeSet(TimePicker view,
                                                                  int hourOfDay, int minute) {
                                                String s = time.getText().toString();

                                                plan_hour = "" + hourOfDay;
                                                plan_minute = "" + minute;

                                                if(0 <= minute && minute <= 9){
                                                    time.setText(s + " "+hourOfDay + ":0" + minute);
                                                }
                                                if(0 <= hourOfDay && hourOfDay <= 9){
                                                    time.setText(s + "0" + hourOfDay + ":" + minute);
                                                }
                                                if(0 <= hourOfDay && hourOfDay <= 9 && 0 <= minute && minute <= 9){
                                                    time.setText(s + "0" + hourOfDay + ":0" + minute);
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



        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plan_title = title.getText().toString();
                plan_content = content.getText().toString();


                if(plan_year.equals("")){
                    //未设置日期
                    new Task(plan_title,plan_content,"0",plan_month,plan_day,plan_hour,plan_minute,1).save();
                }else{
                    new Task(plan_title,plan_content,plan_year,plan_month,plan_day,plan_hour,plan_minute,1).save();
                }


                Intent intent_PenToTask = new Intent(PenActivity.this,TaskActivity.class);
                startActivity(intent_PenToTask);

            }
        });


    }


}
