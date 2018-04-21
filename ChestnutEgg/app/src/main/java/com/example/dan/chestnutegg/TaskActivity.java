package com.example.dan.chestnutegg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.adapter.TaskAdapter;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.rey.material.app.Dialog;
import com.rey.material.widget.EditText;
import com.rey.material.widget.LinearLayout;
import com.sql.modal.Task;
import com.yalantis.phoenix.PullToRefreshView;
import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<Task> tasks;
    private TaskAdapter adapter;


    private PullToRefreshView mPullToRefreshView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        //初始化数据库
        LitePal.getDatabase();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);


        recyclerView = (RecyclerView) findViewById(R.id.rv_task);

        //initDatabase();
        initPersonData();
        adapter = new TaskAdapter(tasks, TaskActivity.this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


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
                .addItem(new BottomNavigationItem(R.drawable.home_grey_24x24, "便签"))
                .addItem(new BottomNavigationItem(R.drawable.train_white_24x24, "火车"))
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor("#519773")
                .setBarBackgroundColor("#F3EDED")
                .setFirstSelectedPosition(0)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {

                switch (position){

                    case 0:
                        break;

                    case 1:
                        Intent intent_0 = new Intent(TaskActivity.this, MainActivity.class);
                        startActivity(intent_0);
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

    private void initDatabase() {
        //向数据库插入数据
        new Task("借书","5教3栋12号","2018","4","30","14","23",1).save();
        new Task("借书2","5教3栋13号","2018","4","30","14","25",1).save();
        new Task("借书3","5教3栋14号","2018","4","30","14","27",1).save();
    }

    private void initPersonData() {
        tasks = new ArrayList<>();
        //添加至界面
        //tasks = DataSupport.findAll(Task.class);
        tasks = DataSupport.where("isshow == ?","1").find(Task.class);
        Collections.reverse(tasks);
    }

}
