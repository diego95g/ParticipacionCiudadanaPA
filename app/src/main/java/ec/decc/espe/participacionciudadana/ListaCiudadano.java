package ec.decc.espe.participacionciudadana;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaCiudadano extends AppCompatActivity {

    private ListView lv1;

    private String[] ciudadano = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ciudadano);
        /*lv1 =(ListView)findViewById(R.id.listaCiu);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "ciudadano", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //Cursor fila = bd.rawQuery( " select nombreReg from region " , null);
        String [] campos = {"nombreCiud"};
        Cursor c = bd.query("ciudadano", campos, null, null, null, null, null);
        if (c.moveToFirst()) {
            ciudadano = new String[c.getCount()];
            int cont=0;
            do {
                ciudadano[cont]= c.getString(0);
                cont=cont+1;
            } while(c.moveToNext());
        }
        bd.close();
        if(ciudadano!=null){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ciudadano);
            lv1.setAdapter(adapter);}
        else{

            Toast.makeText(this, "Aun no existen ciudadanos registrados",
                    Toast.LENGTH_SHORT).show();
        }
}*/
    }}