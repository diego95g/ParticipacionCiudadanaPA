package ec.decc.espe.participacionciudadana;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormCiudadano extends AppCompatActivity {

    private EditText etCCedula;
    private EditText etCNombre;
    private EditText etCResidencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ciudadano);
        etCCedula=(EditText)findViewById(R.id.etCCedula);
        etCNombre=(EditText)findViewById(R.id.etCNombre);
        etCResidencia=(EditText)findViewById(R.id.etCResidencia);

    }
    public void guardar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "votacion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cedula = etCCedula.getText().toString();
        String name = etCNombre.getText().toString();
        String residencia = etCResidencia.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("cedula", cedula);
        registro.put("nombreCiudadano", name);
        registro.put("residencia", residencia);
        bd.insert("ciudadanos", null, registro);
        bd.close();
        Toast.makeText(this, "Se cargaron los datos del ciudadano",
                Toast.LENGTH_SHORT).show();
    }



    public void listaCiud(View view) {
        Intent i = new Intent(this, ListViewCiudadano.class );
        startActivity(i);
    }

    public void delete(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "votacion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        //Cursor fila = bd.rawQuery( "DELETE FROM provincia", null);
        bd.delete("ciudadanos", null, null);
        Toast.makeText(this, "Se han borrado todos los registros de ciudadanos",
                Toast.LENGTH_SHORT).show();
        bd.close();
    }

    
}
