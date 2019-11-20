package com.example.users;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<User> arrayOfUsers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button create = findViewById(R.id.button);

        Intent i = getIntent();
        User addedUser = new User(i.getStringExtra("NameUser"), i.getStringExtra("SurnameUser"),
                i.getStringExtra("AgeUser"),i.getStringExtra("EMAILUser"));

        arrayOfUsers.add(addedUser);


         // Create the adapter to convert the array to views
        UsersAdapter adapter = new UsersAdapter(this, arrayOfUsers);
         // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvItems);
        listView.setAdapter(adapter);


        create.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"WrongViewCast", "SetTextI18n"})
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("Start",true);
                startActivity(i);
            }
        });

    }


    public class UsersAdapter extends ArrayAdapter<User> {
        public UsersAdapter(Context context, ArrayList<User> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            User user = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
            }

            // Lookup view for data population
            TextView name = (TextView) convertView.findViewById(R.id.Name);
            TextView surname = (TextView) convertView.findViewById(R.id.Surname);
            TextView age = (TextView) convertView.findViewById(R.id.Age);
            TextView email = (TextView) convertView.findViewById(R.id.Email);


            // Populate the data into the template view using the data object
            name.setText(user.getName());
            surname.setText(user.getSurname());
            age.setText(user.getAge());
            email.setText(user.getEmail());

            // Return the completed view to render on screen
            return convertView;
        }
    }
}
