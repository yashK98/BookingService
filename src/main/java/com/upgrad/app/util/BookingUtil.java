package com.upgrad.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BookingUtil {

    private static String dateFormatter(Date fromDate){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(fromDate);
        return format;
    }

    public static Integer diffDate(Date fromDate, Date toDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = sdf.parse(dateFormatter(fromDate));
        Date secondDate = sdf.parse(dateFormatter(toDate));

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        Integer diff = Math.toIntExact(TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS));
        return diff;
    }

    public static ArrayList<String> getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String> numberList = new ArrayList<String>();

        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }
        return numberList;
    }
}
