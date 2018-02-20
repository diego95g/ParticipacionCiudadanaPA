package ec.decc.espe.participacionciudadana;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Provincia extends AppCompatActivity {
    private EditText etProvincia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provincia);
        etProvincia=(EditText)findViewById(R.id.etRecinto);
    }

    public void guardar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "participacion1", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String name = etProvincia.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("nombreProv", name);
        bd.insert("provincia", null, registro);
        bd.close();
        Toast.makeText(this, "Se cargaron los datos de la provincia",
                Toast.LENGTH_SHORT).show();
    }

    public void consultapordescripcion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "participacion1", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String descri = etProvincia.getText().toString();
        Cursor fila = bd.rawQuery(
                "select codigoProv,nombreProv from provincia where nombreProv='" + descri +"'", null);
        if (fila.moveToFirst()) {
            etProvincia.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe una provincia con dicho nombre",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
    public void listaProvincias(View view) {
        Intent i = new Intent(this, ListViewProvincia.class );
        startActivity(i);
    }
    public void delete(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "participacion1", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        //Cursor fila = bd.rawQuery( "DELETE FROM provincia", null);
        bd.delete("provincia", null, null);
        Toast.makeText(this, "Se han borrado todos los registros de la tabla provincia",
                Toast.LENGTH_SHORT).show();
        bd.close();
    }

}
