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

public class Region_ extends AppCompatActivity {
    private EditText etRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_);
        etRegion=(EditText)findViewById(R.id.etRegion);
    }

    public void guardar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "participacion1", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String name = etRegion.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("nombreReg", name);
        bd.insert("region", null, registro);
        bd.close();
        Toast.makeText(this, "Se cargaron los datos de la region",
                Toast.LENGTH_SHORT).show();
    }

    public void consultapordescripcion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "participacion1", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String descri = etRegion.getText().toString();
        Cursor fila = bd.rawQuery(
                "select codigoReg,nombreReg from region where nombreReg='" + descri +"'", null);
        if (fila.moveToFirst()) {
            etRegion.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe una region con dicho nombre",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void listaRegiones(View view) {
        Intent i = new Intent(this, ListViewRegion.class );
        startActivity(i);
    }
    public void delete(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "participacion1", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        //Cursor fila = bd.rawQuery( "DELETE FROM provincia", null);
        bd.delete("region", null, null);
        Toast.makeText(this, "Se han borrado todos los registros de la tabla region",
                Toast.LENGTH_SHORT).show();
        bd.close();
    }
}
