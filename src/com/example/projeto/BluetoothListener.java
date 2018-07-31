package com.example.projeto;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

public interface BluetoothListener {
	public static final String ACTION_DISCOVERY_STARTED = BluetoothAdapter.ACTION_DISCOVERY_STARTED;
	public static final String ACTION_FOUND = BluetoothDevice.ACTION_FOUND;
	public static final String ACTION_DISCOVERY_FINISHED = BluetoothAdapter.ACTION_DISCOVERY_FINISHED;

	public void action(String action);
}
