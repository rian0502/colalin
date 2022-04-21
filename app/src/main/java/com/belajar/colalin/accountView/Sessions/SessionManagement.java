package com.belajar.colalin.accountView.Sessions;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String SHAREDPREFNAME = "session";
    private String USERNAMEKEY = "usernameKEY";


    public SessionManagement(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHAREDPREFNAME, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public void saveSession(UserLogged userLogged){
       editor.putString(USERNAMEKEY, userLogged.getUser()).commit();
    }

    public String getSession(){
        return sharedPreferences.getString(USERNAMEKEY, "null");
    }
    public void removeSession(){
        editor.putString(USERNAMEKEY,"null").commit();
    }

}
