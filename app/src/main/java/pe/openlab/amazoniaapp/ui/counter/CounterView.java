package pe.openlab.amazoniaapp.ui.counter;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import pe.openlab.amazoniaapp.R;
import pe.openlab.amazoniaapp.data.entity.Measure;
import pe.openlab.amazoniaapp.ui.help.HelpActivity;

public class CounterView extends AppCompatActivity implements Counter.View {

    private Counter.Presenter presenter;
    private ElegantNumberButton counterNacional, counterExtranjero, counterLibre;
    private Button btnRegistrar;
    private FloatingActionButton fabHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        counterNacional = findViewById(R.id.counter_nacional);
        counterExtranjero = findViewById(R.id.counter_extranjero);
        counterLibre = findViewById(R.id.counter_libre);
        btnRegistrar = findViewById(R.id.btn_registrar);
        fabHelp = findViewById(R.id.fab_help);

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
        Measure measure = new Measure(Integer.parseInt(counterNacional.getNumber()), Integer.parseInt(counterExtranjero.getNumber()), Integer.parseInt(counterLibre.getNumber()));
        if (isNetworkConnected(this)) {
            presenter.sendData(measure);
        } else {
            presenter.saveData(measure);
        }
    }

    @Override
    public void dataSuccessful(Measure measure) {
        Snackbar.make(findViewById(R.id.container), measure.getComment(), Snackbar.LENGTH_LONG).show();
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
        counterLibre.setNumber("0");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
