package com.example.biobook.repository.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.biobook.conf.DBAdapter;
import com.example.biobook.domain.Address;
import com.example.biobook.domain.Student;
import com.example.biobook.repository.addressDatasourceDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhona on 2014/08/19.
 */
public class addressDatasourceDAOImpl implements addressDatasourceDAO {

    private SQLiteDatabase db;
    private DBAdapter dbhelper;

    public addressDatasourceDAOImpl(Context context)
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
    public void createAddress(Address address) {
        try
        {
            open();
            ContentValues values = new ContentValues();
            values.put(DBAdapter.COLUMN_STREET_NO, address.getStreet_number());
            values.put(DBAdapter.COLUMN_STREET_NAME, address.getStreet_name());
            values.put(DBAdapter.COLUMN_TOWN, address.getTown());
            values.put(DBAdapter.COLUMN_POSTAL_CODE, address.getPostal_code());

            db.insert(DBAdapter.TABLE_ADDRESS, null, values );
            close();
        }catch(SQLException e)
        {
            System.out.println( "Helper error" + e.getStackTrace() );
        }
    }

    @Override
    public void updateAddress(Address address) {
        try {
            open();
            ContentValues values = new ContentValues();
            values.put(DBAdapter.COLUMN_STREET_NO, address.getStreet_number() );
            values.put(DBAdapter.COLUMN_STREET_NAME, address.getStreet_name());
            values.put(DBAdapter.COLUMN_TOWN, address.getTown());
            values.put(DBAdapter.COLUMN_POSTAL_CODE, address.getPostal_code());

            db.update(DBAdapter.TABLE_ADDRESS, values, DBAdapter.COLUMN_STREET_NO + " = ? " ,
                    new String[]{ String.valueOf(address.getStreet_number())} );
            close();
        }catch(SQLException e)
        {
            System.out.println( "Helper error" + e.getStackTrace() );
        }
    }

    @Override
    public Address findAddressById(int id) {
        return null;
    }

    @Override
    public void deleteAddress(Address address) {
        try {
            open();
                db.delete(DBAdapter.TABLE_ADDRESS, DBAdapter.COLUMN_STREET_NO + " = ? " ,
                        new String[]{ String.valueOf(address.getStreet_number())});
            close();
        }catch(SQLException e)
        {
            System.out.println( "Helper error" + e.getStackTrace() );
        }
    }


    @Override
    public Address getAddress() {
        Address address = new Address.Builder(" ").street_name(" ").town(" ").postal_code(" ").build();
        try {
            String selectQuery = "SELECT  * FROM " + DBAdapter.TABLE_ADDRESS;


            open();
            Cursor c = db.rawQuery(selectQuery, null);

            if (c.moveToFirst()) {
                do {
                    address = new Address.Builder(c.getString(1))
                            .street_name(c.getString(2))
                            .town(c.getString(3))
                            .postal_code(c.getString(4))
                            .id(c.getInt(0))
                            .build();


                } while (c.moveToNext());


            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        close();
        return address;
    }

    @Override
    public List<Address> getAddressList() {
        List<Address> studs = new ArrayList<Address>();




        try {
            String selectQuery = "SELECT * FROM " + DBAdapter.TABLE_ADDRESS;

            open();
            Cursor c = db.rawQuery(selectQuery, null);

            if( c.moveToFirst()) {
                do {
                    Address stad = new Address.Builder(c.getString(1))
                            .id(c.getInt(0))
                            .postal_code(c.getString(2))
                            .street_name(c.getString(4))
                            .town(c.getString(3))
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


