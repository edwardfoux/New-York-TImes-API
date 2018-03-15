package com.example.edwardfoux.opentablenytimes.main_view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edwardfoux.opentablenytimes.R;
import com.example.edwardfoux.opentablenytimes.model.DvdPick;

import java.util.ArrayList;
import java.util.List;

public class DvdAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DvdPick> dvdPickList = new ArrayList<>();

    void setDvdPickList(List<DvdPick> dvdPickList) {
        this.dvdPickList = dvdPickList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dvd_view, parent, false);
        return new DvdPickViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DvdPickViewHolder dvdPickViewHolder = (DvdPickViewHolder) holder;
        DvdPick dvdPick = dvdPickList.get(position);
        dvdPickViewHolder.setup(dvdPick);
    }

    @Override
    public int getItemCount() {
        return dvdPickList.size();
    }
}
