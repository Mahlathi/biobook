package com.example.biobook.conf;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Davinci on 17/08/2014.
 */
public class DBAdapter extends SQLiteOpenHelper {

    public static final String TABLE_STUDENTS = "students";
    public static final String TABLE_ADDRESS = "address";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "col_name";
    public static final String COLUMN_SURNAME = "col_surname";
    public static final String COLUMN_EMAIL = "col_email";
    public static final String COLUMN_CELL = "col_cell";
    public static final String COLUMN_STREET_NO = "col_street_no";
    public static final String COLUMN_STREET_NAME = "col_street_name";
    public static final String COLUMN_TOWN = "col_town";
    public static final String COLUMN_POSTAL_CODE = "col_postal";


    public static final String DATABASE_NAME = "xample.db";
    public static final int DATABASE_VERSION = 2;

    public static final String CREATE_STUDENTS_TABLE = " create table IF NOT EXISTS "
                                                        + TABLE_STUDENTS + " ( "
                                                        + COLUMN_ID + " integer primary key autoincrement, "
                                                        + COLUMN_NAME + " text not null, "
                                                        + COLUMN_SURNAME + " text not null, "
                                                        + COLUMN_EMAIL + " text not null, "
                                                        + COLUMN_CELL + " text not null ); ";


    public static final String CREATE_ADDRESS_TABLE = " create table IF NOT EXISTS "
                                                        + TABLE_ADDRESS + " ( "
                                                        + COLUMN_ID + " integer primary key autoincrement, "
                                                        + COLUMN_STREET_NO + " text not null, "
                                                        + COLUMN_STREET_NAME + " text not null, "
                                                        + COLUMN_TOWN + " text not null, "
                                                        + COLUMN_POSTAL_CODE + " text not null ); ";

    public DBAdapter(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_STUDENTS_TABLE);
            sqLiteDatabase.execSQL(CREATE_ADDRESS_TABLE);



        }catch( Exception e )
        {
            System.out.println( "Error at adapter" + e.getStackTrace() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            Log.w(DBAdapter.class.getName(), "Upgrading database from version" + oldVersion + "to" + newVersion + "which will destroy all old data");
            sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_STUDENTS );
            sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_ADDRESS );


            onCreate(sqLiteDatabase);
    }
}
