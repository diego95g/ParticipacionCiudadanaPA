package ec.decc.espe.participacionciudadana;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewRegion extends AppCompatActivity {
    private ListView lv1;

    private String[] region = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_region);
        lv1 =(ListView)findViewById(R.id.list);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "participacion1", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //Cursor fila = bd.rawQuery( " select nombreReg from region " , null);
        String [] campos = {"nombreReg"};
        Cursor c = bd.query("region", campos, null, null, null, null, null);
        if (c.moveToFirst()) {
            region = new String[c.getCount()];
            int cont=0;
            do {
                region[cont]= c.getString(0);
                cont=cont+1;
            } while(c.moveToNext());
        }
        bd.close();
        if(region!=null){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,region);
        lv1.setAdapter(adapter);}
        else{

            Toast.makeText(this, "Aun no existen regiones registradas",
                    Toast.LENGTH_SHORT).show();
        }

    }




}
