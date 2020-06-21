package com.example.edittextsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText age,father,mother;
    static EditText name;
    static SQLiteDatabase mydata;
    Button savedata;
    String name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name =(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        father=(EditText)findViewById(R.id.father);
        mother=(EditText)findViewById(R.id.mother);
        savedata=(Button)findViewById(R.id.saveData);

        name1=name.getText().toString();
        int age1=21;
        String father1=father.getText().toString();
        String mother1=mother.getText().toString();

        try {

            Log.i("Running","Database is running===================================");

            mydata=this.openOrCreateDatabase("user",MODE_PRIVATE,null);

            mydata.execSQL("CREATE TABLE IF NOT EXISTS user(name VARCHAR(255),age INT(3),father VARCHAR(255),mother VARCHAR(255))");

            mydata.execSQL("INSERT INTO user(name, age, father, mother) VALUES ('Cardinal',21,'Skagen 21','Stavanger')");


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

       savedata.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getApplicationContext(),data.class);
               //intent.putExtra("name",name1);
               startActivity(intent);
           }
       });

    }
}
