package com.belajar.colalin.accountView.Sessions;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;
    private final String USERNAMEKEY = "usernameKEY";
    private final String IDKEY = "ID";

    public SessionManagement(Context context) {
        this.sharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public void saveSession(UserLogged userLogged){
       editor.putString(USERNAMEKEY, userLogged.getUser()).commit();
       editor.putString(IDKEY, String.valueOf(userLogged.getId())).commit();
    }

    public String getSession(){
        return sharedPreferences.getString(USERNAMEKEY, "null");
    }
    public String getIdSession(){
        return sharedPreferences.getString(IDKEY,"null");
    }
    public void removeSession(){
        editor.putString(USERNAMEKEY,"null").commit();
        editor.putString(IDKEY, null).commit();
    }

}
