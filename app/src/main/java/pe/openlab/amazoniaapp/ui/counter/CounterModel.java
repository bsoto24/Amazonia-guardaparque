package pe.openlab.amazoniaapp.ui.counter;

import pe.openlab.amazoniaapp.data.entity.Measure;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public class CounterModel implements Counter.Model {

    private Counter.Presenter presenter;

    public CounterModel(Counter.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void sendData(Measure measure) {
        try {
            //ENVIANDO DATA
            measure.setComment("Enviando datos");
            presenter.dataSuccessful(measure);
        } catch (Exception e) {
            presenter.dataError("No se pudieron enviar los datos");
        }
    }

    @Override
    public void saveData(Measure measure) {
        try {
            //GUARDANDO DATA
            measure.setComment("Guardando datos");
            presenter.dataSuccessful(measure);
        } catch (Exception e) {
            presenter.dataError("No se pudieron guardar los datos");
        }}

}
