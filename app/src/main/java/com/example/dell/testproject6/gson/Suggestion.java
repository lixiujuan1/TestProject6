package com.example.dell.testproject6.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 2019/12/21.
 */

public class Suggestion {
    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;

    public class Comfort{
        @SerializedName("txt")
        public String info;
    }

    public class CarWash{
        @SerializedName("txt")
        public String info;
    }


    public class Sport{
        @SerializedName("txt")
        public String info;
    }
}
