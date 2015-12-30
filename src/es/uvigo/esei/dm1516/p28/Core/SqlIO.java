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
                    + "name string(255) PRIMARY KEY,"
                    + "teams int NOT NULL"
                    + ")"  );

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
                toret.add( new League( cursor.getString( 0 ), cursor.getInt( 1 ) ) );
            } while( cursor.moveToNext()  );
        }

        return toret;
    }


    /************************cuenta todos los items*************************************************/
    public int getCountItems() {
        return this.getReadableDatabase().rawQuery( "SELECT * FROM league", null ).getCount();
    }


    /***********************insert*******************************************************************/
    public void add(League league) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        try {
            db.execSQL( "INSERT INTO league(name, teams) VALUES(?, ?)",
                    new String[] { league.getName(), Integer.toString( league.getTeams() ) } );
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
            toret = new League( cursor.getString( 0 ), cursor.getInt( 1 ) );
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
}
