package pe.openlab.amazoniaapp.ui.counter;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.text.SimpleDateFormat;
import java.util.Date;

import pe.openlab.amazoniaapp.R;
import pe.openlab.amazoniaapp.ui.help.HelpActivity;

public class CounterView extends AppCompatActivity implements Counter.View {

    private Counter.Presenter presenter;
    private ElegantNumberButton counterNacional, counterExtranjero, counterExonerado;
    private Button btnRegistrar;
    private FloatingActionButton fabHelp;
    private TextView tvDescripcion, tv_date;

    int area_natural_id;
    String area_natural_name;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        area_natural_id = getIntent().getExtras().getInt("area_natural_id");
        area_natural_name = getIntent().getExtras().getString("area_natural_name");

        counterNacional = findViewById(R.id.counter_nacional);
        counterExtranjero = findViewById(R.id.counter_extranjero);
        counterExonerado = findViewById(R.id.counter_exonerado);
        btnRegistrar = findViewById(R.id.btn_registrar);
        fabHelp = findViewById(R.id.fab_help);
        tvDescripcion = findViewById(R.id.tv_descripcion);
        tv_date = findViewById(R.id.tv_date);

        Spanned text = Html.fromHtml("Registra el número de turistas que visitan <b>" + area_natural_name + "</b>");
        tvDescripcion.setText(text);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE d MMMM yyyy");
        date = new Date();
        tv_date.setText(sdf.format(date).toUpperCase());

        presenter = new CounterPresenter(this);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });

        fabHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CounterView.this, HelpActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void sendData() {

        if (isNetworkConnected(this)) {
            presenter.sendData(new SimpleDateFormat("yyyy-MM-dd").format(date), Integer.parseInt(counterExonerado.getNumber()), Integer.parseInt(counterExtranjero.getNumber()), Integer.parseInt(counterNacional.getNumber()), area_natural_id);
        } else {
            presenter.saveData(new SimpleDateFormat("yyyy-MM-dd").format(date), Integer.parseInt(counterExonerado.getNumber()), Integer.parseInt(counterExtranjero.getNumber()), Integer.parseInt(counterNacional.getNumber()), area_natural_id);
        }
    }

    @Override
    public void dataSuccessful(String message) {
        Snackbar.make(findViewById(R.id.container), message, Snackbar.LENGTH_LONG).show();
        resetCounters();
    }

    @Override
    public void dataError(String error) {
        Snackbar.make(findViewById(R.id.container), error, Snackbar.LENGTH_LONG).show();

    }

    @Override
    public boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void resetCounters() {
        counterNacional.setNumber("0");
        counterExtranjero.setNumber("0");
        counterExonerado.setNumber("0");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
