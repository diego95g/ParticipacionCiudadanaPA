package ec.decc.espe.participacionciudadana;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewRecinto extends AppCompatActivity {

    private ListView lv3;
    private String[] recin = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_recinto);

    lv3 =(ListView)findViewById(R.id.lista);

    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"baseRecinto", null, 1);
    SQLiteDatabase bd = admin.getWritableDatabase();
    String[] campos = {"nombreRecinto"};
    Cursor c = bd.query("Recinto", campos, null, null, null, null, null);
        if(c.moveToFirst())
    {
        recin = new String[c.getCount()];
        int cont = 0;
        do {
            recin[cont] = c.getString(0);
            cont = cont + 1;
        } while (c.moveToNext());
    }
        bd.close();
        if(recin!=null)

    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recin);
        lv3.setAdapter(adapter);
    }
        else

    {
        Toast.makeText(this, "No existen recintos registrados",
                Toast.LENGTH_SHORT).show();

    }
}
}
