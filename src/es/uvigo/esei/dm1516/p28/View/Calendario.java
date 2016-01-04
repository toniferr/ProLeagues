package es.uvigo.esei.dm1516.p28.View;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import es.uvigo.esei.dm1516.p28.R;


public class Calendario extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        this.setContentView( R.layout.page_calendario );

        /*************botones, textviews y edittext de jornada 1****************/
        Button btj1 = (Button) this.findViewById( R.id.buttonj11 );
        Button btj2 = (Button) this.findViewById( R.id.buttonj12 );
        Button btj3 = (Button) this.findViewById( R.id.buttonj13 );
        EditText gollocal1j1= (EditText) this.findViewById( R.id.editText );
        EditText golvisitante1j1= (EditText) this.findViewById( R.id.editText2 );
        EditText gollocal2j1= (EditText) this.findViewById( R.id.editText3 );
        EditText golvisitante2j1= (EditText) this.findViewById( R.id.editText4 );
        EditText gollocal3j1= (EditText) this.findViewById( R.id.editText5 );
        EditText golvisitante3j1= (EditText) this.findViewById( R.id.editText6 );
        TextView local1j1 = (TextView) this.findViewById( R.id.t1 );
        TextView visitante1j1 = (TextView) this.findViewById( R.id.textView4 );
        TextView local2j1 = (TextView) this.findViewById( R.id.textView5 );
        TextView visitante2j1 = (TextView) this.findViewById( R.id.textView7 );
        TextView local3j1 = (TextView) this.findViewById( R.id.textView8 );
        TextView visitante3j1 = (TextView) this.findViewById( R.id.textView10 );

        /*************botones, textviews y edittext de jornada 2****************/
        Button btj1j2 = (Button) this.findViewById( R.id.buttonj11j2 );
        Button btj2j2 = (Button) this.findViewById( R.id.buttonj12j2 );
        Button btj3j2 = (Button) this.findViewById( R.id.buttonj13j2 );
        EditText gollocal1j2= (EditText) this.findViewById( R.id.editTextj2 );
        EditText golvisitante1j2= (EditText) this.findViewById( R.id.editText2j2 );
        EditText gollocal2j2= (EditText) this.findViewById( R.id.editText3j2 );
        EditText golvisitante2j2= (EditText) this.findViewById( R.id.editText4j2 );
        EditText gollocal3j2= (EditText) this.findViewById( R.id.editText5j2 );
        EditText golvisitante3j2= (EditText) this.findViewById( R.id.editText6j2 );
        TextView local1j2 = (TextView) this.findViewById( R.id.t1j2 );
        TextView visitante1j2 = (TextView) this.findViewById( R.id.textView4j2 );
        TextView local2j2 = (TextView) this.findViewById( R.id.textView5j2 );
        TextView visitante2j2 = (TextView) this.findViewById( R.id.textView7j2 );
        TextView local3j2 = (TextView) this.findViewById( R.id.textView8j2 );
        TextView visitante3j2 = (TextView) this.findViewById( R.id.textView10j2 );

        /*************botones, textviews y edittext de jornada 3****************/
        Button btj1j3 = (Button) this.findViewById( R.id.buttonj11j3 );
        Button btj2j3 = (Button) this.findViewById( R.id.buttonj12j3 );
        Button btj3j3 = (Button) this.findViewById( R.id.buttonj13j3 );
        EditText gollocal1j3= (EditText) this.findViewById( R.id.editTextj3 );
        EditText golvisitante1j3= (EditText) this.findViewById( R.id.editText2j3 );
        EditText gollocal2j3= (EditText) this.findViewById( R.id.editText3j3 );
        EditText golvisitante2j3= (EditText) this.findViewById( R.id.editText4j3 );
        EditText gollocal3j3= (EditText) this.findViewById( R.id.editText5j3 );
        EditText golvisitante3j3= (EditText) this.findViewById( R.id.editText6j3 );
        TextView local1j3 = (TextView) this.findViewById( R.id.t1j3 );
        TextView visitante1j3 = (TextView) this.findViewById( R.id.textView4j3 );
        TextView local2j3 = (TextView) this.findViewById( R.id.textView5j3 );
        TextView visitante2j3 = (TextView) this.findViewById( R.id.textView7j3 );
        TextView local3j3 = (TextView) this.findViewById( R.id.textView8j3 );
        TextView visitante3j3 = (TextView) this.findViewById( R.id.textView10j3 );

        /*************botones, textviews y edittext de jornada 4****************/
        Button btj1j4 = (Button) this.findViewById( R.id.buttonj11j4 );
        Button btj2j4 = (Button) this.findViewById( R.id.buttonj12j4 );
        Button btj3j4 = (Button) this.findViewById( R.id.buttonj13j4 );
        EditText gollocal1j4= (EditText) this.findViewById( R.id.editTextj4 );
        EditText golvisitante1j4= (EditText) this.findViewById( R.id.editText2j4 );
        EditText gollocal2j4= (EditText) this.findViewById( R.id.editText3j4 );
        EditText golvisitante2j4= (EditText) this.findViewById( R.id.editText4j4 );
        EditText gollocal3j4= (EditText) this.findViewById( R.id.editText5j4 );
        EditText golvisitante3j4= (EditText) this.findViewById( R.id.editText6j4 );
        TextView local1j4 = (TextView) this.findViewById( R.id.t1j4 );
        TextView visitante1j4 = (TextView) this.findViewById( R.id.textView4j4 );
        TextView local2j4 = (TextView) this.findViewById( R.id.textView5j4 );
        TextView visitante2j4 = (TextView) this.findViewById( R.id.textView7j4 );
        TextView local3j4 = (TextView) this.findViewById( R.id.textView8j4 );
        TextView visitante3j4 = (TextView) this.findViewById( R.id.textView10j4 );

        /*************botones, textviews y edittext de jornada 5****************/
        Button btj1j5 = (Button) this.findViewById( R.id.buttonj11j5 );
        Button btj2j5 = (Button) this.findViewById( R.id.buttonj12j5 );
        Button btj3j5 = (Button) this.findViewById( R.id.buttonj13j5 );
        EditText gollocal1j5= (EditText) this.findViewById( R.id.editTextj5 );
        EditText golvisitante1j5= (EditText) this.findViewById( R.id.editText2j5 );
        EditText gollocal2j5= (EditText) this.findViewById( R.id.editText3j5 );
        EditText golvisitante2j5= (EditText) this.findViewById( R.id.editText4j5 );
        EditText gollocal3j5= (EditText) this.findViewById( R.id.editText5j5 );
        EditText golvisitante3j5= (EditText) this.findViewById( R.id.editText6j5 );
        TextView local1j5 = (TextView) this.findViewById( R.id.t1j5 );
        TextView visitante1j5 = (TextView) this.findViewById( R.id.textView4j5 );
        TextView local2j5 = (TextView) this.findViewById( R.id.textView5j5 );
        TextView visitante2j5 = (TextView) this.findViewById( R.id.textView7j5 );
        TextView local3j5 = (TextView) this.findViewById( R.id.textView8j5 );
        TextView visitante3j5 = (TextView) this.findViewById( R.id.textView10j5 );

        /*************botones, textviews y edittext de jornada 6****************/
        Button btj1j6 = (Button) this.findViewById( R.id.buttonj11j6 );
        Button btj2j6 = (Button) this.findViewById( R.id.buttonj12j6 );
        Button btj3j6 = (Button) this.findViewById( R.id.buttonj13j6 );
        EditText gollocal1j6= (EditText) this.findViewById( R.id.editTextj6 );
        EditText golvisitante1j6= (EditText) this.findViewById( R.id.editText2j6 );
        EditText gollocal2j6= (EditText) this.findViewById( R.id.editText3j6 );
        EditText golvisitante2j6= (EditText) this.findViewById( R.id.editText4j6 );
        EditText gollocal3j6= (EditText) this.findViewById( R.id.editText5j6 );
        EditText golvisitante3j6= (EditText) this.findViewById( R.id.editText6j6 );
        TextView local1j6 = (TextView) this.findViewById( R.id.t1j6 );
        TextView visitante1j6 = (TextView) this.findViewById( R.id.textView4j6 );
        TextView local2j6 = (TextView) this.findViewById( R.id.textView5j6 );
        TextView visitante2j6 = (TextView) this.findViewById( R.id.textView7j6 );
        TextView local3j6 = (TextView) this.findViewById( R.id.textView8j6 );
        TextView visitante3j6 = (TextView) this.findViewById( R.id.textView10j6 );

        /*************botones, textviews y edittext de jornada 7****************/
        Button btj1j7 = (Button) this.findViewById( R.id.buttonj11j7 );
        Button btj2j7 = (Button) this.findViewById( R.id.buttonj12j7 );
        Button btj3j7 = (Button) this.findViewById( R.id.buttonj13j7 );
        EditText gollocal1j7= (EditText) this.findViewById( R.id.editTextj7 );
        EditText golvisitante1j7= (EditText) this.findViewById( R.id.editText2j7 );
        EditText gollocal2j7= (EditText) this.findViewById( R.id.editText3j7 );
        EditText golvisitante2j7= (EditText) this.findViewById( R.id.editText4j7 );
        EditText gollocal3j7= (EditText) this.findViewById( R.id.editText5j7 );
        EditText golvisitante3j7= (EditText) this.findViewById( R.id.editText6j7 );
        TextView local1j7 = (TextView) this.findViewById( R.id.t1j7 );
        TextView visitante1j7 = (TextView) this.findViewById( R.id.textView4j7 );
        TextView local2j7 = (TextView) this.findViewById( R.id.textView5j7 );
        TextView visitante2j7 = (TextView) this.findViewById( R.id.textView7j7 );
        TextView local3j7 = (TextView) this.findViewById( R.id.textView8j7 );
        TextView visitante3j7 = (TextView) this.findViewById( R.id.textView10j7 );

        /*************botones, textviews y edittext de jornada 8****************/
        Button btj1j8 = (Button) this.findViewById( R.id.buttonj11j8 );
        Button btj2j8 = (Button) this.findViewById( R.id.buttonj12j8 );
        Button btj3j8 = (Button) this.findViewById( R.id.buttonj13j8 );
        EditText gollocal1j8= (EditText) this.findViewById( R.id.editTextj8 );
        EditText golvisitante1j8= (EditText) this.findViewById( R.id.editText2j8 );
        EditText gollocal2j8= (EditText) this.findViewById( R.id.editText3j8 );
        EditText golvisitante2j8= (EditText) this.findViewById( R.id.editText4j8 );
        EditText gollocal3j8= (EditText) this.findViewById( R.id.editText5j8 );
        EditText golvisitante3j8= (EditText) this.findViewById( R.id.editText6j8 );
        TextView local1j8 = (TextView) this.findViewById( R.id.t1j8 );
        TextView visitante1j8 = (TextView) this.findViewById( R.id.textView4j8 );
        TextView local2j8 = (TextView) this.findViewById( R.id.textView5j8 );
        TextView visitante2j8 = (TextView) this.findViewById( R.id.textView7j8 );
        TextView local3j8 = (TextView) this.findViewById( R.id.textView8j8 );
        TextView visitante3j8 = (TextView) this.findViewById( R.id.textView10j8 );

        /*************botones, textviews y edittext de jornada 9****************/
        Button btj1j9 = (Button) this.findViewById( R.id.buttonj11j9 );
        Button btj2j9 = (Button) this.findViewById( R.id.buttonj12j9 );
        Button btj3j9 = (Button) this.findViewById( R.id.buttonj13j9 );
        EditText gollocal1j9= (EditText) this.findViewById( R.id.editTextj9 );
        EditText golvisitante1j9= (EditText) this.findViewById( R.id.editText2j9 );
        EditText gollocal2j9= (EditText) this.findViewById( R.id.editText3j9 );
        EditText golvisitante2j9= (EditText) this.findViewById( R.id.editText4j9 );
        EditText gollocal3j9= (EditText) this.findViewById( R.id.editText5j9 );
        EditText golvisitante3j9= (EditText) this.findViewById( R.id.editText6j9 );
        TextView local1j9 = (TextView) this.findViewById( R.id.t1j9 );
        TextView visitante1j9 = (TextView) this.findViewById( R.id.textView4j9 );
        TextView local2j9 = (TextView) this.findViewById( R.id.textView5j9 );
        TextView visitante2j9 = (TextView) this.findViewById( R.id.textView7j9 );
        TextView local3j9 = (TextView) this.findViewById( R.id.textView8j9 );
        TextView visitante3j9 = (TextView) this.findViewById( R.id.textView10j9 );

        /*************botones, textviews y edittext de jornada 10****************/
        Button btj1j10 = (Button) this.findViewById( R.id.buttonj11j10 );
        Button btj2j10 = (Button) this.findViewById( R.id.buttonj12j10 );
        Button btj3j10 = (Button) this.findViewById( R.id.buttonj13j10 );
        EditText gollocal1j10= (EditText) this.findViewById( R.id.editTextj10 );
        EditText golvisitante1j10= (EditText) this.findViewById( R.id.editText2j10 );
        EditText gollocal2j10= (EditText) this.findViewById( R.id.editText3j10 );
        EditText golvisitante2j10= (EditText) this.findViewById( R.id.editText4j10 );
        EditText gollocal3j10= (EditText) this.findViewById( R.id.editText5j10 );
        EditText golvisitante3j10= (EditText) this.findViewById( R.id.editText6j10 );
        TextView local1j10 = (TextView) this.findViewById( R.id.t1j10 );
        TextView visitante1j10 = (TextView) this.findViewById( R.id.textView4j10 );
        TextView local2j10 = (TextView) this.findViewById( R.id.textView5j10 );
        TextView visitante2j10 = (TextView) this.findViewById( R.id.textView7j10 );
        TextView local3j10 = (TextView) this.findViewById( R.id.textView8j10 );
        TextView visitante3j10 = (TextView) this.findViewById( R.id.textView10j10 );



    }

    /***********menu barra superior con opciones de volver atras y salir********************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu( menu );
        this.getMenuInflater().inflate( R.menu.menu_info, menu );
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch ( menuItem.getItemId() ) {
            case R.id.atras:
                finish();
                break;
        }
        return true;
    }

}
