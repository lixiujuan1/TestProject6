package com.example.dell.testproject6.gson;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 2019/12/21.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update upadate;

    public class Update{

        @SerializedName("loc")
        public String updateTime;
    }

}
