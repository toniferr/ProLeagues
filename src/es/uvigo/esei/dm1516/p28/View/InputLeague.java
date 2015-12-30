package es.uvigo.esei.dm1516.p28.View;

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
    public static final String ETQ_NAME = "name";
    public static final String ETQ_TEAMS = "teams";

    @Override
    public void onCreate(Bundle data) {
        super.onCreate(data);
        this.setContentView( R.layout.input_league );

        Button btSave = (Button) this.findViewById( R.id.btnInsert );
        Button btCancel = (Button) this.findViewById( R.id.btnCancel );
        final EditText nameleague = (EditText) this.findViewById( R.id.nameInsert );
        final EditText teamsleague = (EditText) this.findViewById( R.id.teamsInsert );

        /************boton cancelarr******************/
        btCancel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputLeague.this.setResult( RESULT_CANCELED );
                InputLeague.this.finish();
            }
        } );

        /************boton insertar**********************/
        btSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                String leaguename = nameleague.getText().toString().trim();  /**nombre de la liga**/
                int leagueteams = Integer.parseInt(teamsleague.getText().toString());  /**numero de equipos**/

                if ( !leaguename.isEmpty() || leagueteams > 0.0 )
                {
                    data.putExtra( ETQ_NAME, leaguename );
                    data.putExtra( ETQ_TEAMS, leagueteams );
                    InputLeague.this.setResult( RESULT_OK, data );
                    InputLeague.this.finish();
                } else {
                    InputLeague.this.setResult( RESULT_CANCELED );
                    InputLeague.this.finish();
                }
            }
        } );
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
