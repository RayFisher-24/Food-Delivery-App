package com.application.fooddelivery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.application.fooddelivery.Modelss.OrdersModel;

import java.util.ArrayList;

public class DBhalper extends SQLiteOpenHelper {

    final static String DBNAME = "foodatabase.db";
    final static int DBVERSION = 1;

    public DBhalper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE orders " +
                "(id integer primary key autoincrement," +
                "person_name text,"+                            /*id=0 name=1, phone=2, quan=3, price=4, image=5, desc=6, foodname=7*/
                "person_phone text,"+
                "food_quantity int,"+
                "food_price int,"+
                "food_image int,"+
                "food_description text,"+
                "food_name text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists orders");
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc, String foodName, int quantity){

       SQLiteDatabase database=getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("person_name",name);
        values.put("person_phone",phone);
        values.put("food_name",foodName);
        values.put("food_price",price);
        values.put("food_description",desc);
        values.put("food_image",image);
        values.put("food_quantity", quantity);

        long id=database.insert("orders", null, values);

        return id > 0;
    }
    public ArrayList<OrdersModel> getOrders(){
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select id, food_name, food_price, food_image from orders",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(1));
                model.setPrice(cursor.getInt(2)+"");
                model.setOrderImage(cursor.getInt(3));
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }

    public Cursor getOrderById(int id){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select * from orders where id= "+id,null);

        if(cursor!=null){
            cursor.moveToFirst();
        }

        return  cursor;
    }
    public boolean updateOrder(String name, String phone, int price, int image, String desc, String foodName, int quantity, int id){

        SQLiteDatabase database=getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put("person_name",name);
        values.put("person_phone",phone);
        values.put("food_name",foodName);
        values.put("food_price",price);
        values.put("food_description",desc);
        values.put("food_image",image);
        values.put("food_quantity", quantity);

        long row=database.update("orders", values, "id="+id, null);

        return row > 0;
    }
    public int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders", "id="+id, null);
    }
}
