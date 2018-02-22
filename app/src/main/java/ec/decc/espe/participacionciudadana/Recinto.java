package ec.decc.espe.participacionciudadana;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Recinto extends AppCompatActivity {

    private EditText etRecinto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recinto);
        etRecinto = (EditText) findViewById(R.id.etRecinto);

    }
    public void guardarRecinto(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "baseRecinto", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String name = etRecinto.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("nombreRecinto", name);
        bd.insert("Recinto", null, registro);
        bd.close();
        Toast.makeText(this, "Se cargaron los datos del partido politico", Toast.LENGTH_SHORT).show();
    }


    public void listarRecinto(View view) {
        Intent i = new Intent(this, ListViewPartido.class );
        startActivity(i);
    }

    public void borrarRecinto(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "baseRecinto", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        bd.delete("Recinto", null, null);
        Toast.makeText(this, "Se han borrado todos los registros de la tabla recintos",
                Toast.LENGTH_SHORT).show();
        bd.close();
    }
}
