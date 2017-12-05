package pe.openlab.amazoniaapp.ui.counter;

import android.content.Context;

import pe.openlab.amazoniaapp.data.entity.Measure;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public interface Counter {

    interface View {
        void sendData();

        void dataSuccessful(String message);

        void dataError(String error);

        boolean isNetworkConnected(Context context);

        void resetCounters();
    }

    interface Presenter {

        void dataSuccessful(String message);

        void dataError(String error);

        void sendData(String date, int exonerated, int foreign, int national, int area_natural);

        void saveData(String date, int exonerated, int foreign, int national, int area_natural);

    }

    interface Model {
        void sendData(String date, int exonerated, int foreign, int national, int area_natural);

        void saveData(String date, int exonerated, int foreign, int national, int area_natural);

    }
}
