package es.uvigo.esei.dm1516.p28.View;

/*
 * Clase que implementa la vista donde se introducen los datos para crear una liga
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
import android.widget.EditText;
import es.uvigo.esei.dm1516.p28.R;


public class InputLeague extends Activity {


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputleague);

        /***********edittext*****************/

        EditText etname = (EditText) findViewById(R.id.nameInsert);
        EditText etteams = (EditText) findViewById(R.id.teamsInsert);


        /********boton cancelar***********/
        Button btnCancel = (Button) findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /********boton crear liga***********/
        Button btnInsert = (Button) findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String name = etname.getText().toString().trim();
                //int teams = Integer.parseInt(etteams.getText().toString());

                finish();
            }
        });
    }

    /***********menu barra superior, con tres casos: opciones abre dos subitems, atras mata la actividad y salir********************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu( menu );
        this.getMenuInflater().inflate( R.menu.menu_inputleague, menu );
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch ( menuItem.getItemId() ) {
            case R.id.opciones:
                break;
                case R.id.consultLeague:
                    Intent consultleagues= new Intent(getApplicationContext(), ConsultLeagues.class);
                    startActivity(consultleagues);
                    break;
                case R.id.about:
                    Intent about= new Intent(getApplicationContext(), About.class);
                    startActivity(about);
                    break;
            case R.id.atras:
                finish();
                break;
            case R.id.salir:
                exit();
                break;
        }
        return true;
    }

    /*metodo del menu principal que nos muestra un dialogo en el que podemos cancelar o salir de la aplicación*/
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
