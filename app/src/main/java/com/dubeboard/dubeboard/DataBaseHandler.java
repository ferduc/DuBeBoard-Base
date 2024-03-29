package com.dubeboard.dubeboard;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 07/02/2016.
 */
public class DataBaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "imagedb";

    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_CATEGORY = "category";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_CATEGORY + " INTEGER,"
                + KEY_IMAGE + " BLOB" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    public// Adding new contact
    void addContact(Imagenes imagenes) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, imagenes._name); // Contact Name
        values.put(KEY_CATEGORY, imagenes._category); // Contact Name
        values.put(KEY_IMAGE, imagenes._image); // Contact Phone

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Imagenes getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]
                        {
                                KEY_ID,
                                KEY_NAME,
                                KEY_CATEGORY,
                                KEY_IMAGE
                        }
                , KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Imagenes imagenes = new Imagenes(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)), cursor.getBlob(3));

        // return contact
        return imagenes;

    }

    // Getting All Contacts
    public List<Imagenes> getAllContacts() {
        List<Imagenes> contactList = new ArrayList<Imagenes>();
        // Select All Query
        String selectQuery = "SELECT id, name, category, image FROM contacts ORDER BY name ASC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Imagenes imagenes = new Imagenes();
                imagenes.setID(Integer.parseInt(cursor.getString(0)));
                imagenes.setName(cursor.getString(1));
                imagenes.setCategory(Integer.parseInt(cursor.getString(2)));
                imagenes.setImage(cursor.getBlob(3));
                // Adding contact to list
                contactList.add(imagenes);
            } while (cursor.moveToNext());
        }
        // close inserting data from database
        db.close();
        // return contact list
        return contactList;

    }

    public List<Imagenes> getAllContactsByCategory(int Category) {
        List<Imagenes> contactList = new ArrayList<Imagenes>();
        // Select All Query
        String selectQuery = "SELECT id, name, category, image FROM contacts WHERE category = " + Category + " ORDER BY name ASC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Imagenes imagenes = new Imagenes();
                imagenes.setID(Integer.parseInt(cursor.getString(0)));
                imagenes.setName(cursor.getString(1));
                imagenes.setCategory(Integer.parseInt(cursor.getString(2)));
                imagenes.setImage(cursor.getBlob(3));
                // Adding contact to list
                contactList.add(imagenes);
            } while (cursor.moveToNext());
        }
        // close inserting data from database
        db.close();
        // return contact list
        return contactList;

    }

    // Updating single contact
    public int updateContact(Imagenes imagenes) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, imagenes.getName());
        values.put(KEY_IMAGE, imagenes.getImage());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(imagenes.getID()) });

    }

    public int updateCategory(int category, String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY, category);

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_NAME + " = ?",
                new String[] { String.valueOf(nombre) });
    }

    // Deleting single contact
    public void deleteContact(Imagenes imagenes) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(imagenes.getID()) });
        db.close();
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}