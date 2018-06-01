package com.example.filip.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        precoAlcool=findViewById(R.id.precoAlcoolId);
        precoGasolina=findViewById(R.id.precoGasolinaId);
        botaoVerificar=findViewById(R.id.botaoVerificarId);
        textoResultado=findViewById(R.id.textoResultadoId);

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

                double resultado = valorAlcool / valorGasolina;

                if ( resultado >= 0.7 ){
                    //Gasolina
                    textoResultado.setText("E melhor utilizar GASOLINA");
                }else {
                    //Alcool
                    textoResultado.setText("E melhor usar ALCOOL");
                }

                    //validacao

                    if (textoPrecoAlcool == null || precoAlcool.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "digite o valor do Alcool", Toast.LENGTH_SHORT).show();
                    }
                    if (textoPrecoGasolina == null || precoGasolina.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "digite o valor do Gasolina", Toast.LENGTH_SHORT).show();
                    }

                }
            });
    }
}
