package es.uvigo.esei.dm1516.p28.View;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import es.uvigo.esei.dm1516.p28.Core.Match;
import es.uvigo.esei.dm1516.p28.Core.SqlIO;
import es.uvigo.esei.dm1516.p28.R;

import java.util.ArrayList;

public class Resultados extends Activity {

    public static final String ETQ_NAME_LEAGUE = "name_league";
    public static final String LOG_TAG = "Main";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        this.setContentView( R.layout.page_resultados );
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



        EditText localgoal1j1= (EditText) this.findViewById( R.id.localgoalsl1j1 );
        EditText visitgoal1j1= (EditText) this.findViewById( R.id.localgoalsv1j1 );
        EditText localgoal2j1= (EditText) this.findViewById( R.id.localgoalsl2j1 );
        EditText visitgoal2j1= (EditText) this.findViewById( R.id.localgoalsv2j1 );
        EditText localgoal3j1= (EditText) this.findViewById( R.id.localgoalsl3j1 );
        EditText visitgoal3j1= (EditText) this.findViewById( R.id.localgoalsv3j1 );


        Button b1j1 = (Button) this.findViewById( R.id.b1j1 );
        Button b2j1 = (Button) this.findViewById( R.id.b2j1 );
        Button b3j1 = (Button) this.findViewById( R.id.b3j1 );

