package com.example.project;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
	private static final String DBNAME = "meuDB";
	private DataBaseHelper myDBHelper;
	private SQLiteDatabase myDB;
	public static DataBaseHelper instance;
//	private final Context myContext;
	
	public DataBaseHelper(Context context){
		super(context, DBNAME, null, 2);
//		this.myContext = context;
	}
	@Override
	public void onCreate(SQLiteDatabase db){
		
		db.execSQL("create table if not exists cliente("+
         "id integer primary key autoincrement,"+
         "registro text not null," +      
         "nome text not null," +      
         "contato text not null,"+       
         "endereco text not null," +      
         "complemento text not null,"+       
         "cidade text not null," +      
         "estado text not null,"+       
         "cep text not null," +      
         "fone text not null,"+       
         "fax text not null," +      
         "email text not null,"+       
         "clifor text);");
		
		db.execSQL("create table if not exists produtos("+
         "id integer primary key autoincrement,"+        
         "descricao text not null," +      
         "valor_unitario float not null,"+       
         "quantidade int not null);");
		
		db.execSQL("create table if not exists vendedor("+
         "id_vendedor integer primary key autoincrement not null,"+       
         "nome_vendedor text not null);");
		
		db.execSQL("create table if not exists pedido("+
         "id_pedido integer primary key autoincrement not null,"+       
         "id_cliente integer not null,"+       
         "valor_total float not null,"+
         "data text not null,"+
         "CONSTRAINT fk_cliente FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente));");
		
		db.execSQL("create table if not exists item_pedido("+
         "id_item integer primary key autoincrement not null,"+       
         "id_produto integer not null,"+       
         "id_pedido integer not null,"+
         "CONSTRAINT fk_produto FOREIGN KEY(id_produto) REFERENCES produto(id_produto),"+         
         "CONSTRAINT fk_pedido FOREIGN KEY(id_pedido) REFERENCES pedido(id_pedido));");
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		
	}
	
	public static DataBaseHelper getInstance(Context context){
		if(instance==null)
			instance = new DataBaseHelper(context);
		return instance;
	}
	
	
	public void close() throws SQLException{
		this.myDB.close();
	}
	
	public SQLiteDatabase getDB(){
		return this.myDB;
	}
}
