package com.example.edwardfoux.opentablenytimes.util;

import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String getDateByFormat(String inputFormat, String outputFormat, String date) {
        SimpleDateFormat outputSDF = new SimpleDateFormat(outputFormat, Locale.US);
        String outputDate = "";
        try {
            SimpleDateFormat spf = new SimpleDateFormat(inputFormat, Locale.US);
            Date newPublishedDate = spf.parse(date);
            outputDate = outputSDF.format(newPublishedDate);
        } catch (Exception e ) {

        }
        return outputDate;
    }
}
