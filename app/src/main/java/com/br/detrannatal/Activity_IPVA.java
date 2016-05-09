package com.br.detrannatal;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Activity_IPVA extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ipva);

        AdView ad = (AdView) findViewById(R.id.AdView);
        AdRequest request = new AdRequest.Builder().build();
        ad.loadAd(request);

        WebView wbIPVA = (WebView) findViewById(R.id.webView);

        String html = "<table style=\"font-size:8pt\" cellpadding=\"0\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th rowspan=\"2\">PLACA (final)</th>\n" +
                "\t\t\t<th>DETRAN</th>\n" +
                "\t\t\t<th colspan=\"4\">DPVAT - SEGURADORA LIDER</th>\n" +
                "\t\t\t<th colspan=\"4\">IPVA - SECRETARIA DE ESTADO DA TRIBUTAÇÃO</th>\n" +
                "\t\t\t<th rowspan=\"2\">Validade CRLV 2015</th>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th>Licenc.</th>\n" +
                "\t\t\t<th>Cota única</th>\n" +
                "\t\t\t<th>1ª Par.</th>\n" +
                "\t\t\t<th>2ª Par.</th>\n" +
                "\t\t\t<th>3ª Par.</th>\n" +
                "\t\t\t<th>Cota única (5% de desc.)</th>\n" +
                "\t\t\t<th>1ª Cota</th>\n" +
                "\t\t\t<th>2ª C<strong>ota</strong></th>\n" +
                "\t\t\t<th>3ª <strong>Cota</strong></th>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>1</td>\n" +
                "\t\t\t<td>16/02</td>\n" +
                "\t\t\t<td>16/03</td>\n" +
                "\t\t\t<td>16/03</td>\n" +
                "\t\t\t<td>13/04</td>\n" +
                "\t\t\t<td>16/05</td>\n" +
                "\t\t\t<td>16/03</td>\n" +
                "\t\t\t<td>16/03</td>\n" +
                "\t\t\t<td>13/04</td>\n" +
                "\t\t\t<td>16/05</td>\n" +
                "\t\t\t<td>Até setembro</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>2</td>\n" +
                "\t\t\t<td>17/02</td>\n" +
                "\t\t\t<td>17/03</td>\n" +
                "\t\t\t<td>17/03</td>\n" +
                "\t\t\t<td>14/04</td>\n" +
                "\t\t\t<td>17/05</td>\n" +
                "\t\t\t<td>17/03</td>\n" +
                "\t\t\t<td>17/03</td>\n" +
                "\t\t\t<td>14/04</td>\n" +
                "\t\t\t<td>17/05</td>\n" +
                "\t\t\t<td>Até setembro</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>3</td>\n" +
                "\t\t\t<td>08/03</td>\n" +
                "\t\t\t<td>11/04</td>\n" +
                "\t\t\t<td>11/04</td>\n" +
                "\t\t\t<td>11/05</td>\n" +
                "\t\t\t<td>16/06</td>\n" +
                "\t\t\t<td>11/04</td>\n" +
                "\t\t\t<td>11/04</td>\n" +
                "\t\t\t<td>11/05</td>\n" +
                "\t\t\t<td>16/06</td>\n" +
                "\t\t\t<td>Até outubro</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>4</td>\n" +
                "\t\t\t<td>09/03</td>\n" +
                "\t\t\t<td>12/04</td>\n" +
                "\t\t\t<td>12/04</td>\n" +
                "\t\t\t<td>12/05</td>\n" +
                "\t\t\t<td>17/06</td>\n" +
                "\t\t\t<td>12/04</td>\n" +
                "\t\t\t<td>12/04</td>\n" +
                "\t\t\t<td>12/05</td>\n" +
                "\t\t\t<td>17/06</td>\n" +
                "\t\t\t<td>Até outubro</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>5</td>\n" +
                "\t\t\t<td>11/04</td>\n" +
                "\t\t\t<td>05/05</td>\n" +
                "\t\t\t<td>05/05</td>\n" +
                "\t\t\t<td>13/06</td>\n" +
                "\t\t\t<td>12/07</td>\n" +
                "\t\t\t<td>05/05</td>\n" +
                "\t\t\t<td>05/05</td>\n" +
                "\t\t\t<td>13/06</td>\n" +
                "\t\t\t<td>12/07</td>\n" +
                "\t\t\t<td>Até outubro</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>6</td>\n" +
                "\t\t\t<td>12/04</td>\n" +
                "\t\t\t<td>06/05</td>\n" +
                "\t\t\t<td>06/05</td>\n" +
                "\t\t\t<td>14/06</td>\n" +
                "\t\t\t<td>13/07</td>\n" +
                "\t\t\t<td>06/05</td>\n" +
                "\t\t\t<td>06/05</td>\n" +
                "\t\t\t<td>14/06</td>\n" +
                "\t\t\t<td>13/07</td>\n" +
                "\t\t\t<td>Até novembro</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>7</td>\n" +
                "\t\t\t<td>03/05</td>\n" +
                "\t\t\t<td>08/06</td>\n" +
                "\t\t\t<td>08/06</td>\n" +
                "\t\t\t<td>07/07</td>\n" +
                "\t\t\t<td>08/08</td>\n" +
                "\t\t\t<td>08/06</td>\n" +
                "\t\t\t<td>08/06</td>\n" +
                "\t\t\t<td>07/07</td>\n" +
                "\t\t\t<td>08/08</td>\n" +
                "\t\t\t<td>Até novembro</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>8</td>\n" +
                "\t\t\t<td>04/05</td>\n" +
                "\t\t\t<td>09/06</td>\n" +
                "\t\t\t<td>09/06</td>\n" +
                "\t\t\t<td>08/07</td>\n" +
                "\t\t\t<td>09/08</td>\n" +
                "\t\t\t<td>09/06</td>\n" +
                "\t\t\t<td>09/06</td>\n" +
                "\t\t\t<td>08/07</td>\n" +
                "\t\t\t<td>09/08</td>\n" +
                "\t\t\t<td>Até novembro</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>9</td>\n" +
                "\t\t\t<td>06/06</td>\n" +
                "\t\t\t<td>06/07</td>\n" +
                "\t\t\t<td>06/07</td>\n" +
                "\t\t\t<td>12/08</td>\n" +
                "\t\t\t<td>12/09</td>\n" +
                "\t\t\t<td>06/07</td>\n" +
                "\t\t\t<td>06/07</td>\n" +
                "\t\t\t<td>12/08</td>\n" +
                "\t\t\t<td>12/09</td>\n" +
                "\t\t\t<td>Até dezembro</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>0</td>\n" +
                "\t\t\t<td>04/07</td>\n" +
                "\t\t\t<td>11/08</td>\n" +
                "\t\t\t<td>11/08</td>\n" +
                "\t\t\t<td>13/09</td>\n" +
                "\t\t\t<td>11/10</td>\n" +
                "\t\t\t<td>11/08</td>\n" +
                "\t\t\t<td>11/08</td>\n" +
                "\t\t\t<td>13/09</td>\n" +
                "\t\t\t<td>11/10</td>\n" +
                "\t\t\t<td>Até dezembro</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>";



        wbIPVA.loadData(html, "text/html;charset=utf-8", "UTF-8");



    }




}
