package es.uvigo.esei.dm1516.p28.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import es.uvigo.esei.dm1516.p28.Core.League;
import es.uvigo.esei.dm1516.p28.Core.Team;
import es.uvigo.esei.dm1516.p28.R;

import java.util.List;


public class PageLeague extends Activity {
    public static final String ETQ_NAME_LEAGUE = "name_league";
    public static final String LOG_TAG = "Main";

    private League league;

    @Override
    public void onCreate(Bundle data) {
        super.onCreate( data );
        this.setContentView( R.layout.page_league );



        TextView leagueName = (TextView) this.findViewById( R.id.leagueName );
        this.league = ( (App ) this.getApplication() ).getDb().getByName(
                                                this.getIntent().getExtras().getString( ETQ_NAME_LEAGUE ) );

        leagueName.setText(leagueName.getText() + " " + league.getName() );

        ListView lItems = (ListView) this.findViewById( R.id.listTeams );

        /***********listview de las ligas creadas************************************/
        lItems.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        } );

        this.listTeams = ( (App) this.getApplication() ).getDb().getAllTeams(league.getName());  /****base de datos********/
        /******adaptador*************/
        lItems.setAdapter( new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                this.listTeams
        ) );
        this.registerForContextMenu( lItems );
    }

    /***********menu barra superior con opciones de volver atras y salir********************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu( menu );
        this.getMenuInflater().inflate( R.menu.menu_pageleague, menu );
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch ( menuItem.getItemId() ) {
            case R.id.Actualizar:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                break;
            case R.id.Calendario:
                String nameLeague = league.getName() ;
                Intent data = new Intent( this, Calendario.class );
                data.putExtra( Calendario.ETQ_NAME_LEAGUE, nameLeague );
                Log.v(LOG_TAG, String.format(" in pageLeague(): launching league for: '%s'", nameLeague));
                this.startActivity(data);
                break;
            case R.id.Resultados:
                String nameLeague2 = league.getName() ;
                Intent data2 = new Intent( this, Resultados.class );
                data2.putExtra( Resultados.ETQ_NAME_LEAGUE, nameLeague2 );
                Log.v(LOG_TAG, String.format(" in pageLeague(): launching league for: '%s'", nameLeague2));
                this.startActivity(data2);
                break;
            case R.id.atras:
                finish();
                break;
        }
        return true;
    }

    /*****************lista de equipos****************************/
    List<Team> listTeams;


}
