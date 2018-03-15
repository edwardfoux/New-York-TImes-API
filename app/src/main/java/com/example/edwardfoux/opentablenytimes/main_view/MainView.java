package com.example.edwardfoux.opentablenytimes.main_view;

import com.example.edwardfoux.opentablenytimes.model.DvdPick;

import java.util.List;

public interface MainView {
    void onDataAvailable(List<DvdPick> data);
    boolean isNetworkAvailable();
    void showErrorMessage(int message);
}
