package pe.openlab.amazoniaapp.data.remote.request;

import pe.openlab.amazoniaapp.data.entity.Measure;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Bryam Soto on 05/12/2017.
 */

public interface MeasureRequest {
    @FormUrlEncoded
    @POST("visits/")
    Call<Measure> sendData(@Field("date") String date, @Field("exonerated") int exonerated, @Field("foreign") int foreign, @Field("national") int national, @Field("protected_natural_area") int protected_natural_area);
}
