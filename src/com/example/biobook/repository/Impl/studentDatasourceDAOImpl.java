package com.example.biobook.repository.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.biobook.conf.DBAdapter;
import com.example.biobook.domain.Student;
import com.example.biobook.repository.studentDatasourceDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davinci on 17/08/2014.
 */
public class studentDatasourceDAOImpl implements studentDatasourceDAO {

    private SQLiteDatabase db;
    private DBAdapter dbhelper;

    public studentDatasourceDAOImpl(Context context)
    {
        dbhelper = new DBAdapter(context);
    }

    public void open() throws SQLException
    {
        db = dbhelper.getWritableDatabase();
    }

    public void close()
    {
        dbhelper.close();
    }

    @Override
    public void createStudent(Student stud)
    {
        try
        {
            open();
            ContentValues values = new ContentValues();
            values.put(DBAdapter.COLUMN_NAME, stud.getStud_name());
            values.put(DBAdapter.COLUMN_SURNAME, stud.getStud_last());
            values.put(DBAdapter.COLUMN_EMAIL, stud.getStud_mail());
            values.put(DBAdapter.COLUMN_CELL, stud.getStud_cell());

            db.insert(DBAdapter.TABLE_STUDENTS, null, values );
            close();
        }catch(SQLException e)
        {
            System.out.println( "Helper error" + e.getStackTrace() );
        }
    }

    @Override
    public void updateStudent(Student stud) {

    }

    @Override
    public Student findStudentById(int id) {
        return null;
    }

    @Override
    public void deleteStudent(Student stud) {

    }

    @Override
    public Student getStudent() {
        Student stud = new Student.Builder(" ").lastname(" ").email(" ").cell(" ").build();
        try {
            String selectQuery = "SELECT  * FROM " + DBAdapter.TABLE_STUDENTS;


            open();
            Cursor c = db.rawQuery(selectQuery, null);

            if (c.moveToFirst()) {
                do {
                    stud = new Student.Builder(c.getString(1))
                            .lastname(c.getString(2))
                            .email(c.getString(3))
                            .cell(c.getString(4))
                            .id(c.getInt(0))
                            .build();

                } while (c.moveToNext());


            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        close();
        return stud;
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> studs = new ArrayList<Student>();




            try {
                String selectQuery = "SELECT * FROM " + DBAdapter.TABLE_STUDENTS;

                open();
                Cursor c = db.rawQuery(selectQuery, null);

            if( c.moveToFirst()) {
                do {
                    Student stad = new Student.Builder(c.getString(1))
                            .id(c.getInt(0))
                            .lastname(c.getString(2))
                            .cell(c.getString(4))
                            .email(c.getString(3))
                            .build();
                    studs.add(stad);
                } while (c.moveToNext());

            }

            }
        catch(SQLException e)
        {
            e.getStackTrace();
        }
            close();



        return studs;
    }

}
