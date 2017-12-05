package pe.openlab.amazoniaapp.ui.counter;

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
    public void dataSuccessful(String message) {
        view.dataSuccessful(message);
    }

    @Override
    public void dataError(String error) {
        view.dataError(error);
    }

    @Override
    public void sendData(String date, int exonerated, int foreign, int national, int area_natural) {
        model.sendData(date, exonerated, foreign, national, area_natural);
    }

    @Override
    public void saveData(String date, int exonerated, int foreign, int national, int area_natural) {
        model.saveData(date, exonerated, foreign, national, area_natural);
    }
}