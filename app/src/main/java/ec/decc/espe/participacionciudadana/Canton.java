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

public class Canton extends AppCompatActivity {
    private EditText etCanton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canton);
        etCanton=(EditText)findViewById(R.id.etCanton);
    }
    public void guardar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "cantar", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String name = etCanton.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("nombreCant", name);
        bd.insert("canton", null, registro);
        bd.close();
        Toast.makeText(this, "Se cargaron los datos de la canton",
                Toast.LENGTH_SHORT).show();
    }

    public void consultapordescripcion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "cantar", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String descri = etCanton.getText().toString();
        Cursor fila = bd.rawQuery(
                "select codigoCant,nombreCant from canton where nombreCant='" + descri +"'", null);
        if (fila.moveToFirst()) {
            etCanton.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un canton con dicho nombre",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
    public void listaCanton(View view) {
        Intent i = new Intent(this, list_view_canton.class );
        startActivity(i);
    }
    public void delete(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "cantar", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        //Cursor fila = bd.rawQuery( "DELETE FROM provincia", null);
        bd.delete("canton", null, null);
        Toast.makeText(this, "Se han borrado todos los registros de la tabla canton",
                Toast.LENGTH_SHORT).show();
        bd.close();
    }
}
