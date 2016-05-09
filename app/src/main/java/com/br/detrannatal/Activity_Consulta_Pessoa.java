package com.br.detrannatal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.renderscript.Element;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Activity_Consulta_Pessoa extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__consulta__pessoa);
        EditText edtCPF = (EditText) findViewById(R.id.edtCPF);
        EditText edtCNH = (EditText) findViewById(R.id.edtCNH);
        TextView txt = (TextView) findViewById(R.id.textView2);
        Button BtnConsultar = (Button) findViewById(R.id.BtnConsu);
        edtCPF.requestFocus();

        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        edtCPF.setOnKeyListener(new View.OnKeyListener() {
            EditText edtCNH = (EditText) findViewById(R.id.edtCNH);
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    edtCNH.requestFocus();
                }
                return false;
            }
        });
        edtCNH.setOnKeyListener(new View.OnKeyListener() {
            Button BtnConsultar = (Button) findViewById(R.id.BtnConsu);
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    BtnConsultar.requestFocus();
                }

                return false;
            }
        });

        BtnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtCPF = (EditText) findViewById(R.id.edtCPF);
                EditText edtCNH = (EditText) findViewById(R.id.edtCNH);

                if (edtCPF.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "INFORME O CPF PARA REALIZAR A PESQUISA", Toast.LENGTH_LONG).show();
                } else {


                    try {

                        WebView wb = (WebView) findViewById(R.id.webView);
                        String cpf = edtCPF.getText().toString();
                        String cnh = edtCNH.getText().toString();

                            List<NameValuePair> valor = new ArrayList<NameValuePair>(2);
                            valor.add(new BasicNameValuePair("cpfcnpj", cpf));
                            valor.add(new BasicNameValuePair("RegCNH", cnh));

                            HttpClient clic = new DefaultHttpClient();
                            HttpPost postc = new HttpPost("http://www2.detran.rn.gov.br/servicos/consultapessoa.asp");
                            postc.setEntity(new UrlEncodedFormEntity(valor));
                            HttpResponse resp = clic.execute(postc);
                            HttpEntity enti = resp.getEntity();
                            Intent intent = new Intent(Activity_Consulta_Pessoa.this, Resultado.class);
                            Bundle ext = new Bundle();
                            ext.putString("resultado", EntityUtils.toString(enti));
                            intent.putExtras(ext);
                            startActivity(intent);

                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

    }

}
