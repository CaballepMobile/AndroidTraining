package com.example.angel.myapplication;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.angel.myapplication.models.Person;
import com.example.angel.myapplication.util.ActivityKeys;

import java.util.ArrayList;
import java.util.List;

public class UserForm extends AppCompatActivity {

    private EditText etName;
    private EditText etAge;
    private EditText etFavoriteColor;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        InitializeViews();
    }

    private void InitializeViews(){
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etFavoriteColor = findViewById(R.id.etFavoriteColor);
    }

    public void evtOpenList(){

    }

    public void evtSubmit(){

        SubmitPerson(new Person(
                etName.getText().toString(),
                etAge.getText().toString(),
                etFavoriteColor.getText().toString()));
    }

    public void SubmitPerson(Person person){
        Intent intent = new Intent(getApplicationContext(), PersonList.class);

        //intent.putExtra(ActivityKeys.KEYS.PERSON_LIST, person);

        personList.add(person);
        Bundle bundle = intent.getBundleExtra("");
        ArrayList

        intent.putStringArrayListExtra(ActivityKeys.KEYS.PERSON_LIST, personList);



        startActivity(intent);
    }
}
