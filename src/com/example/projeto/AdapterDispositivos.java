package com.example.projeto;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterDispositivos extends BaseAdapter {

	private List<String> listaDispositivos = new ArrayList<String>();
	private LayoutInflater inflater;

	public AdapterDispositivos(Context context) {
		
		this.inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {

		return listaDispositivos.size();
	}

	@Override
	public String getItem(int pos) {

		return listaDispositivos.get(pos);
	}

	@Override
	public long getItemId(int pos) {

		return pos;
	}
	
	public int insertItem(String item) {
		listaDispositivos.add(item);
		return listaDispositivos.size() - 1;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		
		ViewHolder viewHolder;
		if (convertView == null) {

			//convertView = inflater.inflate(
			//		R.layout.activity_lista_dispositivos, null);
			//viewHolder = new ViewHolder();
			//viewHolder.text = (TextView) convertView
			//		.findViewById(R.id.dispositivo);
			//convertView.setTag(viewHolder);
		} else {

			viewHolder = (ViewHolder) convertView.getTag();
		}
		//viewHolder.text.setText(listaDispositivos.get(pos));
		return convertView;
	}

	private static class ViewHolder {

		TextView text;
	}
}
