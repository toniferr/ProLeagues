package es.uvigo.esei.dm1516.p28.View;

import android.app.Application;
import es.uvigo.esei.dm1516.p28.Core.SqlIO;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        this.sqlDb = new SqlIO( this.getApplicationContext() );
    }

    /** @return the database handler */
    public SqlIO getDb() {
        return this.sqlDb;
    }

    private SqlIO sqlDb;
}
