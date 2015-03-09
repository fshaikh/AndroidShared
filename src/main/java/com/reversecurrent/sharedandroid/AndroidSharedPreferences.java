package com.reversecurrent.sharedandroid;

import android.content.Context;
import android.content.SharedPreferences;

import com.reversecurrent.shared.ISharedPreference;

/**
 * Created by fshaikh on 28/02/2015.
 */
public class AndroidSharedPreferences implements ISharedPreference {

    private String _preferencesFileName;
    private SharedPreferences _sharedPreferences;

    public AndroidSharedPreferences(Context context,String preferencesFileName){
        _preferencesFileName = preferencesFileName;
        _sharedPreferences = context.getSharedPreferences(_preferencesFileName,0);
    }
    @Override
    public String GetStringValue(String key,String defaultValue) {
        return _sharedPreferences.getString(key,defaultValue);
    }

    @Override
    public Boolean GetBooleanValue(String key,Boolean defaultValue) {
        return _sharedPreferences.getBoolean(key,defaultValue);
    }

    @Override
    public int GetIntegerValue(String key,int defaultValue) {
        return _sharedPreferences.getInt(key,defaultValue);
    }

    @Override
    public Boolean SetStringValue(String key, String value) {
        SharedPreferences.Editor editor = _sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
        return true;
    }

    @Override
    public Boolean SetBooleanValue(String key, Boolean value) {
        SharedPreferences.Editor editor = _sharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.commit();
        return true;
    }

    @Override
    public Boolean SetIntegerValue(String key, int value) {
        SharedPreferences.Editor editor = _sharedPreferences.edit();
        editor.putInt(key,value);
        editor.commit();
        return true;
    }

    @Override
    public Boolean RemoveKey(String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void Save() {

    }


}
