package es.uvigo.esei.dm1516.p28.View;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import es.uvigo.esei.dm1516.p28.Core.Match;
import es.uvigo.esei.dm1516.p28.Core.SqlIO;
import es.uvigo.esei.dm1516.p28.R;

import java.util.ArrayList;


public class Calendario extends Activity {
    public static final String ETQ_NAME_LEAGUE = "name_league";
    public static final String LOG_TAG = "Main";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        this.setContentView( R.layout.page_calendario );

        String nameLeague = this.getIntent().getExtras().getString( ETQ_NAME_LEAGUE );
        SqlIO db = ( (App) this.getApplication() ).getDb();

        ArrayList<Match> matchDay1 = db.getPartidos(nameLeague, 1);




        /*************botones, textviews y TextView de jornada 1****************/
        TextView local1j1 = (TextView) this.findViewById( R.id.local1j1 );
        TextView visitante1j1 = (TextView) this.findViewById( R.id.visit1j1 );
        TextView local2j1 = (TextView) this.findViewById( R.id.local2j1 );
        TextView visitante2j1 = (TextView) this.findViewById( R.id.visit2j1 );
        TextView local3j1 = (TextView) this.findViewById( R.id.local3j1 );
        TextView visitante3j1 = (TextView) this.findViewById( R.id.visit3j1 );

        int i=0;
        for (Match partido: matchDay1) {
            if (i==0) {
                local1j1.setText(partido.getLocalTeam());
                visitante1j1.setText(partido.getVisitTeam());
            }
            if (i==1) {
                local2j1.setText(partido.getLocalTeam());
                visitante2j1.setText(partido.getVisitTeam());
            }
            if (i==2) {
                local3j1.setText(partido.getLocalTeam());
                visitante3j1.setText(partido.getVisitTeam());
            }
            i += 1;
        }


        ArrayList<Match> matchDay2 = db.getPartidos(nameLeague, 2);
        /*************botones, textviews y TextView de jornada 1****************/
        TextView local1j2 = (TextView) this.findViewById( R.id.local1j2 );
        TextView visitante1j2 = (TextView) this.findViewById( R.id.visit1j2 );
        TextView local2j2 = (TextView) this.findViewById( R.id.local2j2 );
        TextView visitante2j2 = (TextView) this.findViewById( R.id.visit2j2 );
        TextView local3j2 = (TextView) this.findViewById( R.id.local3j2 );
        TextView visitante3j2 = (TextView) this.findViewById( R.id.visit3j2 );

        i=0;
        for (Match partido: matchDay2) {
            if (i==0) {
                local1j2.setText(partido.getLocalTeam());
                visitante1j2.setText(partido.getVisitTeam());
            }
            if (i==1) {
                local2j2.setText(partido.getLocalTeam());
                visitante2j2.setText(partido.getVisitTeam());
            }
            if (i==2) {
                local3j2.setText(partido.getLocalTeam());
                visitante3j2.setText(partido.getVisitTeam());
            }
            i += 1;
        }


        ArrayList<Match> matchDay3 = db.getPartidos(nameLeague, 3);
        /*************botones, textviews y TextView de jornada 1****************/
        TextView local1j3 = (TextView) this.findViewById( R.id.local1j3 );
        TextView visitante1j3 = (TextView) this.findViewById( R.id.visit1j3 );
        TextView local2j3 = (TextView) this.findViewById( R.id.local2j3 );
        TextView visitante2j3 = (TextView) this.findViewById( R.id.visit2j3 );
        TextView local3j3 = (TextView) this.findViewById( R.id.local3j3 );
        TextView visitante3j3 = (TextView) this.findViewById( R.id.visit3j3 );

        i=0;
        for (Match partido: matchDay3) {
            if (i==0) {
                local1j3.setText(partido.getLocalTeam());
                visitante1j3.setText(partido.getVisitTeam());
            }
            if (i==1) {
                local2j3.setText(partido.getLocalTeam());
                visitante2j3.setText(partido.getVisitTeam());
            }
            if (i==2) {
                local3j3.setText(partido.getLocalTeam());
                visitante3j3.setText(partido.getVisitTeam());
            }
            i += 1;
        }



