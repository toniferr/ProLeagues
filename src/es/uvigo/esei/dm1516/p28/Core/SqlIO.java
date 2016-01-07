package es.uvigo.esei.dm1516.p28.Core;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


public class SqlIO extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "proleagues";
    public static final int DATABASE_VERSION = 2;


    /******************constructor***********************************************************/
    public SqlIO(Context context)
    {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }


    /**************************************onOpen*********************************************/
    @Override
    public void onOpen(SQLiteDatabase db)
    {
        db.beginTransaction();
        try {
            db.execSQL( "DELETE FROM league WHERE name IS NULL" );
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        return;
    }


    /**************************create table****************************************/
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.beginTransaction();

        try {
            db.execSQL( "CREATE TABLE IF NOT EXISTS league("
                    + "name string(15) PRIMARY KEY"
                    + ")"  );

            db.execSQL( "CREATE TABLE IF NOT EXISTS team("
                    + "nameTeam string(50) PRIMARY KEY,"
                    + "user string(50) NOT NULL,"
                    + "points int,"
                    + "gv int,"
                    + "nameLeague string FOREIGNKEY REFERENCES league(name) ON DELETE CASCADE"
                    + ")"  );

            db.execSQL( "CREATE TABLE IF NOT EXISTS match("
                    + "localTeam string(50),"
                    + "visitTeam string(50),"
                    + "matchDay int NOT NULL,"
                    + "localGoals int,"
                    + "visitGoals int,"
                    + "finalizado int,"
                    + "nameLeague string,"
                    + "PRIMARY KEY (localTeam, visitTeam)"
                    + ")" );


            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }


    /***********************upgrade**********************************************************/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.beginTransaction();

        try {
            db.execSQL( "DROP TABLE IF EXISTS league" );
            db.execSQL( "DROP TABLE IF EXISTS team" );
            db.execSQL( "DROP TABLE IF EXISTS match" );
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        this.onCreate( db  );
    }



    /*********************extrae todos los items***************************************************/
    public List<League> getAllItems()
    {
        ArrayList<League> toret = new ArrayList<>();
        Cursor cursor = this.getReadableDatabase().rawQuery( "SELECT * FROM league", null );

        if ( cursor.moveToFirst() ) {
            do {
                toret.add( new League( cursor.getString( 0 )) );
            } while( cursor.moveToNext()  );
        }

        return toret;
    }


    public List<Team> getAllTeams(String nameLeague)
    {
        ArrayList<Team> toret = new ArrayList<>();
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM team WHERE nameLeague=? ORDER BY points DESC, gv DESC",
                    new String[] { nameLeague } );

        if ( cursor.moveToFirst() ) {
            do {
                toret.add( new Team( cursor.getString( 0 ), cursor.getString( 1 ),cursor.getInt( 2 ),cursor.getInt( 3 ), cursor.getString( 4 ) ) );
            } while( cursor.moveToNext()  );
        }

        return toret;
    }


    /************************cuenta todos los equipos de una liga*************************************************/

    public int getCountTeams(String league) {
        return this.getReadableDatabase().rawQuery( "SELECT * FROM team WHERE nameLeague=?", new String[] { league }  ).getCount();
    }

    /************************todos los nombres de equipos de una liga*************************************************/

    public ArrayList<String> getNameTeams(String league) {
        ArrayList<String> toret = new ArrayList<>();
        Cursor cursor = this.getReadableDatabase().rawQuery( "SELECT * FROM team WHERE nameLeague=?", new String[] { league }  );
        if ( cursor.moveToFirst() ) {
            do {
                toret.add(cursor.getString( 0 ));
            } while( cursor.moveToNext()  );
        }

        return toret;
    }


    /***********************insert*******************************************************************/
    public void add(League league) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        try {
            db.execSQL( "INSERT INTO league(name) VALUES(?)",
                    new String[] { league.getName() } );
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        return;
    }

    public int checkLeague(League league){
        return this.getReadableDatabase().rawQuery( "SELECT * FROM league WHERE name=?", new String[] { league.getName() }  ).getCount();
    }

    /************************añadir equipo*********************************************************************/
       public void addTeam(Team team) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.beginTransaction();
            try {
                db.execSQL( "INSERT INTO team(nameTeam, user, points, gv, nameLeague) VALUES(?, ?, ?, ?, ?)",
                        new String[] { team.getName(), team.getUser(), Integer.toString(team.getPoints()), Integer.toString(team.getGolaverage()), team.getNameLeague() } );
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }

            return;
        }

        public int checkTeam(Team team){
            return this.getReadableDatabase().rawQuery( "SELECT * FROM team WHERE nameTeam=?", new String[] { team.getName() }  ).getCount();
        }


            /***********************añadir partido **************************************/
        public void addMatch(Match match) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.beginTransaction();
            try {
                db.execSQL( "INSERT INTO match(localTeam, visitTeam, matchDay, localGoals, visitGoals, finalizado, nameLeague) VALUES(?, ?, ?, ?, ?, ?, ?)",
                        new String[] { match.getLocalTeam(), match.getVisitTeam(), Integer.toString(match.getMatchDay()), Integer.toString(match.getLocalGoals()), Integer.toString(match.getVisitGoals()), Integer.toString(match.getFinalizado()), match.getNameLeague()} );
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }

            return;
        }


    public League getByName(String nameLeague)
    {
        League toret = null;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM league WHERE name = ?",
                new String[]{ nameLeague } );

        if ( cursor.moveToFirst() ) {
            toret = new League( cursor.getString( 0 ) );
        }

        return toret;
    }

    /***********extraer partidos de jornadas**********************************************/
    public ArrayList<Match> getPartidos(String nameLeague, int jornada){
        ArrayList<Match> toret= new ArrayList<Match>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM match WHERE nameLeague = ? AND matchDay = ?",
                new String[]{ nameLeague , Integer.toString(jornada)} );

        if ( cursor.moveToFirst() ) {
            do {
                toret.add( new Match( cursor.getString( 0 ),cursor.getString( 1 ),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4), cursor.getInt(5),cursor.getString( 6 ) ));
            } while( cursor.moveToNext()  );
        }

        return toret;
    }

    /********************delete league*************************************************/
    public void remove(League league)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        try {
            db.execSQL( "DELETE FROM league WHERE name = ?",
                    new String[] { league.getName() } );
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        return;
    }

    /********************set match*************************************************/
    public void setMatch(Match match)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        try {
            db.execSQL( "UPDATE match SET localGoals=?, visitGoals=?, finalizado=1 WHERE localTeam = ? AND visitTeam=?;",
                    new String[] { Integer.toString(match.getLocalGoals()), Integer.toString(match.getVisitGoals()),  match.getLocalTeam(), match.getVisitTeam()} );
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        return;
    }

    public void empate(String localTeam, String visitTeam){
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        try {
            db.execSQL( "UPDATE team SET points=points-1 WHERE nameTeam = ?;",
                    new String[] { localTeam} );
            db.execSQL( "UPDATE team SET points=points-1 WHERE nameTeam = ?;",
                    new String[] { visitTeam} );
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        return;
    }

    public void victoria(String localTeam, int localGoal, String visitTeam, int visitGoal){
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        try {
            db.execSQL( "UPDATE team SET points=points-3, gv=gv-? WHERE nameTeam = ?;",
                    new String[] { Integer.toString(localGoal-visitGoal), localTeam} );
            db.execSQL( "UPDATE team SET gv=gv+? WHERE nameTeam = ?;",
                    new String[] { Integer.toString(localGoal-visitGoal), visitTeam} );
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        return;
    }

    public void sumEmpate(String localTeam, String visitTeam){
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        try {
            db.execSQL( "UPDATE team SET points=points+1 WHERE nameTeam = ?;",
                    new String[] { localTeam} );
            db.execSQL( "UPDATE team SET points=points+1 WHERE nameTeam = ?;",
                    new String[] { visitTeam} );
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        return;
    }

    public void sumVictoria(String localTeam, int localGoal, String visitTeam, int visitGoal){
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        try {
            db.execSQL( "UPDATE team SET points=points+3, gv=gv+? WHERE nameTeam = ?;",
                    new String[] { Integer.toString(localGoal-visitGoal), localTeam} );
            db.execSQL( "UPDATE team SET gv=gv-? WHERE nameTeam = ?;",
                    new String[] { Integer.toString(localGoal-visitGoal), visitTeam} );
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        return;
    }




}
