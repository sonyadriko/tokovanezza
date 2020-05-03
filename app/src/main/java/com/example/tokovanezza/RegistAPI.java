package com.example.tokovanezza;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegistAPI {

    @FormUrlEncoded
    @POST("/insertbarang.php")
    Call<Value> tmbhbarang (@Field("barang") String nama,
                            @Field("harga") String harga,
                            @Field("tempat") String tempat);
}
