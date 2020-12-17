package com.example.ssu.Helper;

import java.util.*;

public abstract class AbstractStatus {
    public static final Integer ACTIVE = 1;
    public static final Integer ARCHIVE = 21;

    protected static Map<Integer,String> statusNames =  new HashMap<Integer, String>()
    {
        {
            put(ACTIVE, "Активный");
            put(ARCHIVE, "Архивный");
        }
    };

    public Map<Integer,String> getStatusNames()
    {
        return statusNames;
    }

    public static String getName(Integer key)
    {
        if (statusNames.containsKey(key)) {
               return statusNames.get(key);
        }
        return "";
    }
}
