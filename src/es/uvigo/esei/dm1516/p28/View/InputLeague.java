package es.uvigo.esei.dm1516.p28.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import es.uvigo.esei.dm1516.p28.R;


public class InputLeague extends Activity {
    public static final String ETQ_NAME = "name";
    public static final String ETQ_T1 = "t1";
    public static final String ETQ_U1 = "u1";
    public static final String ETQ_T2 = "t2";
    public static final String ETQ_U2 = "u2";
    public static final String ETQ_T3 = "t3";
    public static final String ETQ_U3 = "u3";
    public static final String ETQ_T4 = "t4";
    public static final String ETQ_U4 = "u4";
    public static final String ETQ_T5 = "t5";
    public static final String ETQ_U5 = "u5";
    public static final String ETQ_T6 = "t6";
    public static final String ETQ_U6 = "u6";

    @Override
    public void onCreate(Bundle data) {
        super.onCreate(data);
        this.setContentView( R.layout.input_league );

        Button btSave = (Button) this.findViewById( R.id.btnInsert );
        Button btCancel = (Button) this.findViewById( R.id.btnCancel );
        EditText nameleague= (EditText) this.findViewById( R.id.nameInsert );

        /**botones de equipos y usuarios**************/
        EditText user1 = (EditText) this.findViewById( R.id.user1 );
        EditText team1 = (EditText) this.findViewById( R.id.team1 );
        EditText user2 = (EditText) this.findViewById( R.id.user2 );
        EditText team2 = (EditText) this.findViewById( R.id.team2 );
        EditText user3 = (EditText) this.findViewById( R.id.user3 );
        EditText team3 = (EditText) this.findViewById( R.id.team3 );
        EditText user4 = (EditText) this.findViewById( R.id.user4 );
        EditText team4 = (EditText) this.findViewById( R.id.team4 );
        EditText user5 = (EditText) this.findViewById( R.id.user5 );
        EditText team5 = (EditText) this.findViewById( R.id.team5 );
        EditText user6 = (EditText) this.findViewById( R.id.user6 );
        EditText team6 = (EditText) this.findViewById( R.id.team6 );
        /************boton cancelarr******************/
        btCancel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputLeague.this.setResult( RESULT_CANCELED );
                InputLeague.this.finish();
            }
        } );

        /************boton insertar**********************/
        btSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent data = new Intent();

                /**nombre de la liga**/
                String leaguename = nameleague.getText().toString().trim();

                /**nombre de equipos y de usuarios*****/
                String u1 = user1.getText().toString().trim();
                String t1 = team1.getText().toString().trim();
                String u2 = user2.getText().toString().trim();
                String t2 = team2.getText().toString().trim();
                String u3 = user3.getText().toString().trim();
                String t3 = team3.getText().toString().trim();
                String u4 = user4.getText().toString().trim();
                String t4 = team4.getText().toString().trim();
                String u5 = user5.getText().toString().trim();
                String t5 = team5.getText().toString().trim();
                String u6 = user6.getText().toString().trim();
                String t6 = team6.getText().toString().trim();


                if (!leaguename.isEmpty()  ) {

                        data.putExtra(ETQ_NAME, leaguename);
                        data.putExtra(ETQ_U1, u1);
                        data.putExtra(ETQ_T1, t1);
                        data.putExtra(ETQ_U2, u2);
                        data.putExtra(ETQ_T2, t2);
                        data.putExtra(ETQ_U3, u3);
                        data.putExtra(ETQ_T3, t3);
                        data.putExtra(ETQ_U4, u4);
                        data.putExtra(ETQ_T4, t4);
                        data.putExtra(ETQ_U5, u5);
                        data.putExtra(ETQ_T5, t5);
                        data.putExtra(ETQ_U6, u6);
                        data.putExtra(ETQ_T6, t6);

                        InputLeague.this.setResult(RESULT_OK, data);
                        InputLeague.this.finish();
                } else {
                        InputLeague.this.setResult(RESULT_CANCELED);
                        InputLeague.this.finish();
                }

            }
        } );
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
