package com.example.project;

import java.sql.SQLException;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class CadastrarProduto extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrar_produto_layout);
	}
	
	public void cadastrar(View view){
		EditText descricao = (EditText)findViewById(R.id.descricao);
		EditText valorUnitario = (EditText)findViewById(R.id.valorunitario);
		EditText quantidade = (EditText)findViewById(R.id.quantidade);
		
		ContentValues values = new ContentValues();
		
		values.put("descricao", descricao.getText().toString());
		values.put("valor_unitario", Float.parseFloat(valorUnitario.getText().toString()));
		values.put("quantidade", Integer.parseInt(quantidade.getText().toString()));
		
			
		try{
			DataBaseHelper dbHelper = new DataBaseHelper(this);
			SQLiteDatabase dbCon = dbHelper.getWritableDatabase();
			
			dbCon.insert("produtos", null, values);
			//dbCon.execSQL("Insert into produtos (descricao,valor_unitario,quantidade) values("+ descricao.getText().toString()+
			//","+ Float.parseFloat(valorUnitario.getText().toString()) +","+ Integer.parseInt(quantidade.getText().toString()) +");");
			dbCon.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Intent i = new Intent(this,Produtos.class);
		startActivity(i);
		this.finish();		
	}
	
	public void goToProdutos(View view){
		Intent i = new Intent(this,Produtos.class);
		startActivity(i);
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastrar_produto, menu);
		return true;
	}

}