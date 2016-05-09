package com.br.detrannatal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraCharacteristics;
import android.renderscript.Element;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Resultado extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        AdView ad = (AdView) findViewById(R.id.AdView);
        AdRequest request = new AdRequest.Builder().build();
        ad.loadAd(request);


        final WebView wb = (WebView) findViewById(R.id.Wb);;



        Intent intent = getIntent();
        Bundle ext = intent.getExtras();

        String ret = ext.getString("resultado");

        wb.getSettings().setJavaScriptEnabled(true);


        Document doc = Jsoup.parse(ret);
        String ele = doc.getAllElements().toString();

        Log.i("TAMANHO", String.valueOf(ele.length()));

        if(ele.toString().length() == 31516){
            Intent inte = new Intent(Resultado.this,Activity_Consulta_veiculo.class);
            startActivity(inte);
            Toast.makeText(getApplicationContext(), "O VEICULO INFORMADO NÃO É CADASTRADA NO DETRAN/RN OU AS INFORMAÇÕES DE PLACA E RENAVAM ESTÃO ERRADAS", Toast.LENGTH_SHORT).show();
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        if(ele.toString().length() == 28622){
            Intent inte = new Intent(Resultado.this,Activity_Consulta_Pessoa.class);
            startActivity(inte);
            Toast.makeText(getApplicationContext(), "A PESSOA INFORMADA NÃO É CADASTRADA NO DETRAN/RN", Toast.LENGTH_SHORT).show();
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

       if(ele.toString().length() == 31212){
            Intent inte = new Intent(Resultado.this,Activity_Consulta_Pessoa.class);
            startActivity(inte);
            Toast.makeText(getApplicationContext(), "INFORME O N° DA CNH", Toast.LENGTH_SHORT).show();
           try {
               finalize();
           } catch (Throwable throwable) {
               throwable.printStackTrace();
           }
       }

        wb.loadData(ret, "text/html;charset=utf-8", "UTF-8");
        wb.setWebViewClient(new WebViewClient() {

            ProgressDialog pg = new ProgressDialog(Resultado.this);


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pg.setMessage("CARREGANDO DADOS AGUARDE ....");
                pg.show();


            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pg.dismiss();

            }


        });





    }
    



}