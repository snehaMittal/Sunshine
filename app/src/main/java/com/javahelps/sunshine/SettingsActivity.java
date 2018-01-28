package com.javahelps.sunshine;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView location ;
    TextView pincode ;
    Spinner spinner ;
    SharedPreferences.Editor editor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        location = (TextView)findViewById(R.id.location);
        pincode = (TextView)findViewById(R.id.pincode);
        spinner = (Spinner)findViewById(R.id.spinner_unit);
        location.setOnClickListener(this);
        editor = getSharedPreferences(Constants.MY_PREF_STRING, MODE_PRIVATE).edit();
        String[] items = new String[]{"Celcius" , "Fahreneit"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this , R.layout.support_simple_spinner_dropdown_item, items);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemClickListener(this);
        getSupportActionBar().setTitle("Settings");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.location){
            final EditText taskEditText = new EditText(this );
            taskEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Enter new location")
                    .setView(taskEditText)
                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            pincode.setText(taskEditText.getText());
                            Intent intent = new Intent(SettingsActivity.this , MainActivity.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .create();
            dialog.show();
            editor.putString(Constants.LOCATION , pincode.getText().toString());
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if (i == 0){
            editor.putString(Constants.UNIT , "Celcius");
        }
        if ( i == 1){
            editor.putString(Constants.UNIT , "Fahreneit");
        }
    }
}
