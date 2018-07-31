package com.example.projeto;

import java.io.IOException;

import android.app.ListActivity;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaDispositivos extends ListActivity implements
		BluetoothListener {

	private DescobertaBluetooth bluetooth;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_dispositivos);
		try {
			bluetooth = DescobertaBluetooth.startFindDevices(this, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);
		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(adapter);

	}

	private void preencherLista() {

		for (BluetoothDevice dispositivo : bluetooth.getDispositivos()) {
			adapter.add(dispositivo.getName() + "\n" + dispositivo.getAddress());
		}
	}

	@Override
	public void action(String action) {

		if (action.equals(ACTION_DISCOVERY_STARTED)) {
			adapter.add("-Busca iniciada");
		} else if (action.equals(ACTION_DISCOVERY_FINISHED)) {
			preencherLista();
			adapter.add("-Fim de busca.");
		}
	}

}
