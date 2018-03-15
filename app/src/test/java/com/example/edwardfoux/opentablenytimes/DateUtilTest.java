package com.example.edwardfoux.opentablenytimes;

import com.example.edwardfoux.opentablenytimes.main_view.DvdPickViewHolder;
import com.example.edwardfoux.opentablenytimes.util.DateUtil;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testDate1() {
        String date = DateUtil.getDateByFormat(DvdPickViewHolder.DATE_FORMAT_1, DvdPickViewHolder.UI_DATE_FORMAT, "2018-03-09");

        Assert.assertEquals("09 Mar", date);
    }

    @Test
    public void testDate2() {
        String date = DateUtil.getDateByFormat(DvdPickViewHolder.DATE_FORMAT_2, DvdPickViewHolder.UI_DATE_FORMAT, "2018-03-08 17:44:22");

        Assert.assertEquals("08 Mar", date);
    }
}
