package ec.decc.espe.participacionciudadana;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Delegado extends AppCompatActivity {

    private EditText txtCedula;
    private EditText txtNombre;
    private EditText txtTelefono;
    private EditText txtTipoDel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delegado);
        txtCedula=(EditText)findViewById(R.id.txtCedula);
        txtNombre =(EditText)findViewById(R.id.txtNombre);
        txtTelefono =(EditText)findViewById(R.id.txtTelefono);
        txtTipoDel =(EditText)findViewById(R.id.txtTipoDel);
    }

    public void guardar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"partici", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cedula = txtCedula.getText().toString();
        String nombre = txtNombre.getText().toString();
        String telefono = txtTelefono.getText().toString();
        String tipo = txtTipoDel.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("cedulaDel", cedula);
        registro.put("nombreDel", nombre);
        registro.put("telefonoDel", telefono);
        registro.put("tipoDel", tipo);
        bd.insert("delegado", null, registro);
        bd.close();
        Toast.makeText(this, "Delegado Almacenado Correctamente",Toast.LENGTH_SHORT).show();
    }
    public void listaProvincias(View view) {
        Intent i = new Intent(this, ListViewDelegado.class );
        startActivity(i);
    }

    public void delete(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "partici", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        //Cursor fila = bd.rawQuery( "DELETE FROM provincia", null);
        bd.delete("delegado", null, null);
        Toast.makeText(this, "Se han borrado todos los registros de Delegados",
                Toast.LENGTH_SHORT).show();
        bd.close();
    }
}