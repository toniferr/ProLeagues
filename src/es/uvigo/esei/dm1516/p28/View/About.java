package es.uvigo.esei.dm1516.p28.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import es.uvigo.esei.dm1516.p28.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class About extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        WebView wview = (WebView) findViewById(R.id.aboutWebView);
        configureWebView(wview, 10);
    }

    private void configureWebView (WebView wview, int defaultFontSize){
        WebSettings wviewSettings = wview.getSettings();
        wviewSettings.setBuiltInZoomControls(true);
        wviewSettings.setDefaultFixedFontSize(defaultFontSize);
        //wviewSettings.setJavaScriptEnabled(true);


        StringBuilder builder = new StringBuilder();
        try {
            String line;

            InputStream in = this.getAssets().open("about.html");
            BufferedReader inf = new BufferedReader( new InputStreamReader(in));

            while ( (line=inf.readLine()) != null) {
                builder.append(line);
            }
        }catch (IOException e){
                builder.append("<html><head>Error</head><body><big>ERROR internal: loading asset</big></body></html>");
        }
        wview.loadData(builder.toString(), "text/html", "utf-8");
    }

    /***********menu barra superior con opciones de volver atras y salir********************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu( menu );
        this.getMenuInflater().inflate( R.menu.menu_info, menu );
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch ( menuItem.getItemId() ) {
            case R.id.atras:
                finish();
                break;
        }
        return true;
    }

}