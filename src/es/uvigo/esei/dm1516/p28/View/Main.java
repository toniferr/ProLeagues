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
import es.uvigo.esei.dm1516.p28.Core.Match;
import es.uvigo.esei.dm1516.p28.Core.SqlIO;
import es.uvigo.esei.dm1516.p28.Core.Team;
import es.uvigo.esei.dm1516.p28.R;

import java.util.ArrayList;
import java.util.List;

public class Main extends Activity {
    public static final String LOG_TAG = "Main";
    public final static int NEW_LEAGUE = 101;


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
        builder.setNegativeButton( "Cancelar", null);
        builder.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
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
        Log.v( LOG_TAG, String.format( " in pageLeague(): launching league for: '%s'", nameLeague ) );
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

                League league = new League( intent.getExtras().getString( InputLeague.ETQ_NAME ) );

                db.add( league );

                Team team1 = new Team (intent.getExtras().getString(InputLeague.ETQ_T1), intent.getExtras().getString(InputLeague.ETQ_U1), 0, 0, intent.getExtras().getString(InputLeague.ETQ_NAME) );
                Team team2 = new Team (intent.getExtras().getString(InputLeague.ETQ_T2), intent.getExtras().getString(InputLeague.ETQ_U2), 0, 0, intent.getExtras().getString(InputLeague.ETQ_NAME) );
                Team team3 = new Team (intent.getExtras().getString(InputLeague.ETQ_T3), intent.getExtras().getString(InputLeague.ETQ_U3), 0, 0, intent.getExtras().getString(InputLeague.ETQ_NAME) );
                Team team4 = new Team (intent.getExtras().getString(InputLeague.ETQ_T4), intent.getExtras().getString(InputLeague.ETQ_U4), 0, 0, intent.getExtras().getString(InputLeague.ETQ_NAME) );
                Team team5 = new Team (intent.getExtras().getString(InputLeague.ETQ_T5), intent.getExtras().getString(InputLeague.ETQ_U5), 0, 0, intent.getExtras().getString(InputLeague.ETQ_NAME) );
                Team team6 = new Team (intent.getExtras().getString(InputLeague.ETQ_T6), intent.getExtras().getString(InputLeague.ETQ_U6), 0, 0, intent.getExtras().getString(InputLeague.ETQ_NAME) );


               if (!intent.getExtras().getString(InputLeague.ETQ_T1).isEmpty()) {
                   db.addTeam(team1);
               }
               if (!intent.getExtras().getString(InputLeague.ETQ_T2).isEmpty()) {
                    db.addTeam(team2);
               }
               if (!intent.getExtras().getString(InputLeague.ETQ_T3).isEmpty()) {
                    db.addTeam(team3);
               }
               if (!intent.getExtras().getString(InputLeague.ETQ_T4).isEmpty()) {
                    db.addTeam(team4);
               }
               if (!intent.getExtras().getString(InputLeague.ETQ_T5).isEmpty()) {
                    db.addTeam(team5);
               }
               if (!intent.getExtras().getString(InputLeague.ETQ_T6).isEmpty()) {
                    db.addTeam(team6);
               }

                /***************crear emparejamiento***************/
                int numEquipos = db.getCountTeams(intent.getExtras().getString(InputLeague.ETQ_NAME));
                ArrayList<String> equipos = db.getNameTeams(intent.getExtras().getString(InputLeague.ETQ_NAME));

                ArrayList<String> calendario = crearEmparejamientos(numEquipos, equipos);


                int i = 0;
                int j = 0;
                int totalJP = numEquipos;

                boolean impar = (totalJP%2 != 0);
                if (impar){ --totalJP; }

                String localteam="";
                String visitteam="";
                int jornada = 0;
                for (String partido: calendario){
                    if ((totalJP*j) == i){
                        jornada = j+1;
                        j++;
                    }
                    if ((i%2) == 0){
                        localteam = partido;
                    }else{
                        visitteam = partido;
                        Match match = new Match(localteam, visitteam, jornada, 0, 0 );
                        db.addMatch(match);
                    }

                    i++;
                }

                /*******jornada1****/
                /*Match match1j1 = new Match();
                Match match2j1 = new Match();
                Match match3j1 = new Match();*/
                /*******jornada2****/
                /*Match match1j2 = new Match();
                Match match2j2 = new Match();
                Match match3j2 = new Match();*/
                /*******jornada3****/
                /*Match match1j3 = new Match();
                Match match2j3 = new Match();
                Match match3j3 = new Match();*/
                /*******jornada4****/
                /*Match match1j4 = new Match();
                Match match2j4 = new Match();
                Match match3j4 = new Match();*/
                /*******jornada5****/
                /*Match match1j5 = new Match();
                Match match2j5 = new Match();
                Match match3j5 = new Match();*/
                /*******jornada6****/
                /*Match match1j6 = new Match();
                Match match2j6 = new Match();
                Match match3j6 = new Match();*/
                /*******jornada7****/
                /*Match match1j7 = new Match();
                Match match2j7 = new Match();
                Match match3j7 = new Match();*/
                /*******jornada8****/
                /*Match match1j8 = new Match();
                Match match2j8 = new Match();
                Match match3j8 = new Match();*/
                /*******jornada9****/
                /*Match match1j9 = new Match();
                Match match2j9 = new Match();
                Match match3j9 = new Match();*/
                /*******jornada10****/
                /*Match match1j10 = new Match();
                Match match2j10 = new Match();
                Match match3j10 = new Match();*/

                this.listItems.add( league );
                ( (ArrayAdapter) lItems.getAdapter() ).notifyDataSetChanged();
            }
        }
        return;
    }



    public ArrayList<String> crearEmparejamientos (int tope, ArrayList<String> clubes){

                //int tope numero de clubes
                //ArrayList <String> clubes array con los nombres de todos los clubes de la liga

                ArrayList <String> toret = new ArrayList<String>();
                boolean impar =(tope%2!=0);
                if(impar){
                    ++tope;
                }

                int totalP=(tope*(tope-1))/2;//total de partidos de una ronda

                String [] local=new String [totalP];
                String [] visita=new String [totalP];

                int modIF=(tope/2);//para hacer mod cada inicio de fecha
                int indiceInverso=tope-2;
                for(int i=0;i<totalP;i++){
                    if (i%modIF==0){//seria el partido inicial de cada fecha
                        //si es impar el numero de clubes la primera fecha se borra poniendo null
                        if (impar){
                            local[i]=null;
                            visita[i]=null;
                        }
                        else{
                            //se pone uno local otro visita al ultimo equipo
                            if(i%2==0){
                                local[i]=clubes.get(i%(tope-1));
                                visita[i]=clubes.get(tope-1);
                            }
                            else{
                                local[i]=clubes.get(tope-1);
                                visita[i]=clubes.get(i%(tope-1));
                            }
                        }
                    }
                    else{
                        local[i]=clubes.get(i%(tope-1));
                        visita[i]=clubes.get(indiceInverso);
                        --indiceInverso;
                        if (indiceInverso<0){
                            indiceInverso=tope-2;
                        }
                    }
                }

                //Ida

                for(int i=0;i<totalP;i++){
                    if(local[i]!=null){
                        toret.add(local[i]);
                        toret.add(visita[i]);
                    }
                }
                //Vuelta

                for(int i=0;i<totalP;i++){
                    if(local[i]!=null){
                        toret.add(visita[i]);
                        toret.add(local[i]);
                    }
                }
                return toret;

    }


    /*****************lista de hipotecas****************************/
    List<League> listItems;
}