        int i=0;
        for (Match partido: matchDay1) {
            if (i==0) {
                local1j1.setText(partido.getLocalTeam());
                visitante1j1.setText(partido.getVisitTeam());
                localgoal1j1.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal1j1.setText(Integer.toString(partido.getVisitGoals()));

                b1j1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal1j1.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal1j1.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido,db);
                        refresh();
                    }
                });
            }
            if (i==1) {
                local2j1.setText(partido.getLocalTeam());
                visitante2j1.setText(partido.getVisitTeam());
                localgoal2j1.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal2j1.setText(Integer.toString(partido.getVisitGoals()));

                b2j1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal2j1.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal2j1.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==2) {
                local3j1.setText(partido.getLocalTeam());
                visitante3j1.setText(partido.getVisitTeam());
                localgoal3j1.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal3j1.setText(Integer.toString(partido.getVisitGoals()));

                b3j1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal3j1.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal3j1.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
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


        EditText localgoal1j2= (EditText) this.findViewById( R.id.localgoalsl1j2 );
        EditText visitgoal1j2= (EditText) this.findViewById( R.id.localgoalsv1j2 );
        EditText localgoal2j2= (EditText) this.findViewById( R.id.localgoalsl2j2 );
        EditText visitgoal2j2= (EditText) this.findViewById( R.id.localgoalsv2j2 );
        EditText localgoal3j2= (EditText) this.findViewById( R.id.localgoalsl3j2 );
        EditText visitgoal3j2= (EditText) this.findViewById( R.id.localgoalsv3j2 );

        Button b1j2 = (Button) this.findViewById( R.id.b1j2 );
        Button b2j2 = (Button) this.findViewById( R.id.b2j2 );
        Button b3j2 = (Button) this.findViewById( R.id.b3j2 );

        i=0;
        for (Match partido: matchDay2) {
            if (i==0) {
                local1j2.setText(partido.getLocalTeam());
                visitante1j2.setText(partido.getVisitTeam());
                localgoal1j2.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal1j2.setText(Integer.toString(partido.getVisitGoals()));

                b1j2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal1j2.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal1j2.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==1) {
                local2j2.setText(partido.getLocalTeam());
                visitante2j2.setText(partido.getVisitTeam());
                localgoal2j2.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal2j2.setText(Integer.toString(partido.getVisitGoals()));

                b2j2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal2j2.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal2j2.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==2) {
                local3j2.setText(partido.getLocalTeam());
                visitante3j2.setText(partido.getVisitTeam());
                localgoal3j2.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal3j2.setText(Integer.toString(partido.getVisitGoals()));

                b3j2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal3j2.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal3j2.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
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


        EditText localgoal1j3= (EditText) this.findViewById( R.id.localgoalsl1j3 );
        EditText visitgoal1j3= (EditText) this.findViewById( R.id.localgoalsv1j3 );
        EditText localgoal2j3= (EditText) this.findViewById( R.id.localgoalsl2j3 );
        EditText visitgoal2j3= (EditText) this.findViewById( R.id.localgoalsv2j3 );
        EditText localgoal3j3= (EditText) this.findViewById( R.id.localgoalsl3j3 );
        EditText visitgoal3j3= (EditText) this.findViewById( R.id.localgoalsv3j3 );

        Button b1j3 = (Button) this.findViewById( R.id.b1j3 );
        Button b2j3 = (Button) this.findViewById( R.id.b2j3 );
        Button b3j3 = (Button) this.findViewById( R.id.b3j3 );

        i=0;
        for (Match partido: matchDay3) {
            if (i==0) {
                local1j3.setText(partido.getLocalTeam());
                visitante1j3.setText(partido.getVisitTeam());
                localgoal1j3.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal1j3.setText(Integer.toString(partido.getVisitGoals()));

                b1j3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal1j3.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal1j3.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==1) {
                local2j3.setText(partido.getLocalTeam());
                visitante2j3.setText(partido.getVisitTeam());
                localgoal2j3.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal2j3.setText(Integer.toString(partido.getVisitGoals()));

                b2j3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal2j3.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal2j3.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==2) {
                local3j3.setText(partido.getLocalTeam());
                visitante3j3.setText(partido.getVisitTeam());
                localgoal3j3.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal3j3.setText(Integer.toString(partido.getVisitGoals()));

                b3j3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal3j3.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal3j3.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
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



        EditText localgoal1j4= (EditText) this.findViewById( R.id.localgoalsl1j4 );
        EditText visitgoal1j4= (EditText) this.findViewById( R.id.localgoalsv1j4 );
        EditText localgoal2j4= (EditText) this.findViewById( R.id.localgoalsl2j4 );
        EditText visitgoal2j4= (EditText) this.findViewById( R.id.localgoalsv2j4 );
        EditText localgoal3j4= (EditText) this.findViewById( R.id.localgoalsl3j4 );
        EditText visitgoal3j4= (EditText) this.findViewById( R.id.localgoalsv3j4 );

        Button b1j4 = (Button) this.findViewById( R.id.b1j4 );
        Button b2j4 = (Button) this.findViewById( R.id.b2j4 );
        Button b3j4 = (Button) this.findViewById( R.id.b3j4 );

        i=0;
        for (Match partido: matchDay4) {
            if (i==0) {
                local1j4.setText(partido.getLocalTeam());
                visitante1j4.setText(partido.getVisitTeam());
                localgoal1j4.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal1j4.setText(Integer.toString(partido.getVisitGoals()));

                b1j4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal1j4.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal1j4.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==1) {
                local2j4.setText(partido.getLocalTeam());
                visitante2j4.setText(partido.getVisitTeam());
                localgoal2j4.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal2j4.setText(Integer.toString(partido.getVisitGoals()));

                b2j4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal2j4.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal2j4.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==2) {
                local3j4.setText(partido.getLocalTeam());
                visitante3j4.setText(partido.getVisitTeam());
                localgoal3j4.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal3j4.setText(Integer.toString(partido.getVisitGoals()));

                b3j4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal3j4.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal3j4.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
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



        EditText localgoal1j5= (EditText) this.findViewById( R.id.localgoalsl1j5 );
        EditText visitgoal1j5= (EditText) this.findViewById( R.id.localgoalsv1j5 );
        EditText localgoal2j5= (EditText) this.findViewById( R.id.localgoalsl2j5 );
        EditText visitgoal2j5= (EditText) this.findViewById( R.id.localgoalsv2j5 );
        EditText localgoal3j5= (EditText) this.findViewById( R.id.localgoalsl3j5 );
        EditText visitgoal3j5= (EditText) this.findViewById( R.id.localgoalsv3j5 );

        Button b1j5 = (Button) this.findViewById( R.id.b1j5 );
        Button b2j5 = (Button) this.findViewById( R.id.b2j5 );
        Button b3j5 = (Button) this.findViewById( R.id.b3j5 );

        i=0;
        for (Match partido: matchDay5) {
            if (i==0) {
                local1j5.setText(partido.getLocalTeam());
                visitante1j5.setText(partido.getVisitTeam());
                localgoal1j5.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal1j5.setText(Integer.toString(partido.getVisitGoals()));

                b1j5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal1j5.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal1j5.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==1) {
                local2j5.setText(partido.getLocalTeam());
                visitante2j5.setText(partido.getVisitTeam());
                localgoal2j5.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal2j5.setText(Integer.toString(partido.getVisitGoals()));

                b2j5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal2j5.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal2j5.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==2) {
                local3j5.setText(partido.getLocalTeam());
                visitante3j5.setText(partido.getVisitTeam());
                localgoal3j5.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal3j5.setText(Integer.toString(partido.getVisitGoals()));

                b3j5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal3j5.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal3j5.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
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



        EditText localgoal1j6= (EditText) this.findViewById( R.id.localgoalsl1j6 );
        EditText visitgoal1j6= (EditText) this.findViewById( R.id.localgoalsv1j6 );
        EditText localgoal2j6= (EditText) this.findViewById( R.id.localgoalsl2j6 );
        EditText visitgoal2j6= (EditText) this.findViewById( R.id.localgoalsv2j6 );
        EditText localgoal3j6= (EditText) this.findViewById( R.id.localgoalsl3j6 );
        EditText visitgoal3j6= (EditText) this.findViewById( R.id.localgoalsv3j6 );

        Button b1j6 = (Button) this.findViewById( R.id.b1j6 );
        Button b2j6 = (Button) this.findViewById( R.id.b2j6 );
        Button b3j6 = (Button) this.findViewById( R.id.b3j6 );

        i=0;
        for (Match partido: matchDay6) {
            if (i==0) {
                local1j6.setText(partido.getLocalTeam());
                visitante1j6.setText(partido.getVisitTeam());
                localgoal1j6.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal1j6.setText(Integer.toString(partido.getVisitGoals()));

                b1j6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal1j6.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal1j6.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==1) {
                local2j6.setText(partido.getLocalTeam());
                visitante2j6.setText(partido.getVisitTeam());
                localgoal2j6.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal2j6.setText(Integer.toString(partido.getVisitGoals()));

                b2j6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal2j6.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal2j6.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==2) {
                local3j6.setText(partido.getLocalTeam());
                visitante3j6.setText(partido.getVisitTeam());
                localgoal3j6.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal3j6.setText(Integer.toString(partido.getVisitGoals()));

                b3j6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal3j6.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal3j6.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
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


        EditText localgoal1j7= (EditText) this.findViewById( R.id.localgoalsl1j7 );
        EditText visitgoal1j7= (EditText) this.findViewById( R.id.localgoalsv1j7 );
        EditText localgoal2j7= (EditText) this.findViewById( R.id.localgoalsl2j7 );
        EditText visitgoal2j7= (EditText) this.findViewById( R.id.localgoalsv2j7 );
        EditText localgoal3j7= (EditText) this.findViewById( R.id.localgoalsl3j7 );
        EditText visitgoal3j7= (EditText) this.findViewById( R.id.localgoalsv3j7 );

        Button b1j7 = (Button) this.findViewById( R.id.b1j7 );
        Button b2j7 = (Button) this.findViewById( R.id.b2j7 );
        Button b3j7 = (Button) this.findViewById( R.id.b3j7 );

        i=0;
        for (Match partido: matchDay7) {
            if (i==0) {
                local1j7.setText(partido.getLocalTeam());
                visitante1j7.setText(partido.getVisitTeam());
                localgoal1j7.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal1j7.setText(Integer.toString(partido.getVisitGoals()));

                b1j7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal1j7.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal1j7.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==1) {
                local2j7.setText(partido.getLocalTeam());
                visitante2j7.setText(partido.getVisitTeam());
                localgoal2j7.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal2j7.setText(Integer.toString(partido.getVisitGoals()));

                b2j7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal2j7.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal2j7.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==2) {
                local3j7.setText(partido.getLocalTeam());
                visitante3j7.setText(partido.getVisitTeam());
                localgoal3j7.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal3j7.setText(Integer.toString(partido.getVisitGoals()));

                b3j7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal3j7.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal3j7.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
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


        EditText localgoal1j8= (EditText) this.findViewById( R.id.localgoalsl1j8 );
        EditText visitgoal1j8= (EditText) this.findViewById( R.id.localgoalsv1j8 );
        EditText localgoal2j8= (EditText) this.findViewById( R.id.localgoalsl2j8 );
        EditText visitgoal2j8= (EditText) this.findViewById( R.id.localgoalsv2j8 );
        EditText localgoal3j8= (EditText) this.findViewById( R.id.localgoalsl3j8 );
        EditText visitgoal3j8= (EditText) this.findViewById( R.id.localgoalsv3j8 );

        Button b1j8 = (Button) this.findViewById( R.id.b1j8 );
        Button b2j8 = (Button) this.findViewById( R.id.b2j8 );
        Button b3j8 = (Button) this.findViewById( R.id.b3j8 );

        i=0;
        for (Match partido: matchDay8) {
            if (i==0) {
                local1j8.setText(partido.getLocalTeam());
                visitante1j8.setText(partido.getVisitTeam());
                localgoal1j8.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal1j8.setText(Integer.toString(partido.getVisitGoals()));

                b1j8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal1j8.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal1j8.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==1) {
                local2j8.setText(partido.getLocalTeam());
                visitante2j8.setText(partido.getVisitTeam());
                localgoal2j8.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal2j8.setText(Integer.toString(partido.getVisitGoals()));

                b2j8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal2j8.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal2j8.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==2) {
                local3j8.setText(partido.getLocalTeam());
                visitante3j8.setText(partido.getVisitTeam());
                localgoal3j8.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal3j8.setText(Integer.toString(partido.getVisitGoals()));

                b3j8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal3j8.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal3j8.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
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



        EditText localgoal1j9= (EditText) this.findViewById( R.id.localgoalsl1j9 );
        EditText visitgoal1j9= (EditText) this.findViewById( R.id.localgoalsv1j9 );
        EditText localgoal2j9= (EditText) this.findViewById( R.id.localgoalsl2j9 );
        EditText visitgoal2j9= (EditText) this.findViewById( R.id.localgoalsv2j9 );
        EditText localgoal3j9= (EditText) this.findViewById( R.id.localgoalsl3j9 );
        EditText visitgoal3j9= (EditText) this.findViewById( R.id.localgoalsv3j9 );

        Button b1j9 = (Button) this.findViewById( R.id.b1j9 );
        Button b2j9 = (Button) this.findViewById( R.id.b2j9 );
        Button b3j9 = (Button) this.findViewById( R.id.b3j9 );


        i=0;
        for (Match partido: matchDay9) {
            if (i==0) {
                local1j9.setText(partido.getLocalTeam());
                visitante1j9.setText(partido.getVisitTeam());
                localgoal1j9.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal1j9.setText(Integer.toString(partido.getVisitGoals()));

                b1j9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal1j9.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal1j9.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==1) {
                local2j9.setText(partido.getLocalTeam());
                visitante2j9.setText(partido.getVisitTeam());
                localgoal2j9.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal2j9.setText(Integer.toString(partido.getVisitGoals()));

                b2j9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal2j9.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal2j9.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==2) {
                local3j9.setText(partido.getLocalTeam());
                visitante3j9.setText(partido.getVisitTeam());
                localgoal3j9.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal3j9.setText(Integer.toString(partido.getVisitGoals()));

                b3j9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal3j9.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal3j9.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
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


        EditText localgoal1j10= (EditText) this.findViewById( R.id.localgoalsl1j10 );
        EditText visitgoal1j10= (EditText) this.findViewById( R.id.localgoalsv1j10 );
        EditText localgoal2j10= (EditText) this.findViewById( R.id.localgoalsl2j10 );
        EditText visitgoal2j10= (EditText) this.findViewById( R.id.localgoalsv2j10 );
        EditText localgoal3j10= (EditText) this.findViewById( R.id.localgoalsl3j10 );
        EditText visitgoal3j10= (EditText) this.findViewById( R.id.localgoalsv3j10 );

        Button b1j10 = (Button) this.findViewById( R.id.b1j10 );
        Button b2j10 = (Button) this.findViewById( R.id.b2j10 );
        Button b3j10 = (Button) this.findViewById( R.id.b3j10 );



        i=0;
        for (Match partido: matchDay10) {
            if (i==0) {
                local1j10.setText(partido.getLocalTeam());
                visitante1j10.setText(partido.getVisitTeam());
                localgoal1j10.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal1j10.setText(Integer.toString(partido.getVisitGoals()));

                b1j10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal1j10.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal1j10.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==1) {
                local2j10.setText(partido.getLocalTeam());
                visitante2j10.setText(partido.getVisitTeam());
                localgoal2j10.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal2j10.setText(Integer.toString(partido.getVisitGoals()));

                b2j10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal2j10.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal2j10.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido, db);
                        refresh();
                    }
                });
            }
            if (i==2) {
                local3j10.setText(partido.getLocalTeam());
                visitante3j10.setText(partido.getVisitTeam());
                localgoal3j10.setText(Integer.toString(partido.getLocalGoals()));
                visitgoal3j10.setText(Integer.toString(partido.getVisitGoals()));

                b3j10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        decPuntos(partido, db);
                        int localgoal = Integer.parseInt(localgoal3j10.getText().toString().trim());
                        int visitgoal = Integer.parseInt(visitgoal3j10.getText().toString().trim());
                        partido.setLocalGoals(localgoal);
                        partido.setVisitGoals(visitgoal);
                        incPuntos(partido,db);
                        refresh();
                    }
                });
            }
            i += 1;
        }





    }

    /***********menu barra superior con opciones de volver atras y salir********************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu( menu );
        this.getMenuInflater().inflate( R.menu.menu_pageresultados, menu );
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
            case R.id.Calendario:
                Intent data = new Intent( this, Calendario.class );
                data.putExtra( Calendario.ETQ_NAME_LEAGUE, nameLeague );
                Log.v(LOG_TAG, String.format(" in pageLeague(): launching league for: '%s'", nameLeague));
                this.startActivity(data);
                break;
            case R.id.atras:
                finish();
                break;
        }
        return true;
    }


    public void refresh(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void decPuntos(Match partido, SqlIO db) {
        if (partido.getFinalizado() != 0) {
            if ((partido.getLocalGoals() == partido.getVisitGoals())) {
                    db.empate(partido.getLocalTeam(), partido.getVisitTeam());
            }
            if (partido.getLocalGoals() > partido.getVisitGoals()) {
                    db.victoria(partido.getLocalTeam(),partido.getLocalGoals(),partido.getVisitTeam(),partido.getVisitGoals());
            }
            if (partido.getLocalGoals() < partido.getVisitGoals()) {
                db.victoria(partido.getVisitTeam(), partido.getVisitGoals(), partido.getLocalTeam(), partido.getLocalGoals());
            }

        }
    }

    public void incPuntos(Match partido, SqlIO db) {
            db.setMatch(partido);
            if ((partido.getLocalGoals() == partido.getVisitGoals())) {
                db.sumEmpate(partido.getLocalTeam(), partido.getVisitTeam());
            }
            if (partido.getLocalGoals() > partido.getVisitGoals()) {
                db.sumVictoria(partido.getLocalTeam(),partido.getLocalGoals(),partido.getVisitTeam(),partido.getVisitGoals());
            }
            if (partido.getLocalGoals() < partido.getVisitGoals()) {
                db.sumVictoria(partido.getVisitTeam(), partido.getVisitGoals(), partido.getLocalTeam(), partido.getLocalGoals());
            }

    }



}

