package com.example.edwardfoux.opentablenytimes.network;

import com.example.edwardfoux.opentablenytimes.model.NYTimesResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataModel {
  @GET("/svc/movies/v2/reviews/dvd-picks.json")
  Observable<NYTimesResponse> getDvdPicks(@Query("api-key") String key,
                                          @Query("order") String order);
}
