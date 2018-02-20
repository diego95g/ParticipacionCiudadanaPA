package ec.decc.espe.participacionciudadana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void provincia(View view) {
        Intent i = new Intent(this, Provincia.class );
        startActivity(i);
    }

    public void regions(View view) {
        Intent i = new Intent(this, Region_.class );
        startActivity(i);
    }

    public void ciudadano(View view) {
        Intent i = new Intent(this, FormCiudadano.class );
        startActivity(i);
    }

    public void delegado(View view) {
        Intent i = new Intent(this, Delegado.class );
        startActivity(i);
    }

}
