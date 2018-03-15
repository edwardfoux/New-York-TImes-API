package com.example.edwardfoux.opentablenytimes.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Multimedia implements Parcelable {

    private String type;
    private String src;
    private int width;
    private int height;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.src);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
    }

    public Multimedia() {
    }

    protected Multimedia(Parcel in) {
        this.type = in.readString();
        this.src = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
    }

    public static final Parcelable.Creator<Multimedia> CREATOR = new Parcelable.Creator<Multimedia>() {
        @Override
        public Multimedia createFromParcel(Parcel source) {
            return new Multimedia(source);
        }

        @Override
        public Multimedia[] newArray(int size) {
            return new Multimedia[size];
        }
    };
}
