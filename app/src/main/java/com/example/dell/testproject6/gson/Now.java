package com.example.dell.testproject6.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 2019/12/21.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }

}
