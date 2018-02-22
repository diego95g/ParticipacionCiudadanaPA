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
<<<<<<< HEAD
    public void parroquia(View view) {
        Intent i = new Intent(this, Parroquia.class );
        startActivity(i);
    }
    public void canton(View view) {
        Intent i = new Intent(this, Canton.class );
        startActivity(i);
    }
=======

    public void delegado(View view) {
        Intent i = new Intent(this, Delegado.class );
        startActivity(i);
    }


    public void partido(View view) {
        Intent i = new Intent(this, partido.class );
        startActivity(i);
    }
    public void recinto(View view) {
        Intent i = new Intent(this, partido.class );
        startActivity(i);
    }
<<<<<<< HEAD
=======
>>>>>>> 0d99a4a8ae8bba59fbe0f6e7f2d4f499bec660f2
>>>>>>> ec1e3b002eaef0538820d690ddec152249a1149b
>>>>>>> 23276f7124fc988f1583ba348c9d6387e82777fd
}
