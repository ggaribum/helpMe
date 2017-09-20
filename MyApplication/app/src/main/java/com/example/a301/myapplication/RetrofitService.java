package com.example.a301.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by 301 on 2017-09-19.
 */

public interface RetrofitService {
    @Headers({"Accept: application/json"})
    @GET("service/SecndSrtpdFrcstInfoService2/ForecastGrib")
    Call<GsonVO> loadAnswer(@Query("ServiceKey")String ServiceKey,@Query("nx")String nx,@Query("ny")String ny,@Query("base_date")String base_date,@Query("base_time")String base_time,@Query("_type")String type);
}
