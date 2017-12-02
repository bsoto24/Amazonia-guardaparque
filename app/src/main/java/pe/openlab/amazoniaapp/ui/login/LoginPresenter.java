package pe.openlab.amazoniaapp.ui.login;

import pe.openlab.amazoniaapp.data.entity.User;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public class LoginPresenter implements Login.Presenter {

    private Login.View view;
    private Login.Model model;

    LoginPresenter(Login.View view) {
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void loginSuccessful(User user) {
        view.loginSuccessful(user);
    }

    @Override
    public void loginError(String error) {
        view.loginError(error);
    }

    @Override
    public void login(String email, String password) {
        model.login(email, password);
    }
}
