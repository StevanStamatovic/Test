package com.ispit.ispit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button mainBtn;
	private EditText ed1, ed2, ed3, ed4, ed5;
	private TextView txtMain;
	private String grad, izabranSpol;
	private RadioButton rd1, rd2;
	private RadioGroup spol;

	Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mainBtn = (Button) findViewById(R.id.button1);
		mainBtn.setOnClickListener(this);

		ed1 = (EditText) findViewById(R.id.ime);
		ed2 = (EditText) findViewById(R.id.prezime);
		ed3 = (EditText) findViewById(R.id.adresa);
		ed4 = (EditText) findViewById(R.id.oib);
		ed5 = (EditText) findViewById(R.id.telefon);
		txtMain = (TextView) findViewById(R.id.prikaz_texta);
		txtMain.setOnClickListener(this);

		rd1 = (RadioButton) findViewById(R.id.musko);
		rd2 = (RadioButton) findViewById(R.id.zensko);
		spol = (RadioGroup) findViewById(R.id.radio_spol);
		spinner = (Spinner) findViewById(R.id.gradovi);

	}

	@Override
	public void onClick(View v) {

		switch (spol.getCheckedRadioButtonId()) {
		case R.id.musko:
			rd1.setChecked(true);
			rd2.setChecked(false);
			izabranSpol = "Musko";
			break;
		case R.id.zensko:
			rd1.setChecked(false);
			rd2.setChecked(true);
			izabranSpol = "Zensko";
			break;

		}
		Intent i = new Intent(MainActivity.this, Act2.class);
		Bundle b = new Bundle();
		b.putString("ime", ed1.getText().toString());
		b.putString("prezime", ed2.getText().toString());
		b.putString("adresa", ed3.getText().toString());
		b.putString("oib", ed4.getText().toString());
		b.putString("telefon", ed5.getText().toString());
		b.putString("spol", izabranSpol);
		grad = (String) spinner.getSelectedItem().toString();
		b.putString("gradovi", grad);

		i.putExtras(b);
		startActivity(i);

		Toast ispis = Toast.makeText(getApplicationContext(), ed1.getText()
				.toString()
				+ "\n "
				+ ed2.getText().toString()
				+ "\n"
				+ ed3.getText().toString()
				+ "\n "
				+ ed4.getText().toString()
				+ "\n" + ed5.getText().toString() +"\n" + izabranSpol, Toast.LENGTH_LONG);
		ispis.show();
	}

}
