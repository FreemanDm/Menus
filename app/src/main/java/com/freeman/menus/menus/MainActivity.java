package com.freeman.menus.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillMyContacts();
        setContentView(R.layout.activity_main);
        ContactsAdapter adapter = new ContactsAdapter(contacts, this);
        ListView list = (ListView) findViewById(R.id.my_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Was clicked" + contacts.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillMyContacts(){
        for (int i = 0; i < 15; i++){
            contacts.add(new Contact("Vasia" + (i + 1), "vasia" + (i + 1) + "@gmail.com", " ", " "));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_menu_item){
            Toast.makeText(this, "Was clicked add menu item", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.settings_menu_item){
            Toast.makeText(this, "Was clicked setting menu item", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
