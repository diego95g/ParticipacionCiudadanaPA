package ec.decc.espe.participacionciudadana;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by D4ve on 19/02/2018.
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table region(codigoReg INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombreReg text)");
        db.execSQL("create table provincia(codigoProv INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombreProv text)");
<<<<<<< HEAD
=======
<<<<<<< HEAD
        db.execSQL("create table parroquia(codigoParr INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombreParr text)");
        db.execSQL("create table canton(codigoCant INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombreCant text)");
=======
<<<<<<< HEAD
        db.execSQL("create table ciudadanos(codigoCiud INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, cedula text, nombreCiudadano text, residencia text)");
=======
<<<<<<< HEAD
>>>>>>> 23276f7124fc988f1583ba348c9d6387e82777fd
        db.execSQL("create table delegado(codigoDel INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,cedulaDel text,nombreDel text,telefonoDel text,tipoDel text)");
        db.execSQL("create table partido(codigoPartido INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombrePartido text)");
       db.execSQL("create table recinto(codigoRecinto INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombreRecinto text)");
<<<<<<< HEAD
=======
>>>>>>> 0d99a4a8ae8bba59fbe0f6e7f2d4f499bec660f2
>>>>>>> 5c8f600cdba8163d6668ed4cd4bcb1bb45d348e0
>>>>>>> ec1e3b002eaef0538820d690ddec152249a1149b
>>>>>>> 23276f7124fc988f1583ba348c9d6387e82777fd
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
