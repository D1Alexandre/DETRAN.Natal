package com.br.detrannatal;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class Activity_Inicial extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        ImageView imgVeiculo = (ImageView) findViewById(R.id.ImgVeiculo);
        ImageView imgCnh = (ImageView) findViewById(R.id.imagCnh);

        imgVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ConsVei = new Intent(Activity_Inicial.this,Activity_Consulta_veiculo.class);
                startActivity(ConsVei);
            }
        });

        imgCnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ConsP = new Intent(Activity_Inicial.this,Activity_Consulta_Pessoa.class);
                startActivity(ConsP);
            }
        });

    }
}


