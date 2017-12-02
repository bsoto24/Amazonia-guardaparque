package pe.openlab.amazoniaapp.ui.counter;

import android.content.Context;

import pe.openlab.amazoniaapp.data.entity.Measure;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public interface Counter {

    interface View {
        void sendData();

        void dataSuccessful(Measure measure);

        void dataError(String error);

        boolean isNetworkConnected(Context context);

        void resetCounters();
    }

    interface Presenter {

        void dataSuccessful(Measure measure);

        void dataError(String error);

        void sendData(Measure measure);

        void saveData(Measure measure);

    }

    interface Model {
        void sendData(Measure measure);

        void saveData(Measure measure);

    }
}
