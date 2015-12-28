package es.uvigo.esei.dm1516.p28.View;

/*
 * Esta es la clase principal que nos muestra la pantalla tan pronto inicia la aplicación
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import es.uvigo.esei.dm1516.p28.R;

public class Main extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /********boton crear liga***********/
        Button btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addleague= new Intent(getApplicationContext(), InputLeague.class);
                startActivity(addleague);
            }
        });

        /********boton consultar ligas***********/
        Button btn2 = (Button) findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consultleagues= new Intent(getApplicationContext(), ConsultLeagues.class);
                startActivity(consultleagues);
            }
        });

        /********boton about***********/
        Button btn3 = (Button) findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about= new Intent(getApplicationContext(), About.class);
                startActivity(about);
            }
        });
    }

    /***********menu barra superior********************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu( menu );
        this.getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch ( menuItem.getItemId() ) {
            case R.id.salir:
                exit();
        }
        return true;
    }

    /*metodo del menu principal que nos muestra un dialogo en el que podemos cancelar o salir de la aplicación*/
    public void exit(){
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle("Salir de la aplicacion");
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
