package com.example.edwardfoux.opentablenytimes.main_view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.edwardfoux.opentablenytimes.R;
import com.example.edwardfoux.opentablenytimes.model.DvdPick;
import com.example.edwardfoux.opentablenytimes.network.NetworkService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MainView {

    private DvdAdapter adapter;
    private DvdViewModel viewModel;

    @BindView(R.id.list) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView = findViewById(R.id.list);
        adapter = new DvdAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(DvdViewModel.class);
        viewModel.setView(this, new NetworkService().getDataModel(), AndroidSchedulers.mainThread(), Schedulers.io());
        viewModel.loadData();
    }

    @Override
    public void onDataAvailable(List<DvdPick> data) {
        adapter.setDvdPickList(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onViewDestroyed();
    }

    @Override
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void showErrorMessage(int message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
