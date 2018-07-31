package com.example.projeto;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class EstadoBluetooth extends BroadcastReceiver {

	private String acao;
	private int estadoBluetooth;

	@Override
	public void onReceive(Context context, Intent intent) {

		acao = intent.getAction();
		if (acao.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {

			estadoBluetooth = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
					BluetoothAdapter.STATE_OFF);
			if (estadoBluetooth == BluetoothAdapter.STATE_ON) {

				Toast.makeText(context, R.string.bluetooth_ligado,
						Toast.LENGTH_LONG).show();

			} else if (estadoBluetooth == BluetoothAdapter.STATE_OFF) {

				Toast.makeText(context, R.string.bluetooth_desligado,
						Toast.LENGTH_LONG).show();
			}
		}
	}

}
