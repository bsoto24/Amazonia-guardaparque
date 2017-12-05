package pe.openlab.amazoniaapp.ui.counter;

import android.util.Log;

import pe.openlab.amazoniaapp.data.entity.Measure;
import pe.openlab.amazoniaapp.data.remote.ServiceFactory;
import pe.openlab.amazoniaapp.data.remote.request.MeasureRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public class CounterModel implements Counter.Model {

    private Counter.Presenter presenter;

    public CounterModel(Counter.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void sendData(String date, int exonerated, int foreign, int national, int area_natural) {
        MeasureRequest measureRequest = ServiceFactory.createService(MeasureRequest.class);
        Call<Measure> call = measureRequest.sendData(date, exonerated, foreign, national, area_natural);
        call.enqueue(new Callback<Measure>() {
            @Override
            public void onResponse(Call<Measure> call, Response<Measure> response) {
                if (response.isSuccessful()) {
                    presenter.dataSuccessful("Informacion enviada");
                } else {
                    presenter.dataError("Ocurrio un error");
                }
            }

            @Override
            public void onFailure(Call<Measure> call, Throwable t) {
                presenter.dataError("Ocurrió un error");
            }
        });
    }

    @Override
    public void saveData(String date, int exonerated, int foreign, int national, int area_natural) {
        try {
            //GUARDANDO DATA
            Log.e("JXJXJXJX", date);
            presenter.dataSuccessful("Enviaremos los datos cuando tengas internet");
        } catch (Exception e) {
            presenter.dataError("No se pudieron guardar los datos");
        }
    }

}