        ArrayList<Match> matchDay4 = db.getPartidos(nameLeague, 4);
        /*************botones, textviews y TextView de jornada 1****************/
        TextView local1j4 = (TextView) this.findViewById( R.id.local1j4 );
        TextView visitante1j4 = (TextView) this.findViewById( R.id.visit1j4 );
        TextView local2j4 = (TextView) this.findViewById( R.id.local2j4 );
        TextView visitante2j4 = (TextView) this.findViewById( R.id.visit2j4 );
        TextView local3j4 = (TextView) this.findViewById( R.id.local3j4 );
        TextView visitante3j4 = (TextView) this.findViewById( R.id.visit3j4 );

        i=0;
        for (Match partido: matchDay4) {
            if (i==0) {
                local1j4.setText(partido.getLocalTeam());
                visitante1j4.setText(partido.getVisitTeam());
            }
            if (i==1) {
                local2j4.setText(partido.getLocalTeam());
                visitante2j4.setText(partido.getVisitTeam());
            }
            if (i==2) {
                local3j4.setText(partido.getLocalTeam());
                visitante3j4.setText(partido.getVisitTeam());
            }
            i += 1;
        }


        ArrayList<Match> matchDay5 = db.getPartidos(nameLeague, 5);
        /*************botones, textviews y TextView de jornada 1****************/
        TextView local1j5 = (TextView) this.findViewById( R.id.local1j5 );
        TextView visitante1j5 = (TextView) this.findViewById( R.id.visit1j5 );
        TextView local2j5 = (TextView) this.findViewById( R.id.local2j5 );
        TextView visitante2j5 = (TextView) this.findViewById( R.id.visit2j5 );
        TextView local3j5 = (TextView) this.findViewById( R.id.local3j5 );
        TextView visitante3j5 = (TextView) this.findViewById( R.id.visit3j5 );

        i=0;
        for (Match partido: matchDay5) {
            if (i==0) {
                local1j5.setText(partido.getLocalTeam());
                visitante1j5.setText(partido.getVisitTeam());
            }
            if (i==1) {
                local2j5.setText(partido.getLocalTeam());
                visitante2j5.setText(partido.getVisitTeam());
            }
            if (i==2) {
                local3j5.setText(partido.getLocalTeam());
                visitante3j5.setText(partido.getVisitTeam());
            }
            i += 1;
        }

        ArrayList<Match> matchDay6 = db.getPartidos(nameLeague, 6);
        /*************botones, textviews y TextView de jornada 1****************/
        TextView local1j6 = (TextView) this.findViewById( R.id.local1j6 );
        TextView visitante1j6 = (TextView) this.findViewById( R.id.visit1j6 );
        TextView local2j6 = (TextView) this.findViewById( R.id.local2j6 );
        TextView visitante2j6 = (TextView) this.findViewById( R.id.visit2j6 );
        TextView local3j6 = (TextView) this.findViewById( R.id.local3j6 );
        TextView visitante3j6 = (TextView) this.findViewById( R.id.visit3j6 );

        i=0;
        for (Match partido: matchDay6) {
            if (i==0) {
                local1j6.setText(partido.getLocalTeam());
                visitante1j6.setText(partido.getVisitTeam());
            }
            if (i==1) {
                local2j6.setText(partido.getLocalTeam());
                visitante2j6.setText(partido.getVisitTeam());
            }
            if (i==2) {
                local3j6.setText(partido.getLocalTeam());
                visitante3j6.setText(partido.getVisitTeam());
            }
            i += 1;
        }




        ArrayList<Match> matchDay7 = db.getPartidos(nameLeague, 7);
        /*************botones, textviews y TextView de jornada 1****************/
        TextView local1j7 = (TextView) this.findViewById( R.id.local1j7 );
        TextView visitante1j7 = (TextView) this.findViewById( R.id.visit1j7 );
        TextView local2j7 = (TextView) this.findViewById( R.id.local2j7 );
        TextView visitante2j7 = (TextView) this.findViewById( R.id.visit2j7 );
        TextView local3j7 = (TextView) this.findViewById( R.id.local3j7 );
        TextView visitante3j7 = (TextView) this.findViewById( R.id.visit3j7 );

        i=0;
        for (Match partido: matchDay7) {
            if (i==0) {
                local1j7.setText(partido.getLocalTeam());
                visitante1j7.setText(partido.getVisitTeam());
            }
            if (i==1) {
                local2j7.setText(partido.getLocalTeam());
                visitante2j7.setText(partido.getVisitTeam());
            }
            if (i==2) {
                local3j7.setText(partido.getLocalTeam());
                visitante3j7.setText(partido.getVisitTeam());
            }
            i += 1;
        }



