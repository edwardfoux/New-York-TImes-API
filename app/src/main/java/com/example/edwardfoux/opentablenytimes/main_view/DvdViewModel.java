package com.example.edwardfoux.opentablenytimes.main_view;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.edwardfoux.opentablenytimes.R;
import com.example.edwardfoux.opentablenytimes.model.DvdPick;
import com.example.edwardfoux.opentablenytimes.network.DataModel;
import com.example.edwardfoux.opentablenytimes.network.NetworkService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DvdViewModel extends ViewModel {

    private static final String TAG = "DvdViewModel";
    private MainView view;
    private DataModel model;
    private Scheduler androidScheduler;
    private Scheduler processScheduler;
    private CompositeDisposable cd = new CompositeDisposable();
    private List<DvdPick> data = new ArrayList<>();

    void setView(MainView view, DataModel model, Scheduler processScheduler, Scheduler androidScheduler) {
        this.view = view;
        this.model = model;
        this.androidScheduler = androidScheduler;
        this.processScheduler = processScheduler;
        cd.dispose();
        cd = new CompositeDisposable();
    }

    void loadData() {

        if (!view.isNetworkAvailable()) {
            view.showErrorMessage(R.string.error_message);
            return;
        }

        if (data.isEmpty()) {
            Disposable disposable = model
                    .getDvdPicks(NetworkService.KEY, NetworkService.ORDER_BY_DATE)
                    .subscribeOn(androidScheduler)
                    .observeOn(processScheduler)
                    .subscribe(response -> updateData(response.getResults()),
                            error -> Log.e(TAG, error.toString()));
            cd.add(disposable);
        } else {
            view.onDataAvailable(data);
        }
    }

    private void updateData(List<DvdPick> data) {
        this.data = data;
        view.onDataAvailable(data);
    }

    void onViewDestroyed() {
        cd.dispose();
        cd.clear();
    }
}
