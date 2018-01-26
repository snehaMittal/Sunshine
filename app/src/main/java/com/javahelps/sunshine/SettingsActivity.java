package com.javahelps.sunshine;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView location ;
    TextView pincode ;
    Spinner spinner ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        location = (TextView)findViewById(R.id.location);
        pincode = (TextView)findViewById(R.id.pincode);
        spinner = (Spinner)findViewById(R.id.spinner_unit);
        location.setOnClickListener(this);
        String[] items = new String[]{"Celcius" , "Fahreneit"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this , R.layout.support_simple_spinner_dropdown_item, items);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
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
        }
        else {
            Toast.makeText(getBaseContext() , view.getId()+"" , Toast.LENGTH_LONG).show();
        }
    }
}
