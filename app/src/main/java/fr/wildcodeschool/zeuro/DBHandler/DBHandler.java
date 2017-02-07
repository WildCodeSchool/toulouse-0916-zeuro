package fr.wildcodeschool.zeuro.DBHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.util.ArrayList;


public class DBHandler extends SQLiteOpenHelper implements Serializable {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    /**
     * Class to communicate with database
     */
    public DBHandler(Context context) {
        super(context, "databaselite.sqlite", null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void openDatabase() {
        String dbPath = mContext.getDatabasePath("databaselite.sqlite").getPath();
        if (mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);

    }
    public void closeDatabase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    public ArrayList<Integer[]> getsavesseekbar(){
        //init model
        Integer[] value;
        ArrayList<Integer[]> valueseekbar = new ArrayList<>();

        openDatabase();
        // init rawQuery in cursor
        Cursor cursor = mDatabase.rawQuery("SELECT min_value, max_value FROM Seekbarsaves ORDER BY id", null);
        // read database with cursor
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            value = new Integer[]{cursor.getInt(0),cursor.getInt(1)};
            valueseekbar.add(value);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return valueseekbar;
    }

    //save exercice
    public void setValueMinEtMax(int id, int min, int max) {
        //activate writing
        SQLiteDatabase db = this.getWritableDatabase();
        // new data value
        ContentValues values = new ContentValues();
        values.put("min_value", min);
        values.put("max_value", max);
        //select line and update
        String strSQL = "id = " + id ;
        db.update("Seekbarsaves", values, strSQL, null);
        db.close();
    }
}