        ArrayList<Match> matchDay8 = db.getPartidos(nameLeague, 8);
        /*************botones, textviews y TextView de jornada 1****************/
        TextView local1j8 = (TextView) this.findViewById( R.id.local1j8 );
        TextView visitante1j8 = (TextView) this.findViewById( R.id.visit1j8 );
        TextView local2j8 = (TextView) this.findViewById( R.id.local2j8 );
        TextView visitante2j8 = (TextView) this.findViewById( R.id.visit2j8 );
        TextView local3j8 = (TextView) this.findViewById( R.id.local3j8 );
        TextView visitante3j8 = (TextView) this.findViewById( R.id.visit3j8 );

        i=0;
        for (Match partido: matchDay8) {
            if (i==0) {
                local1j8.setText(partido.getLocalTeam());
                visitante1j8.setText(partido.getVisitTeam());
            }
            if (i==1) {
                local2j8.setText(partido.getLocalTeam());
                visitante2j8.setText(partido.getVisitTeam());
            }
            if (i==2) {
                local3j8.setText(partido.getLocalTeam());
                visitante3j8.setText(partido.getVisitTeam());
            }
            i += 1;
        }

        ArrayList<Match> matchDay9 = db.getPartidos(nameLeague, 9);
        /*************botones, textviews y TextView de jornada 1****************/
        TextView local1j9 = (TextView) this.findViewById( R.id.local1j9 );
        TextView visitante1j9 = (TextView) this.findViewById( R.id.visit1j9 );
        TextView local2j9 = (TextView) this.findViewById( R.id.local2j9 );
        TextView visitante2j9 = (TextView) this.findViewById( R.id.visit2j9 );
        TextView local3j9 = (TextView) this.findViewById( R.id.local3j9 );
        TextView visitante3j9 = (TextView) this.findViewById( R.id.visit3j9 );

        i=0;
        for (Match partido: matchDay9) {
            if (i==0) {
                local1j9.setText(partido.getLocalTeam());
                visitante1j9.setText(partido.getVisitTeam());
            }
            if (i==1) {
                local2j9.setText(partido.getLocalTeam());
                visitante2j9.setText(partido.getVisitTeam());
            }
            if (i==2) {
                local3j9.setText(partido.getLocalTeam());
                visitante3j9.setText(partido.getVisitTeam());
            }
            i += 1;
        }

        ArrayList<Match> matchDay10 = db.getPartidos(nameLeague, 10);
        /*************botones, textviews y TextView de jornada 1****************/
        TextView local1j10 = (TextView) this.findViewById( R.id.local1j10 );
        TextView visitante1j10 = (TextView) this.findViewById( R.id.visit1j10 );
        TextView local2j10 = (TextView) this.findViewById( R.id.local2j10 );
        TextView visitante2j10 = (TextView) this.findViewById( R.id.visit2j10 );
        TextView local3j10 = (TextView) this.findViewById( R.id.local3j10 );
        TextView visitante3j10 = (TextView) this.findViewById( R.id.visit3j10 );

        i=0;
        for (Match partido: matchDay10) {
            if (i==0) {
                local1j10.setText(partido.getLocalTeam());
                visitante1j10.setText(partido.getVisitTeam());
            }
            if (i==1) {
                local2j10.setText(partido.getLocalTeam());
                visitante2j10.setText(partido.getVisitTeam());
            }
            if (i==2) {
                local3j10.setText(partido.getLocalTeam());
                visitante3j10.setText(partido.getVisitTeam());
            }
            i += 1;
        }

    }

    /***********menu barra superior con opciones de volver atras y salir********************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu( menu );
        this.getMenuInflater().inflate( R.menu.menu_pagecalendario, menu );
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String nameLeague = this.getIntent().getExtras().getString( ETQ_NAME_LEAGUE );
        switch ( menuItem.getItemId() ) {
            case R.id.Clasificacion:
                Intent data1 = new Intent( this, PageLeague.class );
                data1.putExtra( PageLeague.ETQ_NAME_LEAGUE, nameLeague );
                Log.v(LOG_TAG, String.format(" in pageLeague(): launching league for: '%s'", nameLeague));
                this.startActivity(data1);
                break;
            case R.id.Resultados:
                Intent data2 = new Intent( this, Resultados.class );
                data2.putExtra( Resultados.ETQ_NAME_LEAGUE, nameLeague );
                Log.v(LOG_TAG, String.format(" in pageLeague(): launching league for: '%s'", nameLeague));
                this.startActivity(data2);
                break;
            case R.id.atras:
                finish();
                break;
        }
        return true;
    }

}
