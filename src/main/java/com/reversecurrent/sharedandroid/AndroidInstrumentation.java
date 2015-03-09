package com.reversecurrent.sharedandroid;

import android.content.Context;
import android.widget.Toast;

import com.reversecurrent.shared.IInstrumentation;

/**
 * Created by fshaikh on 06/03/2015.
 */
public class AndroidInstrumentation implements IInstrumentation {
        private Context _context;

        public AndroidInstrumentation(Context context){
            _context = context;
        }

        public void ShowMessage(String message){
            Toast.makeText(_context, message, Toast.LENGTH_LONG).show();
        }
}
