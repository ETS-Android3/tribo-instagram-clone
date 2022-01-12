package com.example.create.Fragments;



import com.example.create.Notifications.MyResponse;
import com.example.create.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAA9IM5KmA:APA91bHbrgZJKhIYdfQER3SnZngY_VnHQr2vYR30RsjZkJAf4n5WjNaf7Lxo2-RKtWF1ikppakXQNE_MiBW4IgGkyg2BRO38D9jqROewFPegFWkkYO83pAAoJyRX5i-48r0ok3_Udbx1"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
