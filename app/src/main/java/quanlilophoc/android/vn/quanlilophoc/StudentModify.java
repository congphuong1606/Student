package quanlilophoc.android.vn.quanlilophoc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import quanlilophoc.android.vn.quanlilophoc.Adapter.DBHelper;

/**
 * Created by MyPC on 24/06/2017.
 */

public class StudentModify {
    DBHelper dbHelper;
    private SQLiteDatabase db;
    private ContentValues values;


    public StudentModify(Context context) {
        dbHelper = new DBHelper(context);
    }
//phương thức thêm database
    public void insert(Student student) {
        db = dbHelper.getWritableDatabase();//mở kết nốidatabasse
        values = new ContentValues();
        values.put(DBHelper.KEY_ID,student.getId());
        values.put(DBHelper.KEY_NAME,student.getName());
        values.put(DBHelper.KEY_NUMBER,student.getNumber());
        values.put(DBHelper.KEY_ADDRESS,student.getAddress());
        values.put(DBHelper.KEY_IMAGE,student.getImage());
        db.insert(DBHelper.TABLE_NAME,null,values);
        db.close();//đóng  kết nối database
    }
    //pt sửa database
    public void update(Student student){
        db=dbHelper.getWritableDatabase();
        values = new ContentValues();
        values.put(DBHelper.KEY_ID,student.getId());
        values.put(DBHelper.KEY_NAME,student.getName());
        values.put(DBHelper.KEY_NUMBER,student.getNumber());
        values.put(DBHelper.KEY_ADDRESS,student.getAddress());
        values.put(DBHelper.KEY_IMAGE,student.getImage());
        db.update(DBHelper.TABLE_NAME,values,DBHelper.KEY_ID+"=?",
                new String[]{String.valueOf(student.getId())});
        db.close();
    }
    //pt xóa database
    public void delete(int id){
        db=dbHelper.getWritableDatabase();
        db.delete(DBHelper.TABLE_NAME,DBHelper.KEY_ID+"=?",
                new String[]{String.valueOf(id)});
        db.close();
    }
    //lấy 1 dữ liệu
    public Student getStudent(int id){
        db=dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_NAME,
                new String[]{DBHelper.KEY_ID,DBHelper.KEY_NAME,DBHelper.KEY_NUMBER,DBHelper.KEY_ADDRESS,DBHelper.KEY_IMAGE}
                ,DBHelper.KEY_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return new Student(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getBlob(4));
    }
    //lấy toàn bộ list student
    public Cursor getAllStudent(){
        db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query(DBHelper.TABLE_NAME,
                new String[]{DBHelper.KEY_ID,DBHelper.KEY_NAME,DBHelper.KEY_NUMBER,DBHelper.KEY_ADDRESS,DBHelper.KEY_IMAGE}
                ,null,null,null,null,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
