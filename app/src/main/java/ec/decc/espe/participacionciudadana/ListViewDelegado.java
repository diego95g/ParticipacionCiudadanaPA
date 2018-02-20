package ec.decc.espe.participacionciudadana;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewDelegado extends AppCompatActivity {

    private ListView lvDel;
    private String[] delegadoS = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_delegado);

        lvDel =(ListView)findViewById(R.id.listaDel);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "partici", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();
        //Cursor fila = bd.rawQuery( " select nombreReg from region " , null);

        String [] campos = {"nombreDel"};
        Cursor c = bd.query("delegado", campos, null, null, null, null, null);
        if (c.moveToFirst()) {
            delegadoS = new String[c.getCount()];
            int cont=0;
            do {
                delegadoS[cont]= c.getString(0);
                cont=cont+1;
            } while(c.moveToNext());
        }
        bd.close();
        if(delegadoS!=null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, delegadoS);
            //ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, delegadoS);
            lvDel.setAdapter(adapter);

        }
        else{
            Toast.makeText(this, "No existen delegados registrados...",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
