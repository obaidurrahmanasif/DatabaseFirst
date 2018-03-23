package com.example.obaidurrahman.databasefirst;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saimon420420420 on 21/03/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    String table1="tbl_user";
    String t1column1="id";
    String t1column2="username";
    String t1column3="password";
    String t1column4="email";
    String table2="tbl_contacts";
    String t2column1="id";
    String t2column2="name";
    String t2column3="number";
    private String TAG="dblog";
    public DatabaseHelper(Context context) {
        super(context, "mydb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table "+table1;
          sql=sql+" ("+t1column1+" integer primary key autoincrement,";
        sql=sql+t1column2+" text,";
        sql=sql+t1column3+" text,";
        sql=sql+t1column4+" text)";
        Log.d(TAG,"sql "+sql);
        db.execSQL(sql);
         sql="create table "+table2;
        sql=sql+" ("+t2column1+" integer primary key autoincrement,";
        sql=sql+t2column2+" text,";
        sql=sql+t2column3+" integer)";
       db.execSQL(sql);
        Log.d(TAG,"sql "+sql);
    }

    public boolean insetContacts(Contacts contacts)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(t2column2,contacts.getName());
        values.put(t2column3,contacts.getNumber());
        Long res=db.insert(table2,null,values);
        db.close();

        if (res==-1)
            return false;
        else return true;
    }
    public List<Contacts> getContacts()
    {
        String sql="select * from "+table2;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor rs=db.rawQuery(sql,null);
        List<Contacts> contactsList=new ArrayList<Contacts>();
        while (rs.moveToNext())
        {
            int id=rs.getInt(0);
            String name=rs.getString(1);
            int number=rs.getInt(2);
            Contacts contacts=new Contacts(id,name,number);
            contactsList.add(contacts);
        }
        return contactsList;
    }

    public boolean createUser(UserModel userModel)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(t1column2,userModel.getUsername());
        values.put(t1column3,userModel.getPassword());
        values.put(t1column4,userModel.getEmail());
      Long result=  db.insert(table1,null,values);
      db.close();
      if(result==-1)
      {
          Log.d(TAG,"data not inserted!");
          return false;
      }
      else
          Log.d(TAG,"data inserted!!");
      return true;
    }
    public boolean islogin(UserModel userModel) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + table1 + " where " + t1column2 + " = " + userModel.getUsername() + " and " + t1column3 + " =" + userModel.getPassword();
       Cursor rs=db.rawQuery(sql,null);
       if(rs.getCount()>=1)
           return true;
//        if(db.rawQuery(sql,null)!=null)
//       {
//           db.close();
//           return true;
//       }
//       else {db.close();
//       return false;
        else
       return false;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql1="drop table if exists "+table1;
        String sql2="drop table if exists "+table2;
        db.execSQL(sql1);
        db.execSQL(sql2);
        onCreate(db);
    }
}
