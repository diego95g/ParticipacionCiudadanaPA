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

public class Parroquia extends AppCompatActivity {
    private EditText etParroquia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parroquia);
        etParroquia=(EditText)findViewById(R.id.etParroquia);
    }
    public void guardar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "parroq", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String name = etParroquia.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("nombreParr", name);
        bd.insert("parroquia", null, registro);
        bd.close();
        Toast.makeText(this, "Se cargaron los datos de la parroquia",
                Toast.LENGTH_SHORT).show();
    }

    public void consultapordescripcion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "parroq", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String descri = etParroquia.getText().toString();
        Cursor fila = bd.rawQuery(
                "select codigoParr,nombreParr from parroquia where nombreParr='" + descri +"'", null);
        if (fila.moveToFirst()) {
            etParroquia.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe una parroquia con dicho nombre",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
    public void listaParroquia(View view) {
        Intent i = new Intent(this, list_view_parroquia.class );
        startActivity(i);
    }
    public void delete(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "parroq", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        //Cursor fila = bd.rawQuery( "DELETE FROM provincia", null);
        bd.delete("parroquia", null, null);
        Toast.makeText(this, "Se han borrado todos los registros de la tabla parroquia",
                Toast.LENGTH_SHORT).show();
        bd.close();
    }
}
