package com.example.project;

import java.sql.SQLOutput;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class CadastrarCliente extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrar_cliente_layout);
				
	}
	
	public void cadastrar(View view){
		EditText registro = (EditText)findViewById(R.id.registro);
		EditText nome = (EditText)findViewById(R.id.nome);
		EditText contato = (EditText)findViewById(R.id.contato);
		EditText endereco = (EditText)findViewById(R.id.endereco);
		EditText complemento = (EditText)findViewById(R.id.complemento);
		EditText cidade = (EditText)findViewById(R.id.cidade);
		EditText estado = (EditText)findViewById(R.id.estado);
		EditText cep = (EditText)findViewById(R.id.cep);
		EditText fone = (EditText)findViewById(R.id.fone);
		EditText fax= (EditText)findViewById(R.id.fax);
		EditText email = (EditText)findViewById(R.id.email);
		EditText clifor = (EditText)findViewById(R.id.clifor);
				
		ContentValues values = new ContentValues();
		
		//values.put("registro","0001");
		
		values.put("registro",registro.getText().toString());
		values.put("nome",nome.getText().toString());
		values.put("contato",contato.getText().toString());
		values.put("endereco",endereco.getText().toString());
		values.put("complemento",complemento.getText().toString());
		values.put("cidade",cidade.getText().toString());
		values.put("estado",estado.getText().toString());
		values.put("cep",cep.getText().toString());
		values.put("fone",fone.getText().toString());
		values.put("fax",fax.getText().toString());
		values.put("email",email.getText().toString());
		values.put("clifor",clifor.getText().toString());
		
		try{
			DataBaseHelper dbHelper = new DataBaseHelper(this);
			SQLiteDatabase dbCon = dbHelper.getWritableDatabase();
			dbCon.insert("cliente", null, values);
			dbCon.close();
		}catch(SQLiteException e){
			e.printStackTrace();
		}	
		
		Intent i = new Intent(this,Clientes.class);
		startActivity(i);
		this.finish();
	}
	
	public void goToClientes(View view){
		Intent i = new Intent(this,Clientes.class);
		startActivity(i);
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastrar_cliente, menu);
		return true;
	}

}
