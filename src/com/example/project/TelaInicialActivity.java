package com.example.project;

import android.os.Bundle;
import android.provider.SyncStateContract.Columns;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

public class TelaInicialActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicial_layout); 
	}
	
	public void goToClientes(View view){
		Intent i = new Intent(this,Clientes.class);
		startActivity(i);
		this.finish();
	}
	
	public void goToProdutos(View view){
		Intent i = new Intent(this,Produtos.class);
		startActivity(i);
		this.finish();
	}
	
	public void goToPedidos(View view){
		Intent i = new Intent(this,Pedidos.class);
		startActivity(i);
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_inicial, menu);
		return true;
	}

}

