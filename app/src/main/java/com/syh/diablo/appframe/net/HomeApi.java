package com.syh.diablo.appframe.net;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yonghe.shen on 2017/11/27.
 */

public interface HomeApi {

    @GET("trade/marginRatio")
    Observable<MarginRatioData> getMarginRatio(@Query("instrumentId") String instrumentId, @Query("flag") String flag);
}
