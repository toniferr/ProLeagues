package es.uvigo.esei.dm1516.p28.View;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import es.uvigo.esei.dm1516.p28.R;

public class Resultados extends Activity {

    public static final String ETQ_NAME_LEAGUE = "name_league";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        this.setContentView( R.layout.page_resultados );



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
