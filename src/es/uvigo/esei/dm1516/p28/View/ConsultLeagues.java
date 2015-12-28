package es.uvigo.esei.dm1516.p28.View;

/*
 * Clase que implementa un array list de todas las ligas que fueron creadas
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import es.uvigo.esei.dm1516.p28.Core.League;
import es.uvigo.esei.dm1516.p28.Core.SqlIO;
import es.uvigo.esei.dm1516.p28.R;

import java.util.List;

public class ConsultLeagues extends Activity {

    public final static int NEW_LEAGUE = 100;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultleagues);

        /*ListView listLeagues = (ListView) findViewById(R.id.listLeagues);

        listLeagues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/

        /*****************array de las ligas************************************/
        /*this.listItems = ((App) this.getApplication()).getDb().getAllItems();
        listLeagues.setAdapter(new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                this.listItems
        ));
        this.registerForContextMenu(listLeagues);*/
    }

    /***********menu barra superior, con tres casos: opciones abre dos subitems, atras mata la actividad y salir********************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu( menu );
        this.getMenuInflater().inflate( R.menu.menu_consultleague, menu );
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch ( menuItem.getItemId() ) {
            case R.id.opciones:
                break;
            case R.id.inputleague:
                Intent inputLeague= new Intent(getApplicationContext(), InputLeague.class);
                startActivity(inputLeague);
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



    /*********************menu contextual*****************************************/
    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        switch (v.getId()){
            case R.id.listLeagues:
                super.onCreateContextMenu(menu,v,menuInfo);
                this.getMenuInflater().inflate(R.menu.menu_context, menu);
                break;
        }
        return;
    }

    @Override
    public boolean onContextItemSelected( MenuItem menuItem){
        super.onContextItemSelected(menuItem);
        boolean toret=false;
        switch (menuItem.getItemId()){
            case R.id.delete:
                toret = true;
                this.deleteLeague(((AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
                break;
        }
        return toret;
    }*/

    /*********en el menu contextual, si pulsas delte*****************************/
    /*public void deleteLeague(int pos){
        //ListView listView = (ListView)this.findViewById(R.id.listLeagues);
        //SqlIO db= ((App)this.getApplication()).getDb();

        //db.remove(this.listItems.get(pos));
        //this.listView.remove(pos);
        //((ArrayAdapter)listItems.getAdapter()).notifyDataSetChanged();
    }*/

    /***variable array ligas***/
    //List<League> listItems;

}