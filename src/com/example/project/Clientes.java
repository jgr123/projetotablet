package com.example.project;

import java.util.ArrayList;

import com.example.Adapters.ClienteAdapter;
import com.example.models.Cliente;

import android.app.AlertDialog.Builder;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.ListAdapter;;

public class Clientes extends ListActivity {
	
	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clientes_layout);
		
		ListView lv = (ListView) findViewById(android.R.id.list);
		
		DataBaseHelper dbHelper = new DataBaseHelper(this);		
		SQLiteDatabase dbCon = dbHelper.getWritableDatabase();
		Cursor c = dbCon.rawQuery("Select id, registro, nome, contato, endereco, complemento, cidade, estado, " +
				"cep, fax, fone, email, clifor from cliente", null);
		if(c.getCount()>0){
			while(c.moveToNext()){
				Cliente cl = new Cliente(
						Integer.parseInt(c.getString(c.getColumnIndexOrThrow("id"))),
						c.getString(c.getColumnIndexOrThrow("registro")),
						c.getString(c.getColumnIndexOrThrow("nome")),
						c.getString(c.getColumnIndexOrThrow("contato")),
						c.getString(c.getColumnIndexOrThrow("endereco")),
						c.getString(c.getColumnIndexOrThrow("complemento")),
						c.getString(c.getColumnIndexOrThrow("cidade")),
						c.getString(c.getColumnIndexOrThrow("estado")),
						c.getString(c.getColumnIndexOrThrow("cep")),
						c.getString(c.getColumnIndexOrThrow("fax")),
						c.getString(c.getColumnIndexOrThrow("fone")),
						c.getString(c.getColumnIndexOrThrow("email")),
						c.getString(c.getColumnIndexOrThrow("clifor"))
						);
				clientes.add(cl);

			}
			ClienteAdapter adapter = new ClienteAdapter(getApplicationContext(),clientes);
			
			lv.setAdapter(adapter);
		}
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		super.onListItemClick(l, v, position, id);
		Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(clientes.get(position).getNome());
		builder.setPositiveButton("Ok", null);
		builder.show();
	}
	
	
	public void goToCadastrarCliente(View view){
		Intent i = new Intent(this,CadastrarCliente.class);
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
		getMenuInflater().inflate(R.menu.clientes, menu);
		return true;
	}

}