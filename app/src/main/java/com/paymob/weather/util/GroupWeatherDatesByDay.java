package com.paymob.weather.util;

import com.paymob.weather.data.model.response.CityWeather;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupWeatherDatesByDay {

    HashMap<Date, List<CityWeather>> groupedUserLogins = new HashMap();
    Calendar cal = Calendar.getInstance();

    public HashMap<Date, List<CityWeather>> parseTimeStamps(List<CityWeather> timeStamps) {

        List<Date> keyList = new ArrayList<>();

        for (CityWeather cityWeather : timeStamps) {

            cal.setTime(new Date((long) cityWeather.getDt() * 1000));
            cal.set(cal.HOUR_OF_DAY, 0);
            cal.set(cal.MINUTE, 0);
            cal.set(cal.SECOND, 0);
            cal.set(cal.MILLISECOND, 0);

            if (!groupedUserLogins.containsKey(cal.getTime())) {

                groupedUserLogins.put(cal.getTime(), new ArrayList<CityWeather>());
            }
            groupedUserLogins.get(cal.getTime()).add(cityWeather);
        }

        Set<Date> keySet = groupedUserLogins.keySet();
        keyList.addAll(keySet);
        return sortByValue(groupedUserLogins);
    }

    public static HashMap<Date, List<CityWeather>> sortByValue(HashMap<Date, List<CityWeather>> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<Date, List<CityWeather>>> list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Date, List<CityWeather>>>() {
            public int compare(Map.Entry<Date, List<CityWeather>> o1,
                               Map.Entry<Date, List<CityWeather>> o2) {
                return (o1.getKey().before(o2.getKey())) ? -1 : 1;
            }
        });

        // put data from sorted list to hashmap
        HashMap<Date, List<CityWeather>> temp = new LinkedHashMap<>();
        for (Map.Entry<Date, List<CityWeather>> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}