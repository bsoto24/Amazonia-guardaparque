package pe.openlab.amazoniaapp.ui.password;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public class PasswordModel implements Password.Model {

    private Password.Presenter presenter;

    public PasswordModel(Password.Presenter presenter) {

        this.presenter = presenter;

    }

    @Override
    public void restorePassword(String email) {
        if (email.equals("bsoto.dev@gmail.com")) {
            presenter.restoreSuccessfull("Hola Bryam, te enviamos un enlace para que restablescas tu contraseña");
        } else {
            presenter.restoreError("Usuario inválido");
        }

    }
}
