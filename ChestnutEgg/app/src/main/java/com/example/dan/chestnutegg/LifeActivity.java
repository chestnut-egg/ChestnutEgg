package com.example.dan.chestnutegg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.google.gson.Gson;
import com.weather.Hewind;
import com.yalantis.phoenix.PullToRefreshView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LifeActivity extends AppCompatActivity {

    TextView life_city;
    TextView life_tmp_now;
    TextView life_cond_now;


    //刷新
    private PullToRefreshView mPullToRefreshView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);


        life_city = (TextView) findViewById(R.id.life_city);
        life_tmp_now = (TextView) findViewById(R.id.life_tmp_now);
        life_cond_now = (TextView) findViewById(R.id.life_cond_now);


        sendRequestWithHttpURLConnection();


        Button life_weather_share = (Button) findViewById(R.id.life_weather_share);

        life_weather_share.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, life_city.getText()+"的"+life_tmp_now.getText());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent, "天气"));
            }
        });






        //刷新
        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.refresh_life);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh_life();
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, 1500);
            }
        });



        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar_life);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.task_white_24x24, "便签"))
                .addItem(new BottomNavigationItem(R.drawable.train_white_24x24, "火车"))
                .addItem(new BottomNavigationItem(R.drawable.smile_white_24x24, "生活"))
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor("#519773")
                .setBarBackgroundColor("#F3EDED")
                .setFirstSelectedPosition(2)
                .initialise();


        //底部导航栏
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {

                switch (position){

                    case 0:
                        Log.i("switch", "0");
                        Intent intent_1 = new Intent(LifeActivity.this, TaskActivity.class);
                        startActivity(intent_1);
                        break;

                    case 1:
                        Log.i("switch", "1");
                        Intent intent_2 = new Intent(LifeActivity.this, MainActivity.class);
                        startActivity(intent_2);
                        break;

                    case 2:
                        Log.i("switch", "2");
                        break;

                }


            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });



    }


    //刷新activity
    public void refresh_life() {

        finish();
        Intent intent = new Intent(LifeActivity.this, LifeActivity.class);
        startActivity(intent);

    }


    //weather
    private void sendRequestWithHttpURLConnection() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("1", "begin: ");
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("https://free-api.heweather.com/s6/weather?location=auto_ip&key=b3a04a0e520a402fa290f755796fc308");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();

                    //对获取到的输入流进行读取

                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Log.i("1", "send");
                    resolveJson(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();

    }

    //解析json数据
    private void resolveJson(final String response){

        //new一个Gson对象
        Gson gson = new Gson();
        //将json字符串转为bean对象
        Hewind hewind = gson.fromJson(response,Hewind.class);

        String location = "";

        try {
            location = hewind.getHeWeather6().get(0).getBasic().getLocation();
        } catch( Exception e ) {
            //showResponse("0");
        }


        String s_life_tmp_now = hewind.getHeWeather6().get(0).getNow().getTmp();
        String s_life_cond_now = hewind.getHeWeather6().get(0).getNow().getCond_txt();

        /*
        String s_life_cond_d = hewind.getHeWeather6().get(0).getDaily_forecast().get(0).getCond_txt_d();
        String s_life_cond_n = hewind.getHeWeather6().get(0).getDaily_forecast().get(0).getCond_txt_n();
        String s_life_tmp_max = hewind.getHeWeather6().get(0).getDaily_forecast().get(0).getTmp_max();
        String s_life_tmp_min = hewind.getHeWeather6().get(0).getDaily_forecast().get(0).getTmp_min();
        */

        //Log.i("1", weather);
        showResponse(location,s_life_tmp_now,s_life_cond_now);
    }

    //收到天气修改UI
    private void showResponse(final String location,final String s_life_tmp_now,final String s_life_cond_now){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                life_city.setText(location);
                life_tmp_now.setText("当前温度：" + s_life_tmp_now+"℃");
                life_cond_now.setText(s_life_cond_now);

            }
        });
    }

}
