package pe.openlab.amazoniaapp.ui.password;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import pe.openlab.amazoniaapp.R;

public class PasswordView extends AppCompatActivity implements Password.View {

    private TextInputEditText edtEmail;
    private Button btnRestore;
    private Password.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restore_password);
        showToolbar("Restaurar contraseña", true);

        edtEmail = findViewById(R.id.edt_email);
        btnRestore = findViewById(R.id.btn_restore);

        presenter = new PasswordPresenter(this);

        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restorePassword();
            }
        });

    }

    @Override
    public void restorePassword() {
        presenter.restorePassword(edtEmail.getText().toString());
    }

    @Override
    public void restoreSuccessfull(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enlace enviado");
        builder.setMessage(message);

        builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void restoreError(String error) {
        Snackbar.make(findViewById(R.id.container), error, Snackbar.LENGTH_LONG).show();
    }

    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}