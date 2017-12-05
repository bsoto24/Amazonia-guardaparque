package pe.openlab.amazoniaapp.ui.login;

import android.util.Log;

import pe.openlab.amazoniaapp.data.entity.User;
import pe.openlab.amazoniaapp.data.remote.ServiceFactory;
import pe.openlab.amazoniaapp.data.remote.request.LoginRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        LoginRequest loginService =
                ServiceFactory.createService(LoginRequest.class);
        Call<User> call = loginService.login(email, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    presenter.loginSuccessful(response.body().getProtectedNaturalArea().getId(), response.body().getProtectedNaturalArea().getName());
                } else {
                    presenter.loginError("Correo y/o contraseña inválido");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                presenter.loginError("Ocurrió un error");
            }
        });
    }

}
