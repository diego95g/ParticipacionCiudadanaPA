package ec.decc.espe.participacionciudadana;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    public void guardarCiudadano(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "participacion1", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cedula = etCCedula.getText().toString();
        String  nombre= etCNombre.getText().toString();
        String  residencia= etCResidencia.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("ciu_cedula", cedula);
        bd.insert("ciudadano", null, registro);
        bd.close();
        Toast.makeText(this, "Se cargaron los datos del ciudadano",
                Toast.LENGTH_SHORT).show();
    }

    
}
