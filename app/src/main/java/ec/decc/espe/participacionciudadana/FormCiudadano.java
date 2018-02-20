package ec.decc.espe.participacionciudadana;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FormCiudadano extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ciudadano);
    }
    public void alta(View v) {
       /* AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
       String cod = etC1.getText().toString();
        String proov= etC2.getText().toString();
        String pre = etC3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("proveedor", proov);
        registro.put("precio", pre);
        bd.insert("proveedor", null, registro);
        bd.close();
        etC1.setText("");
        etC2.setText("");
        etC3.setText("");
        Toast.makeText(this, "Se cargaron los datos del proveedor",
                Toast.LENGTH_SHORT).show();
               */
    }
}
