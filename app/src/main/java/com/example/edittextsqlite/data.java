package com.example.edittextsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class data extends AppCompatActivity {
    TextView name,age,father,mother;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        name=(TextView)findViewById(R.id.name);
        age=(TextView)findViewById(R.id.age);
        father=(TextView)findViewById(R.id.father);
        mother=(TextView)findViewById(R.id.mother);

        Intent intent=getIntent();
        String username=MainActivity.name.getText().toString();

        try {

            Cursor c=MainActivity.mydata.rawQuery("SELECT * FROM user",null);
            int name2=c.getColumnIndex("name");
            int age2=c.getColumnIndex("age");
            int farher2=c.getColumnIndex("father");
            int mother2=c.getColumnIndex("mother");
            c.moveToFirst();
            while (c!=null)
            {
                name.setText(c.getString(name2));
                age.setText(Integer.toString(c.getInt(age2)));
                father.setText(c.getString(farher2));
                mother.setText(c.getString(mother2));
                c.moveToNext();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
