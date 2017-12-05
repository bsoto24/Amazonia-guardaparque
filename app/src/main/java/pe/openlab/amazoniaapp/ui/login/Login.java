package pe.openlab.amazoniaapp.ui.login;

import pe.openlab.amazoniaapp.data.entity.User;

/**
 * Created by Bryam Soto on 30/11/2017.
 */

public interface Login {

    interface View {
        void login();

        void loginSuccessful(int area_natural_id, String area_natural_name);

        void loginError(String error);

        void restorePassword();
    }

    interface Presenter {

        void loginSuccessful(int area_natural_id, String area_natural_name);

        void loginError(String error);

        void login(String user, String password);

    }

    interface Model {

        void login(String user, String password);

    }
}
