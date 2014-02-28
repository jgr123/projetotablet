package com.example.project;

import com.example.project.CadastrarPedido;
import com.example.project.TelaInicialActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Pedidos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pedidos_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pedidos, menu);
		return true;
	}
	
	public void goToTelaInicial(View view){
		Intent i = new Intent(this,TelaInicialActivity.class);
		startActivity(i);
		this.finish();
	}
	
	public void goToCadastrarPedido(View view){
		Intent i = new Intent(this,CadastrarPedido.class);
		startActivity(i);
		this.finish();
	}

}
