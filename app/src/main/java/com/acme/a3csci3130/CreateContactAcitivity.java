package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText busnumField, nameField, busField, addField, proField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.createButton);
        busnumField = (EditText) findViewById(R.id.number);
        nameField = (EditText) findViewById(R.id.name);
        busField = (EditText) findViewById(R.id.business);
        addField = (EditText) findViewById(R.id.address);
        proField = (EditText) findViewById(R.id.province);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String num = busnumField.getText().toString();
        String name = nameField.getText().toString();
        String business = busField.getText().toString();
        String address = addField.getText().toString();
        String province = proField.getText().toString();
        Contact person = new Contact(personID, name, num, business, address, province);
        appState.firebaseReference.child(personID).setValue(person);
        finish();
    }
}
