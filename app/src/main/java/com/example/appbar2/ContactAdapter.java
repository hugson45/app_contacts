package com.example.appbar2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/**
 * Created by Seng on 11/14/2017.
 */

public class ContactAdapter extends BaseAdapter{

    ArrayList<Contact> contacts;
    LayoutInflater inflater;
    ArrayList<Contact> filteredList = new ArrayList<>();

    public ContactAdapter(Context context, ArrayList<Contact> list){
        contacts = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = inflater.inflate(R.layout.list_item_row,viewGroup,false);
        TextView textViewName = rootView.findViewById(R.id.textViewName);
        TextView textViewNumber = rootView.findViewById(R.id.textViewNumber);
        Contact contact = contacts.get(i);
        textViewName.setText(contact.getName());
        textViewNumber.setText(contact.getNumber());
        return rootView;
    }

    public void addContact(Contact c){
        contacts.add(c);
    }

    public void removeContact(int position){
        contacts.remove(position);
    }

    public void updateContact(Contact contact,int position){
        contacts.set(position,contact);
    }

    public Filter getFilter()
    {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredList = contacts;
                } else {
                    ArrayList<Contact> MountainFilteredList = new ArrayList<>();
                    for (Contact item : contacts) {
                        if (item.getName().toLowerCase().contains(charString.toLowerCase())) {
                            MountainFilteredList.add(item);
                        }
                    }
                    filteredList = MountainFilteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                contacts.clear();
                contacts.addAll((Collection<? extends Contact>) filterResults.values);
                filteredList = (ArrayList<Contact>) filterResults.values;
                notifyDataSetChanged();
            }
        };

    }
}