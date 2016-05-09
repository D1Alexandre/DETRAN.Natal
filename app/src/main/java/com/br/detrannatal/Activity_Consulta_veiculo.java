package com.br.detrannatal;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Activity_Consulta_veiculo extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtPlaca = (EditText) findViewById(R.id.edtPlaca);
        EditText edtRen = (EditText) findViewById(R.id.edtRen);
        Button   btnConsultar = (Button) findViewById(R.id.btnCons);


            edtPlaca.setOnKeyListener(new View.OnKeyListener() {
                EditText edtRen = (EditText) findViewById(R.id.edtRen);
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if(keyCode == KeyEvent.KEYCODE_ENTER){
                        edtRen.requestFocus();

                    }
                return false;
                }
            });

            edtRen.setOnKeyListener(new View.OnKeyListener() {
                Button   btnConsultar = (Button) findViewById(R.id.btnCons);
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if(keyCode == KeyEvent.KEYCODE_ENTER){
                        btnConsultar.requestFocus();

                    }

                    return false;
                }
            });

            if (Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }




        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edtPlaca = (EditText) findViewById(R.id.edtPlaca);
                EditText edtRen = (EditText) findViewById(R.id.edtRen);
                WebView wb = (WebView) findViewById(R.id.wb);



                if (edtPlaca.getText().toString().trim().isEmpty() || edtRen.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Preecha os Dados para Realizar a Pesquisa", Toast.LENGTH_LONG).show();
                } else {


                    try {

                        String placa = edtPlaca.getText().toString().toUpperCase();
                        String renavam = edtRen.getText().toString().toUpperCase();

                        List<NameValuePair> valores = new ArrayList<NameValuePair>(2);
                        valores.add(new BasicNameValuePair("placa", placa));
                        valores.add(new BasicNameValuePair("renavam", renavam));

                        HttpClient cli = new DefaultHttpClient();
                        HttpPost post = new HttpPost("http://www2.detran.rn.gov.br/servicos/consultaveiculo.asp");
                        post.setEntity(new UrlEncodedFormEntity(valores));
                        HttpResponse resposta = cli.execute(post);
                        HttpEntity ent = resposta.getEntity();


                        Intent intent = new Intent(Activity_Consulta_veiculo.this, Resultado.class);
                        Bundle ext = new Bundle();
                        ext.putString("resultado", EntityUtils.toString(ent));
                        intent.putExtras(ext);
                        startActivity(intent);


                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        });













    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
