package quanlilophoc.android.vn.quanlilophoc.Adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_student";
    public static final String TABLE_NAME = "student";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_NUMBER = "number";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_IMAGE = "image";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String creatTableStudent = "CREAT TABLE" + TABLE_NAME + "("
                + KEY_ID + "INTEGER PRIMARYKEY  AUTOINCREMENT NOT NULL"
                + KEY_NAME + " TEXT NOT NULL,"
                + KEY_NUMBER + " INTEGER NOT NULL,"
                + KEY_ADDRESS + " VARCHAR NOT NULL,"
                + KEY_IMAGE + " BLOB NOT NULL" +
                ")";
        db.execSQL(creatTableStudent);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS" + TABLE_NAME);
        onCreate(db);
    }
}
