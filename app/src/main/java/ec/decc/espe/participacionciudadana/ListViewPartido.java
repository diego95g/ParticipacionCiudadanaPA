package ec.decc.espe.participacionciudadana;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewPartido extends AppCompatActivity {

    private ListView lv2;

    private String[] parti = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_partido);


    lv2 =(ListView)findViewById(R.id.lista);

    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"basepartido", null, 1);
    SQLiteDatabase bd = admin.getWritableDatabase();
    String[] campos = {"nombrePartido"};
    Cursor c = bd.query("partido", campos, null, null, null, null, null);
        if(c.moveToFirst())
    {
        parti = new String[c.getCount()];
        int cont = 0;
        do {
            parti[cont] = c.getString(0);
            cont = cont + 1;
        } while (c.moveToNext());
    }
        bd.close();
        if(parti!=null)

    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, parti);
        lv2.setAdapter(adapter);
    }
        else

    {
        Toast.makeText(this, "No existen partidos registrados",
                Toast.LENGTH_SHORT).show();

    }
}
}
