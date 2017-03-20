package com.freeman.menus.menus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Freeman on 05.01.2017.
 */

public class ContactsAdapter extends BaseAdapter{
    private ArrayList<Contact> list;
    private Context context;

    public ContactsAdapter(ArrayList<Contact> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {  // size our listview
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        Contact contact = getContact(position);
        TextView name = (TextView) view.findViewById(R.id.row_name_txt);
        TextView email = (TextView) view.findViewById(R.id.row_email_txt);
        ImageView icon = (ImageView) view.findViewById(R.id.row_icon);
        icon.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_launcher));
        name.setText(contact.getName());
        email.setText(contact.getEmail());
        return view;
    }

    private Contact getContact(int position){
        return list.get(position);
    }
}
