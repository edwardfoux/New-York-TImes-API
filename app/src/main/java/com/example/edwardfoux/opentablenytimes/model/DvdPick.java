package com.example.edwardfoux.opentablenytimes.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DvdPick implements Parcelable {

    private String display_title;
    private String mpaa_rating;
    private String byline;
    private String headline;
    private String summary_short;
    private String publication_date;
    private String opening_date;
    private String date_updated;
    private int critics_pick;
    private Link link;
    private Multimedia multimedia;

    public String getDisplay_title() {
        return display_title;
    }

    public void setDisplay_title(String display_title) {
        this.display_title = display_title;
    }

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public void setMpaa_rating(String mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary_short() {
        return summary_short;
    }

    public void setSummary_short(String summary_short) {
        this.summary_short = summary_short;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(String opening_date) {
        this.opening_date = opening_date;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public int getCritics_pick() {
        return critics_pick;
    }

    public void setCritics_pick(int critics_pick) {
        this.critics_pick = critics_pick;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.display_title);
        dest.writeString(this.mpaa_rating);
        dest.writeString(this.byline);
        dest.writeString(this.headline);
        dest.writeString(this.summary_short);
        dest.writeString(this.publication_date);
        dest.writeString(this.opening_date);
        dest.writeString(this.date_updated);
        dest.writeInt(this.critics_pick);
        dest.writeParcelable(this.link, flags);
        dest.writeParcelable(this.multimedia, flags);
    }

    public DvdPick() {
    }

    protected DvdPick(Parcel in) {
        this.display_title = in.readString();
        this.mpaa_rating = in.readString();
        this.byline = in.readString();
        this.headline = in.readString();
        this.summary_short = in.readString();
        this.publication_date = in.readString();
        this.opening_date = in.readString();
        this.date_updated = in.readString();
        this.critics_pick = in.readInt();
        this.link = in.readParcelable(Link.class.getClassLoader());
        this.multimedia = in.readParcelable(Multimedia.class.getClassLoader());
    }

    public static final Parcelable.Creator<DvdPick> CREATOR = new Parcelable.Creator<DvdPick>() {
        @Override
        public DvdPick createFromParcel(Parcel source) {
            return new DvdPick(source);
        }

        @Override
        public DvdPick[] newArray(int size) {
            return new DvdPick[size];
        }
    };
}
