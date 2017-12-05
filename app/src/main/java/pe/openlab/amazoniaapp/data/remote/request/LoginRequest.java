package pe.openlab.amazoniaapp.data.remote.request;

import pe.openlab.amazoniaapp.data.entity.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginRequest {
    @FormUrlEncoded
    @POST("api-token-auth/")
    Call<User> login(@Field("username") String user, @Field("password") String password);
}
