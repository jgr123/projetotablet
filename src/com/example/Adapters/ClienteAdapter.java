package com.example.Adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.project.R;
import com.example.models.Cliente;

public class ClienteAdapter extends BaseAdapter {

	private List<Cliente> clientes;
	private LayoutInflater mInflater;
	private ViewHolder holder;

	public ClienteAdapter(Context ctx, List<Cliente> clientes) {
		super();
		mInflater = LayoutInflater.from(ctx);
		this.clientes = clientes;
	}

	@Override
	public int getCount() {
		return clientes.size();
	}

	@Override
	public Object getItem(int position) {
		return clientes.get(position);
	}

	@Override
	public long getItemId(int position) {
		return clientes.get(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.linha_cliente, null);
			holder = new ViewHolder();

			holder.nome = (TextView) convertView.findViewById(R.id.nome);
			holder.contato = (TextView) convertView
					.findViewById(R.id.contato);
			holder.cidade = (TextView) convertView
					.findViewById(R.id.cidade);
			holder.telefone = (TextView) convertView
					.findViewById(R.id.telefone);
			

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		Cliente c = clientes.get(position);

		holder.nome.setText(c.getNome());
		holder.contato.setText(c.getContato());
		holder.cidade.setText(c.getCidade());
		holder.telefone.setText(c.getFone());

		return convertView;

	}

	static class ViewHolder {
		private TextView nome;
		private TextView contato;
		private TextView cidade;
		private TextView telefone;
	}

}
