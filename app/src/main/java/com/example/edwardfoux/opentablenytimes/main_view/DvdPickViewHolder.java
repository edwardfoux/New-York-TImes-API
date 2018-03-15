package com.example.edwardfoux.opentablenytimes.main_view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edwardfoux.opentablenytimes.R;
import com.example.edwardfoux.opentablenytimes.model.DvdPick;
import com.example.edwardfoux.opentablenytimes.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DvdPickViewHolder extends RecyclerView.ViewHolder {

    public static final String UI_DATE_FORMAT = "dd MMM";
    public static final String DATE_FORMAT_1 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_2 = "yyyy-MM-dd hh:mm:ss";

    private TextView title;
    private TextView headline;
    private TextView summary;
    private TextView opening;
    private TextView published;
    private TextView updated;
    private TextView rating;
    private TextView pick;
    private ImageView imageView;
    private View button;

    DvdPickViewHolder(View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        headline = itemView.findViewById(R.id.headline);
        summary = itemView.findViewById(R.id.summary);
        opening = itemView.findViewById(R.id.opening_value);
        published = itemView.findViewById(R.id.published_value);
        updated = itemView.findViewById(R.id.updated_value);
        rating = itemView.findViewById(R.id.rating);
        pick = itemView.findViewById(R.id.pick_value);
        imageView = itemView.findViewById(R.id.image);
        button = itemView.findViewById(R.id.link);
    }

    void setup(DvdPick dvdPick) {
        String publishedDate = DateUtil.getDateByFormat(DATE_FORMAT_1, UI_DATE_FORMAT, dvdPick.getPublication_date());
        published.setVisibility("".equals(publishedDate) ? View.GONE : View.VISIBLE);

        String openingDate = DateUtil.getDateByFormat(DATE_FORMAT_1, UI_DATE_FORMAT, dvdPick.getOpening_date());
        opening.setVisibility("".equals(openingDate) ? View.GONE : View.VISIBLE);

        String updatedDate = DateUtil.getDateByFormat(DATE_FORMAT_2, UI_DATE_FORMAT, dvdPick.getDate_updated());
        updated.setVisibility("".equals(updatedDate) ? View.GONE : View.VISIBLE);

        title.setText(dvdPick.getDisplay_title());
        headline.setText(dvdPick.getHeadline());
        summary.setText(dvdPick.getSummary_short());
        opening.setText(openingDate);
        published.setText(publishedDate);
        updated.setText(updatedDate);
        rating.setText(dvdPick.getMpaa_rating());
        pick.setText(String.valueOf(dvdPick.getCritics_pick()));

        Glide
                .with(imageView)
                .load(dvdPick.getMultimedia().getSrc())
                .into(imageView);

        button.setOnClickListener(__ -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(dvdPick.getLink().getUrl()));
            button.getContext().startActivity(i);
        });

    }
}
