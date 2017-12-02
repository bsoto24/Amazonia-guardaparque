package pe.openlab.amazoniaapp.ui.login;

import pe.openlab.amazoniaapp.data.entity.User;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public class LoginModel implements Login.Model {

    private Login.Presenter presenter;

    LoginModel(Login.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void login(String email, String password) {
        if (email.equals("bsoto.dev@gmail.com") && password.equals("123456")) {
            presenter.loginSuccessful(new User(1, "Bryam Soto", email, "Guardabosque"));
        } else {
            presenter.loginError("Correo y/o contraseña inválido");
        }
    }

}
