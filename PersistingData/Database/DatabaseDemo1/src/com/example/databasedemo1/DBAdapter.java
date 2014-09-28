package com.example.databasedemo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {
	
	static final String KEY_ROWID = "_id";
	static final String KEY_NAME = "name";
	static final String KEY_EMAIL = "email";
	
	SQLiteDatabase db;
	DBHelper dbHelper;
	final Context context;
	
	public DBAdapter(Context ctx){
		this.context = ctx;
		dbHelper = new DBHelper(context); 
	}
	
	public DBAdapter open(){
		db = dbHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public long insertContact(String name, String email){
		ContentValues initValues = new ContentValues();
		initValues.put(KEY_NAME, name);
		initValues.put(KEY_EMAIL, email);
		return db.insert(dbHelper.DATABASE_NAME, null, initValues);
	}

}
