package com.example.dan.chestnutegg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.yalantis.phoenix.PullToRefreshView;

public class TaskActivity extends AppCompatActivity {

    private PullToRefreshView mPullToRefreshView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);


        //pen
        final FloatingActionButton pen = (FloatingActionButton) findViewById(R.id.pen);
        pen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent_TaskToPen = new Intent(TaskActivity.this,PenActivity.class);
                startActivity(intent_TaskToPen);
            }
        });


        //刷新
        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.refresh_task);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh();
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, 1500);
            }
        });



        //底部导航栏
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar_task);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home_grey_24x24, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.home_white_24x24, "Books"))
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor("#519773")
                .setBarBackgroundColor("#F3EDED")
                .setFirstSelectedPosition(1)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {

                switch (position){

                    case 0:
                        Intent intent_0 = new Intent(TaskActivity.this, MainActivity.class);
                        startActivity(intent_0);
                        break;

                    case 1:
                        Log.i("switch", "1");
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
    public void refresh() {

        finish();
        Intent intent = new Intent(TaskActivity.this, TaskActivity.class);
        startActivity(intent);

    }

}
