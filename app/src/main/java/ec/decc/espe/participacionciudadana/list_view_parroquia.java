package ec.decc.espe.participacionciudadana;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class list_view_parroquia extends AppCompatActivity {

    private ListView listaVistaParroquia;
    private String[] parroquia = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_parroquia);

        listaVistaParroquia =(ListView)findViewById(R.id.listaParroquia);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "parroq", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //Cursor fila = bd.rawQuery( " select nombreReg from region " , null);
        String [] campos = {"nombreParr"};
        Cursor c = bd.query("parroquia", campos, null, null, null, null, null);
        if (c.moveToFirst()) {
            parroquia = new String[c.getCount()];
            int cont=0;
            do {
                parroquia[cont]= c.getString(0);
                cont=cont+1;
            } while(c.moveToNext());
        }
        bd.close();
        if(parroquia!=null){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,parroquia);
            listaVistaParroquia.setAdapter(adapter);}
        else{
            Toast.makeText(this, "Aun no existen parroquias registradas",
                    Toast.LENGTH_SHORT).show();

        }
    }
}
