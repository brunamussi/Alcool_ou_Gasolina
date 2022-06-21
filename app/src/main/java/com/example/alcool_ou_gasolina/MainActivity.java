package com.example.alcool_ou_gasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText editAlcool, editGasolina;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool = findViewById(R.id.editAlcool);
        editGasolina = findViewById(R.id.editGasolina);
        textResult = findViewById(R.id.textResult);

    }

    public void calculate (View view){

        // recuperar valores digitados:
        String precoAlcool = editAlcool.getText().toString();
        String precoGasolina = editGasolina.getText().toString();

        // validar os campos:
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if (camposValidados){
            Double conversaoAlcool = Double.parseDouble(precoAlcool);
            Double conversaoGasolina = Double.parseDouble(precoGasolina);

            // calculo de menor preço:
            Double resultado = conversaoAlcool / conversaoGasolina;
            if(resultado >=0.7){
                textResult.setText("Melhor utilizar Gasolina");
            }else {
                textResult.setText("Melhor utilizar Alcool");
            }
        }else {
            textResult.setText("Preencha todos os campos!");
        }
    }
    public Boolean validarCampos (String pAlcool, String pGasolina){

        Boolean camposValidados = true;
;
        if  ( pAlcool == null ){
            camposValidados = false;
        }else if(pGasolina == null){
            camposValidados = false;
        }
        return camposValidados;
    }
}
