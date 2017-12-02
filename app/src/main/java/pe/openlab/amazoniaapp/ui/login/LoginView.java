package pe.openlab.amazoniaapp.ui.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pe.openlab.amazoniaapp.R;
import pe.openlab.amazoniaapp.data.entity.User;
import pe.openlab.amazoniaapp.ui.counter.CounterView;
import pe.openlab.amazoniaapp.ui.password.PasswordView;

public class LoginView extends AppCompatActivity implements Login.View {

    private Login.Presenter presenter;
    private TextInputEditText edtEmail, edtPassword;
    private Button btnLogin;
    private TextView tvRestorePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRestorePassword = findViewById(R.id.tv_restore_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        tvRestorePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restorePassword();
            }
        });
    }


    @Override
    public void login() {
        presenter.login(edtEmail.getText().toString(), edtPassword.getText().toString());
    }

    @Override
    public void loginSuccessful(User user) {
        Intent intent = new Intent(LoginView.this, CounterView.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginError(String error) {
        Snackbar.make(findViewById(R.id.container), error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void restorePassword() {
        Intent intent = new Intent(LoginView.this, PasswordView.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
