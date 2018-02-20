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
        db.execSQL("create table parroquia(codigoParr INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombreParr text)");
        db.execSQL("create table canton(codigoCant INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombreCant text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
