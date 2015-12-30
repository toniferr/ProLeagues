package es.uvigo.esei.dm1516.p28.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import es.uvigo.esei.dm1516.p28.Core.League;
import es.uvigo.esei.dm1516.p28.R;


public class PageLeague extends Activity {
    public static final String ETQ_NAME_LEAGUE = "name_league";

    private League mortgage;

    @Override
    public void onCreate(Bundle data) {
        super.onCreate( data );
        this.setContentView( R.layout.page_league );

        TextView leagueName = (TextView) this.findViewById( R.id.leagueName );
        this.mortgage = ( (App ) this.getApplication() ).getDb().getByName(
                                                this.getIntent().getExtras().getString( ETQ_NAME_LEAGUE ) );

        leagueName.setText( mortgage.getName() );
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

    /*metodo del menu principal que nos muestra un dialogo en el que podemos cancelar o salir de la aplicacion*/
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
