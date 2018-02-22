package ec.decc.espe.participacionciudadana;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class list_view_canton extends AppCompatActivity {

    private ListView listaDeCantones;

    private String[] canton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_canton);
        listaDeCantones =(ListView)findViewById(R.id.listaCanton);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "cantar", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //Cursor fila = bd.rawQuery( " select nombreReg from region " , null);
        String [] campos = {"nombreCant"};
        Cursor c = bd.query("Canton", campos, null, null, null, null, null);
        if (c.moveToFirst()) {
            canton = new String[c.getCount()];
            int cont=0;
            do {
                canton[cont]= c.getString(0);
                cont=cont+1;
            } while(c.moveToNext());
        }
        bd.close();
        if(canton!=null){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,canton);
            listaDeCantones.setAdapter(adapter);}
        else{

            Toast.makeText(this, "Aun no existen cantones registrados",
                    Toast.LENGTH_SHORT).show();
        }

    }

}
