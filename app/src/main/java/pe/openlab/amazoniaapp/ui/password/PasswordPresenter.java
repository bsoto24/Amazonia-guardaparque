package pe.openlab.amazoniaapp.ui.password;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public class PasswordPresenter implements Password.Presenter {

    private Password.View view;
    private Password.Model model;

    public PasswordPresenter(Password.View view) {
        this.view = view;
        model = new PasswordModel(this);
    }

    @Override
    public void restorePassword(String email) {
        model.restorePassword(email);
    }

    @Override
    public void restoreSuccessfull(String message) {
        view.restoreSuccessfull(message);
    }

    @Override
    public void restoreError(String error) {
        view.restoreError(error);
    }
}
