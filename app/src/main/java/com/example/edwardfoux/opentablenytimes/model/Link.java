package com.example.edwardfoux.opentablenytimes.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Link implements Parcelable {

    private String type;
    private String url;
    private String suggested_link_text;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSuggested_link_text() {
        return suggested_link_text;
    }

    public void setSuggested_link_text(String suggested_link_text) {
        this.suggested_link_text = suggested_link_text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.url);
        dest.writeString(this.suggested_link_text);
    }

    public Link() {
    }

    protected Link(Parcel in) {
        this.type = in.readString();
        this.url = in.readString();
        this.suggested_link_text = in.readString();
    }

    public static final Parcelable.Creator<Link> CREATOR = new Parcelable.Creator<Link>() {
        @Override
        public Link createFromParcel(Parcel source) {
            return new Link(source);
        }

        @Override
        public Link[] newArray(int size) {
            return new Link[size];
        }
    };
}
