package com.example.project;

import java.util.ArrayList;
import java.util.List;


import com.example.Adapters.ProdutoAdapter;
import com.example.models.Produto;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Produtos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.produtos_layout);
		
		//Spinner spinner = (Spinner) findViewById(R.id.spinner);
		ListView lv = (ListView) findViewById(android.R.id.list);
		
		ArrayList<Produto> produto = new ArrayList<Produto>();
		
		DataBaseHelper dbHelper = new DataBaseHelper(this);
		
		SQLiteDatabase dbCon = dbHelper.getWritableDatabase();
		Cursor c = dbCon.rawQuery("Select id, descricao, valor_unitario, quantidade from produtos", null);
		
		if(c.getCount()>0){
			
			while(c.moveToNext()){
				Produto p = new Produto(Integer.parseInt(c.getString(c.getColumnIndexOrThrow("id"))),
						c.getString(c.getColumnIndexOrThrow("descricao")),
						Float.parseFloat(c.getString(c.getColumnIndexOrThrow("valor_unitario"))),
						Integer.parseInt(c.getString(c.getColumnIndexOrThrow("quantidade"))));
				produto.add(p);
			}
			
			
			ProdutoAdapter adapter = new ProdutoAdapter(getApplicationContext(),produto);
			
			//spinner.setAdapter(adapter);

			lv.setAdapter(adapter);
		}
		
	}
	
	public void goToCadastrarProduto(View view){
		Intent i = new Intent(this,CadastrarProduto.class);
		startActivity(i);
		this.finish();
	}
	
	public void goToTelaInicial(View view){
		Intent i = new Intent(this, TelaInicialActivity.class);
		startActivity(i);
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.produtos, menu);
		return true;
	}

}
