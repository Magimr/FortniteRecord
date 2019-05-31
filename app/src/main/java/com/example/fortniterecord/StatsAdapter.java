package com.example.fortniterecord;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.StatsViewHolder> {
    private List<LifeTimeStats> mItemList;
    private LayoutInflater mInflater;
    private Context context;
    public StatsAdapter(Context context, List<LifeTimeStats> itemsList){
        mInflater = LayoutInflater.from(context);
        this.mItemList = itemsList;
        this.context = context;
    }
    class StatsViewHolder extends RecyclerView.ViewHolder{
        public final TextView txtKey;
        public final TextView txtValueGeneral;

        final StatsAdapter mAdapter;

        public StatsViewHolder(View itemView, StatsAdapter adapter){
            super(itemView);
            txtKey = itemView.findViewById(R.id.txtKey);
            txtValueGeneral = itemView.findViewById(R.id.txtValueGeneral);
            this.mAdapter = adapter;
        }

    }
    public StatsAdapter() {
        super();
    }

    @NonNull
    @Override
    public StatsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View mItemView = mInflater
                .inflate(R.layout.items_stats, viewGroup, false);
        return new StatsViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsViewHolder statsViewHolder, int position) {
        LifeTimeStats mCurrent = mItemList.get(position);
        statsViewHolder.txtKey.setText((mCurrent.getKey()));
        statsViewHolder.txtValueGeneral.setText(mCurrent.getValue());

    }

    @Override
    public int getItemCount() {
        if(mItemList == null) {
            return 0;
        }

        return mItemList.size();
    }

    public void setData(List <LifeTimeStats> newList){
        mItemList = newList;
        notifyDataSetChanged();
    }
}