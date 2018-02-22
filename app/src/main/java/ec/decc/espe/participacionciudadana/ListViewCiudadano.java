package ec.decc.espe.participacionciudadana;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewCiudadano extends AppCompatActivity {
    private ListView lvC;

    private String[] ciud = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_ciudadano);
        lvC =(ListView)findViewById(R.id.listaCiu);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "votacion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //Cursor fila = bd.rawQuery( " select nombreReg from region " , null);
        String [] campos = {"nombreCiudadano"};
        Cursor c = bd.query("ciudadanos", campos, null, null, null, null, null);
        if (c.moveToFirst()) {
            ciud = new String[c.getCount()];
            int cont=0;
            do {
                ciud[cont]= c.getString(0);
                cont=cont+1;
            } while(c.moveToNext());
        }

        if(ciud!=null) {

            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ciud);
            lvC.setAdapter(adapter2);
        }
        else{
            Toast.makeText(this, "Aun no existen ciudadanos registrados",
                    Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }
}
