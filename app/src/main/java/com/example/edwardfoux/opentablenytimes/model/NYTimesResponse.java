package com.example.edwardfoux.opentablenytimes.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class NYTimesResponse implements Parcelable {
    private List<DvdPick> results;

    public List<DvdPick> getResults() {
        return results;
    }

    public void setResults(List<DvdPick> results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.results);
    }

    public NYTimesResponse() {
    }

    protected NYTimesResponse(Parcel in) {
        this.results = in.createTypedArrayList(DvdPick.CREATOR);
    }

    public static final Parcelable.Creator<NYTimesResponse> CREATOR = new Parcelable.Creator<NYTimesResponse>() {
        @Override
        public NYTimesResponse createFromParcel(Parcel source) {
            return new NYTimesResponse(source);
        }

        @Override
        public NYTimesResponse[] newArray(int size) {
            return new NYTimesResponse[size];
        }
    };
}
