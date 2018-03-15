package com.example.edwardfoux.opentablenytimes.network;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

  public static final String ORDER_BY_DATE = "by-date";
  public static final String KEY = "b75da00e12d54774a2d362adddcc9bef";

  private Retrofit retrofit = null;
  private DataModel api = null;

  private Retrofit getRetrofit() {
    if (retrofit == null) {
      retrofit = new Builder()
          .baseUrl("http://api.nytimes.com")
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }

  public DataModel getDataModel() {
    if (api == null) {
      api = getRetrofit().create(DataModel.class);
    }
    return api;
  }
}
