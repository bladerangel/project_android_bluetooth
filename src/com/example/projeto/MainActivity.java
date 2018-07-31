package com.example.projeto;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

	private static final int REQUISICAO_ATIVAR_BLUETOOTH = 1;
	private BluetoothAdapter adapterBluetooth;
	private Button buscar;
	private Button pausar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buscar = (Button) findViewById(R.id.buscarDispositivos);
		buscar.setOnClickListener(this);
		pausar = (Button) findViewById(R.id.pausar);
		pausar.setOnClickListener(this);
		
		
		adapterBluetooth = BluetoothAdapter.getDefaultAdapter();
		if (adapterBluetooth == null) {

			Toast.makeText(this, R.string.nao_suporta_bluetooth,
					Toast.LENGTH_LONG).show();
			finish();
		}
		
		ativarBluetooth();
	}

	public void ativarBluetooth() {

		if (!adapterBluetooth.isEnabled()) {

			Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(intent, REQUISICAO_ATIVAR_BLUETOOTH);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == REQUISICAO_ATIVAR_BLUETOOTH
				&& resultCode == RESULT_CANCELED) {
			
			Toast.makeText(this, R.string.a_aplicacao_necessita_da_ativacao,
					Toast.LENGTH_LONG).show();
			ativarBluetooth();
		}

	}

	@Override
	public void onClick(View view) {
		
		if(view.getId() == R.id.buscarDispositivos)
		{
			Intent intent = new Intent(getApplicationContext(),ListaDispositivos.class);
			startActivity(intent);
		}
		else adapterBluetooth.cancelDiscovery();
	}
}
