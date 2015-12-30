package es.uvigo.esei.dm1516.p28.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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


public class Developers extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developers);

        WebView wview = (WebView) findViewById(R.id.developersWebView);
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

            InputStream in = this.getAssets().open("developers.html");
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
            case R.id.salir:
                exit();
                break;
        }
        return true;
    }

    /*metodo del menu principal que nos muestra un dialogo en el que podemos cancelar o salir de la aplicaci�n*/
    public void exit(){
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Salir de la aplicacion" );
        builder.setPositiveButton( "Cancelar", null);
        builder.setNegativeButton( "Salir", new DialogInterface.OnClickListener() {
            @Override
            public void  onClick(DialogInterface dlg, int i) {
                System.exit( 0 );
            }
        });
        builder.create().show();
    }

}