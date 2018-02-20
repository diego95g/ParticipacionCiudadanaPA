package ec.decc.espe.participacionciudadana;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class partido extends AppCompatActivity {

    private EditText etPartido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido);
        etPartido=(EditText)findViewById(R.id.etRecinto);
    }

    public void guardarPartido(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "basepartido", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String name = etPartido.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("nombrePartido", name);
        bd.insert("partido", null, registro);
        bd.close();
        Toast.makeText(this, "Se cargaron los datos del partido politico", Toast.LENGTH_SHORT).show();
    }


    public void listaPartido(View view) {
        Intent i = new Intent(this, ListViewPartido.class );
        startActivity(i);
    }

    public void deletePartido(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "basepartido", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        bd.delete("partido", null, null);
        Toast.makeText(this, "Se han borrado todos los registros de la tabla partidos",
                Toast.LENGTH_SHORT).show();
        bd.close();
    }




}
