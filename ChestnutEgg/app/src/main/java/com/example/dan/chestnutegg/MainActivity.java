package com.example.dan.chestnutegg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.widget.ScrollView;
import android.widget.TextView;
import com.adapter.RecyclerViewAdapter;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.sql.modal.Ticket;
import com.yalantis.phoenix.PullToRefreshView;
import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Ticket> tickets;
    private RecyclerViewAdapter adapter;
    private PullToRefreshView mPullToRefreshView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //初始化数据库
        LitePal.getDatabase();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);


        recyclerView = (RecyclerView) findViewById(R.id.rv);

        //initDatabase();
        initPersonData();
        adapter = new RecyclerViewAdapter(tickets, MainActivity.this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        //刷新
        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.refresh);
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

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home_grey_24x24, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.home_white_24x24, "Books"))
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
                        Log.i("switch", "0");
                        break;

                    case 1:
                        Log.i("switch", "1");
                        Intent intent_1 = new Intent(MainActivity.this, TaskActivity.class);
                        startActivity(intent_1);
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
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);

    }

    private void initDatabase() {
        //向数据库插入数据
        new Ticket("E001","K740","11月21日","21:30","成都","","嘉兴","11车21号下铺").save();
        new Ticket("E002","K741","11月22日","21:30","成都","","嘉兴","11车21号下铺").save();
        new Ticket("E003","K742","11月23日","21:30","成都","","嘉兴","11车21号下铺").save();
        new Ticket("E004","K743","11月24日","21:31","成都","","嘉兴","12车12号下铺").save();
    }

    private void initPersonData() {
        tickets = new ArrayList<>();
        //添加至界面
        tickets = DataSupport.findAll(Ticket.class);
        Collections.reverse(tickets);
    }


}

