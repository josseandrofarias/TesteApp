package jfarias.unigran.br.testeapp.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper{

    public Banco(Context context) {
        super(context, "BANCODADOS", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS PESSOA(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "NOME VARCHAR(45)," +
                "IDADE INTEGER," +
                "SOBRENOME VARCHAR(45))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
