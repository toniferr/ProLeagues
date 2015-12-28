package es.uvigo.esei.dm1516.p28.View;

import android.app.Application;
import es.uvigo.esei.dm1516.p28.Core.SqlIO;

/*
 * Clase que se utiliza para crear la bd y que pueda ser accesible desde toda la aplicacion
 */
public class App extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        this.sqlDb = new SqlIO(this.getApplicationContext());
    }

    public SqlIO getDb(){
        return sqlDb;
    }

    private SqlIO sqlDb;
}
