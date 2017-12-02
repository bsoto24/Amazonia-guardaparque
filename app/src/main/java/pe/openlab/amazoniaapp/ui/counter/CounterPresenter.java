package pe.openlab.amazoniaapp.ui.counter;

import pe.openlab.amazoniaapp.data.entity.Measure;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public class CounterPresenter implements Counter.Presenter {

    private Counter.View view;
    private Counter.Model model;

    public CounterPresenter(Counter.View view) {

        this.view = view;
        model = new CounterModel(this);
    }


    @Override
    public void dataSuccessful(Measure measure) {
        view.dataSuccessful(measure);
    }

    @Override
    public void dataError(String error) {
        view.dataError(error);
    }

    @Override
    public void sendData(Measure measure) {
        model.sendData(measure);
    }

    @Override
    public void saveData(Measure measure) {
        model.saveData(measure);
    }
}
