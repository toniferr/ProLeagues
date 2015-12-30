package es.uvigo.esei.dm1516.p28.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import es.uvigo.esei.dm1516.p28.Core.League;
import es.uvigo.esei.dm1516.p28.Core.SqlIO;
import es.uvigo.esei.dm1516.p28.R;

import java.util.List;

public class Main extends Activity {
    public static final String LOG_TAG = "Main";
    public final static int NEW_LEAGUE = 101;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );

        ListView lItems = (ListView) this.findViewById( R.id.lItems );
        ImageButton btAdd = (ImageButton) this.findViewById( R.id.btAdd );

        /***********listview de las ligas creadas************************************/
        lItems.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Main.this.irVistaLiga( position );
            }
        } );

        this.listItems = ( (App) this.getApplication() ).getDb().getAllItems();  /****base de datos********/
        /******adaptador*************/
        lItems.setAdapter( new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                this.listItems
        ) );
        this.registerForContextMenu( lItems );

        /************boton añadir una nueva liga***************************/
        btAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main.this.addNewLeague();
            }
        } );
    }

    /*****************************************************************************/



    /************menu contextual**********************************/
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        switch ( v.getId() ) {
            case R.id.lItems:
                super.onCreateContextMenu( menu, v, menuInfo );
                this.getMenuInflater().inflate( R.menu.menu_context, menu );
                break;
        }

        return;
    }

    @Override
    public boolean onContextItemSelected(MenuItem menuItem)
    {
        super.onContextItemSelected( menuItem );

        boolean toret = false;

        switch ( menuItem.getItemId() ) {
            case R.id.delete:
                toret = true;
                this.deleteLeague( ( (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo() ).position );
                break;
            case R.id.irLiga:
                toret = true;
                this.irVistaLiga( ( (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo() ).position );
                break;
        }

        return toret;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu( menu );

        this.getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    /*************menu principal********************************/
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        super.onOptionsItemSelected( menuItem );

        switch( menuItem.getItemId() ) {
            case R.id.creaLiga:
                Main.this.addNewLeague();
                break;
            case R.id.info:
                case R.id.about:
                    Intent about= new Intent(getApplicationContext(), About.class);
                    startActivity(about);
                    break;
                case R.id.developers:
                    Intent developers= new Intent(getApplicationContext(), Developers.class);
                    startActivity(developers);
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

    /*************añade funcionalidad de crear liga del menu principal y al boton*********************************/
    private void addNewLeague() {
        this.startActivityForResult( new Intent( this, InputLeague.class ), NEW_LEAGUE );
    }


    /**************añade funcionalidad de borrar liga del menu contextual******************************/
    private void deleteLeague(int pos)
    {
        ListView lItems = (ListView) this.findViewById( R.id.lItems );
        SqlIO db = ( (App) this.getApplication() ).getDb();

        db.remove( this.listItems.get( pos ) );
        this.listItems.remove( pos );
        ( (ArrayAdapter ) lItems.getAdapter() ).notifyDataSetChanged();
    }


    /************funcionalidad de ir a la vista principal de la liga*************************************/
    private void irVistaLiga(int pos)
    {
        String nameLeague = this.listItems.get( pos ).getName();
        Intent data = new Intent( this, PageLeague.class );

        data.putExtra( PageLeague.ETQ_NAME_LEAGUE, nameLeague );
        Log.v( LOG_TAG, String.format( " in pageLeague(): launching league calculator for: '%s'", nameLeague ) );
        this.startActivity( data );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        super.onActivityResult( requestCode, resultCode, intent );

        if ( resultCode == RESULT_OK ) {
            ListView lItems = (ListView) this.findViewById( R.id.lItems );

            if ( requestCode == NEW_LEAGUE ) {
                SqlIO db = ( (App) this.getApplication() ).getDb();

                League league = new League(
                                intent.getExtras().getString( InputLeague.ETQ_NAME ),
                                intent.getExtras().getInt(InputLeague.ETQ_TEAMS) );

                db.add( league );
                this.listItems.add( league );
                ( (ArrayAdapter) lItems.getAdapter() ).notifyDataSetChanged();
            }
        }

        return;
    }


    /*****************lista de hipotecas****************************/
    List<League> listItems;
}
