package com.example.Adapters;
import java.util.List;

import com.example.project.R;
import com.example.models.Produto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProdutoAdapter extends BaseAdapter {

	private List<Produto> produtos;
	private LayoutInflater mInflater;
	private ViewHolder holder;

	public ProdutoAdapter(Context ctx, List<Produto> produtos) {
		super();
//		this.ctx = ctx;
		mInflater = LayoutInflater.from(ctx);
		this.produtos = produtos;
	}

	@Override
	public int getCount() {
		return produtos.size();
	}

	@Override
	public Object getItem(int position) {
		return produtos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return produtos.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		//View v = LayoutInflater.from(ctx).inflate(R.layout.linha_produto,null);
		
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.linha_produto, null);
			holder = new ViewHolder();

			holder.tvNome = (TextView) convertView.findViewById(R.id.nome);
			holder.tvValUnit = (TextView) convertView
					.findViewById(R.id.val_unit);
			holder.quantEstoque = (TextView) convertView.findViewById(R.id.quant_estoque);

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}


		Produto p = produtos.get(position);

		holder.tvNome.setText(p.getDescricao());
		//holder.tvValUnit.setText(Float.toString(p.getValorUnitario()));
		holder.tvValUnit.setText(String.valueOf(p.getValorUnitario()));
		holder.quantEstoque.setText(String.valueOf(p.getQuantidade()));

		return convertView;
	}
	
	static class ViewHolder{
		private TextView tvNome;
		private TextView tvValUnit;
		private TextView quantEstoque;
	}

}
