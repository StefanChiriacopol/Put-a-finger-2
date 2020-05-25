package com.example.putafingerdown;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String dbName = "Sets";

    //Sets table
    public static final String set_table = "Set_Table";
    public static final String col1 = "ID";
    public static final String col2 = "Set_Title";
    public static final String col3 = "Set_Number";
    public static final String col4 = "Handmade";
    public static final String col5 = "Background_Number";

    //Content table
    public static final String content_table = "Content_table";
    public static final String colBid = "ID";
    public static final String col1B = "Set_Title";
    public static final String col2B = "Set_Number";
    public static final String col3B = "Content_index";
    public static final String col4B = "Text";


    public Database(Context context) {
        super(context, dbName, null, 6);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + set_table + " ( " + col1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + col2 + " TEXT, " + col3 + " INTEGER, " + col4 + " TEXT, "+ col5 + " INTEGER)";
        String createTable2 = "CREATE TABLE " + content_table + " ( " + colBid + " INTEGER PRIMARY KEY AUTOINCREMENT, " + col1B + " TEXT, " + col2B + " INTEGER, " + col3B + " INTEGER, " + col4B + " TEXT)";
        db.execSQL(createTable);
        db.execSQL(createTable2);

        //titles
        String school = "School", family = "Family";

        //add data
        //c1
        ContentValues c1 = new ContentValues();
        c1.put(col2, school);
        c1.put(col3,1);
        c1.put(col5,5);
        c1.put(col4,"FALSE");
        db.insert(set_table,null,c1);

        //c2
        ContentValues c2 = new ContentValues();
        c2.put(col2, school);
        c2.put(col3,2);
        c2.put(col5,4);
        c2.put(col4,"FALSE");
        db.insert(set_table,null,c2);

        //c3
        ContentValues c3 = new ContentValues();
        c3.put(col2, school);
        c3.put(col3,3);
        c3.put(col5,6);
        c3.put(col4,"FALSE");
        db.insert(set_table,null,c3);

        //c4
        ContentValues c4 = new ContentValues();
        c4.put(col2, family);
        c4.put(col3,1);
        c4.put(col5,3);
        c4.put(col4,"FALSE");
        db.insert(set_table,null,c4);

        //c5
        ContentValues c5 = new ContentValues();
        c5.put(col2, family);
        c5.put(col3,2);
        c5.put(col5,1);
        c5.put(col4,"FALSE");
        db.insert(set_table,null,c5);

        //c6
        ContentValues c6 = new ContentValues();
        c6.put(col2, family);
        c6.put(col3,3);
        c6.put(col5,2);
        c6.put(col4,"FALSE");
        db.insert(set_table,null,c6);


        //add Content in every Set


        //set School 1

        // b1
        ContentValues b1 = new ContentValues();
        b1.put(col1B,school);
        b1.put(col2B,1);
        b1.put(col4B,"you stayed until 4am to study");
        db.insert(content_table,null,b1);

        // b2
        ContentValues b2 = new ContentValues();
        b2.put(col1B,school);
        b2.put(col2B,1);
        b2.put(col4B,"");
        db.insert(content_table,null,b2);

        // b3
        ContentValues b3 = new ContentValues();
        b3.put(col1B,school);
        b3.put(col2B,1);
        b3.put(col4B,"");
        db.insert(content_table,null,b3);

        // b4
        ContentValues b4 = new ContentValues();
        b4.put(col1B,school);
        b4.put(col2B,1);
        b4.put(col4B,"");
        db.insert(content_table,null,b4);

        // b5
        ContentValues b5 = new ContentValues();
        b5.put(col1B,school);
        b5.put(col2B,1);
        b5.put(col4B,"");
        db.insert(content_table,null,b5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + set_table);
        db.execSQL("DROP TABLE IF EXISTS " + content_table);
        onCreate(db);
    }

    //Set Table

    public boolean addSetTableData(String title, int number, boolean isHandmade, int background_number) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, title);
        contentValues.put(col3, number);
        contentValues.put(col5,background_number);

        if(isHandmade){
            contentValues.put(col4,"TRUE");
        } else {
            contentValues.put (col4, "FALSE");
        }

        long result = db.insert(set_table, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getSetTableData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + set_table, null);
        return data;
    }

}
