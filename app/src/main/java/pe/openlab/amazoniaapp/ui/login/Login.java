package pe.openlab.amazoniaapp.ui.login;

import pe.openlab.amazoniaapp.data.entity.User;

/**
 * Created by Bryam Soto on 30/11/2017.
 */

public interface Login {

    interface View {
        void login();

        void loginSuccessful(User user);

        void loginError(String error);

        void restorePassword();
    }

    interface Presenter {

        void loginSuccessful(User user);

        void loginError(String error);

        void login(String email, String password);

    }

    interface Model {

        void login(String user, String password);

    }
}
