package com.example.projeto;

import java.util.ArrayList;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DescobertaBluetooth extends BroadcastReceiver {

	private String acao;
	private BluetoothDevice dispositivo;
	private ArrayList<BluetoothDevice> listaDispositivos;
	private BluetoothListener listener;
	private BluetoothAdapter dispositivoAdapter;

	private DescobertaBluetooth(BluetoothListener listener) {

		this.listener = listener;
		listaDispositivos = new ArrayList<BluetoothDevice>();
	}

	@Override
	public void onReceive(Context context, Intent intent) {

		Toast.makeText(context, "buscando....", Toast.LENGTH_LONG).show();
		acao = intent.getAction();

		if (BluetoothDevice.ACTION_FOUND.equals(acao)) {

			dispositivo = intent
					.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
			if (listaDispositivos.equals(dispositivo)) {

				return;
			}
			listaDispositivos.add(dispositivo);
		} else if (acao.equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {

			Toast.makeText(context, "pausado", Toast.LENGTH_LONG).show();
		}

		if (listener != null) {

			listener.action(acao);
		}
	}

	public ArrayList<BluetoothDevice> getDispositivos() {

		return listaDispositivos;
	}

	public boolean cancelDiscovery() {

		return dispositivoAdapter.cancelDiscovery();
	}

}
