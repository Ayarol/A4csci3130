package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Map;

public class DetailViewActivity extends Activity {

    private EditText busnumField, nameField, busField, addField, proField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        busnumField = (EditText) findViewById(R.id.number);
        nameField = (EditText) findViewById(R.id.name);
        busField = (EditText) findViewById(R.id.business);
        addField = (EditText) findViewById(R.id.address);
        proField = (EditText) findViewById(R.id.province);


        if(receivedPersonInfo != null){
            busnumField.setText(receivedPersonInfo.number);
            nameField.setText(receivedPersonInfo.name);
            busField.setText(receivedPersonInfo.business);
            addField.setText(receivedPersonInfo.address);
            proField.setText(receivedPersonInfo.province);

        }
    }

    public void updateContact(View v){
        String num = busnumField.getText().toString();
        String name = nameField.getText().toString();
        String business = busField.getText().toString();
        String address = addField.getText().toString();
        String province = proField.getText().toString().toUpperCase();
        Contact person = new Contact(receivedPersonInfo.uid, name, num, business, address, province);
        Map<String, Object> newValue = person.toMap();
        appState.firebaseReference.child(receivedPersonInfo.uid).setValue(newValue);
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void eraseContact(View v)
    {
        appState = ((MyApplicationData) getApplicationContext());
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
