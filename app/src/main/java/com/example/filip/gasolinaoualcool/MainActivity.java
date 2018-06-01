package com.example.filip.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainView{

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;
    private ProgressBar progressBar;
    private MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenterImpl(this);

        initViews();

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //recuperacao de dados

                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                // converter valores strings para numeros

                Double valorAlcool = Double.parseDouble( textoPrecoAlcool );
                Double valorGasolina = Double.parseDouble( textoPrecoGasolina );

                //calculo = preco do alcool / preco gasolina ( se resultado > melhor usar GAS )

                presenter.estimateBetterChoice(valorAlcool, valorGasolina);

                //validacao

                presenter.validateFields(textoPrecoAlcool, textoPrecoGasolina);

                }
            });
    }

    private void initViews() {
        precoAlcool = findViewById(R.id.precoAlcoolId);
        precoGasolina = findViewById(R.id.precoGasolinaId);
        botaoVerificar = findViewById(R.id.botaoVerificarId);
        textoResultado = findViewById(R.id.textoResultadoId);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showResult(int stringId) {
        textoResultado.setText(stringId);
    }

    @Override
    public void onError(int stringId) {
        Toast.makeText(this, getString(R.string.type_alcohol), Toast.LENGTH_SHORT).show();

    }
}
