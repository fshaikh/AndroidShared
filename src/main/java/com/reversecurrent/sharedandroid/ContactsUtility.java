package com.reversecurrent.sharedandroid;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import java.util.ArrayList;


/**
 * Created by fshaikh on 04/03/2015.
 */
public class ContactsUtility {
    private Context _context;
    private static String[] PROJECTIONS_BASE = new String[]{ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};

    public ContactsUtility(Context context){
        _context = context;
    }

    public ContactBase GetBaseContactData(Uri contentUri){
       Cursor cursor = _context.getContentResolver().query(contentUri,PROJECTIONS_BASE,null,null,null);
        ContactBase contactBase = new ContactBase();
       if(cursor.moveToFirst()){
           contactBase.DisplayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
           contactBase.PhoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
       }
        cursor.close();
        return contactBase;
    }

    public String SanitizePhoneNumber(String phoneNumber){
        phoneNumber = phoneNumber.replace("-", "");
        phoneNumber = phoneNumber.replace("(", "");
        phoneNumber = phoneNumber.replace(")","");

        return phoneNumber;
    }

    public Intent GetShowContactIntent(){
        // launch the contact activity. Intent for component activation
        // Create an intent passing:
        // Action :
        // Extras :
        // Data   :
        // Category :
        Intent contactPickIntent = new Intent(android.content.Intent.ACTION_PICK);
        // Show contacts with phone numbers
        contactPickIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);

        return contactPickIntent;
    }
}
