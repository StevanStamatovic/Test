package com.ispit.ispit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Act2 extends Activity implements OnClickListener {

	private Button btn_yes;
	private Button btn_no;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		String ime = "";
		String prezime = "";
		String adresa = "";
		String grad = "";
		String oib = "";
		String telefon = "";
		String spol = "";

		super.onCreate(savedInstanceState);
		setContentView(R.layout.data_act);
		btn_yes = (Button) findViewById(R.id.da_btn);
		btn_yes.setOnClickListener(this);
		btn_no = (Button) findViewById(R.id.ne_btn);
		btn_no.setOnClickListener(this);
		Bundle bundle = getIntent().getExtras();

		if (bundle != null) {
			ime = bundle.getString("ime");
			prezime = bundle.getString("prezime");
			adresa = bundle.getString("adresa");
			grad = bundle.getString("gradovi");
			oib = bundle.getString("oib");
			telefon = bundle.getString("telefon");
			spol = bundle.getString("spol");
		}

		TextView t = (TextView) findViewById(R.id.imePogled);
		TextView t1 = (TextView) findViewById(R.id.prezimePogled);
		TextView t3 = (TextView) findViewById(R.id.adresaPogled);
		TextView t4 = (TextView) findViewById(R.id.gradPogled);
		TextView t5 = (TextView) findViewById(R.id.oibPogled);
		TextView t6 = (TextView) findViewById(R.id.telPogled);
		TextView t7 = (TextView) findViewById(R.id.spolPogled);
		t.setText(ime);
		t1.setText(prezime);
		t3.setText(adresa);
		t4.setText(grad);
		t5.setText(oib);
		t6.setText(telefon);
		t7.setText(spol);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.da_btn:
			Intent intent = new Intent(Act2.this, MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case R.id.ne_btn:
			Toast poruka = Toast
					.makeText(getApplicationContext(),
							"Hvala na koistenju ove sexy aplikacije",
							Toast.LENGTH_LONG);
			poruka.show();
			this.finish();
			Intent intent1 = new Intent(Intent.ACTION_MAIN);
			intent1.addCategory(Intent.CATEGORY_HOME);
			intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent1);
		
			break;
		}

	}
}
