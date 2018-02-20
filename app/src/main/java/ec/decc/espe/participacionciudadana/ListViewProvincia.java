package ec.decc.espe.participacionciudadana;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewProvincia extends AppCompatActivity {
    private ListView lv1;

    private String[] provincia = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_provincia);

       lv1 =(ListView)findViewById(R.id.lista);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "participacion1", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //Cursor fila = bd.rawQuery( " select nombreReg from region " , null);
        String [] campos = {"nombreProv"};
        Cursor c = bd.query("provincia", campos, null, null, null, null, null);
        if (c.moveToFirst()) {
            provincia = new String[c.getCount()];
            int cont=0;
            do {
                provincia[cont]= c.getString(0);
                cont=cont+1;
            } while(c.moveToNext());
        }
        bd.close();
        if(provincia!=null){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,provincia);
        lv1.setAdapter(adapter);}
        else{
            Toast.makeText(this, "Aun no existen provincias registradas",
                    Toast.LENGTH_SHORT).show();

        }
    }
}
