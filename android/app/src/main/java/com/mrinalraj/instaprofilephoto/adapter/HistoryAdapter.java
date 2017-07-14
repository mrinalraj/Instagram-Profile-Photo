package com.mrinalraj.instaprofilephoto.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mrinalraj.instaprofilephoto.R;

import java.util.List;

/**
 * Created by Mystique on 17-06-2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    private List<Username> userList;

    public HistoryAdapter(List<Username> userList){
        this.userList=userList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Username user = userList.get(position);
        holder.usern.setText(user.getUsername());

    }



    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView usern;
        public MyViewHolder(View itemView) {
            super(itemView);
            usern= (TextView) itemView.findViewById(R.id.username);
        }
    }
}
