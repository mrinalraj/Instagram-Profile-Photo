package com.mrinalraj.instaprofilephoto.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mrinalraj.instaprofilephoto.R;
import com.mrinalraj.instaprofilephoto.adapter.HistoryAdapter;
import com.mrinalraj.instaprofilephoto.adapter.Username;
import com.mrinalraj.instaprofilephoto.database.DatabaseInteraction;
import com.mrinalraj.instaprofilephoto.listeners.RecyclerTouchListener;
import com.mrinalraj.instaprofilephoto.network.GetLink;

import java.util.ArrayList;
import java.util.List;

public class history extends AppCompatActivity {
    Button del;
    DatabaseInteraction db;
    List<Username> UList= new ArrayList<Username>();
    RecyclerView history;
    HistoryAdapter historyAdapter;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("History");
        getSupportActionBar().setElevation(0);
        db=new DatabaseInteraction(this,null);

        history= (RecyclerView) findViewById(R.id.history_list);
        historyAdapter=new HistoryAdapter(UList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        history.setLayoutManager(mLayoutManager);
        history.setItemAnimator(new DefaultItemAnimator());
        history.setAdapter(historyAdapter);

        prepareData();

        history.addOnItemTouchListener(new RecyclerTouchListener(this,history, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Username uname=UList.get(position);
                username=uname.getUsername();
                new GetLink(history.this).execute(username);
            }

            @Override
            public void onLongClick(View view, int position) {
                Username uname=UList.get(position);
                db.delete(uname.getUsername());
                prepareData();

            }
        }));


        del= (Button) findViewById(R.id.clear);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteAll();
                prepareData();
            }
        });

    }
    private void prepareData() {
        UList.clear();
        String[] users=db.readAll();
        for(int i=0;i<users.length;i++){
            UList.add(new Username(users[i]));
        }
        Log.d("method running" , "prepare data");
        historyAdapter.notifyDataSetChanged();
    }
}
