package com.example.domik.remem;

import android.content.Context;
import android.content.SharedPreferences;


public class UserLocalStore {
    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user) {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("email", user.email);
        spEditor.putString("password", user.password);
        spEditor.putString("name", user.name);
        spEditor.putString("surname", user.surname);
        spEditor.putString("phone", user.phoneNumber);
        spEditor.putBoolean("sex", user.sex);
        spEditor.commit();
    }

    public User getLoggedInUser() {
        String email = userLocalDatabase.getString("email", "");
        String password = userLocalDatabase.getString("password", "");
        String name = userLocalDatabase.getString("name", "");
        String surname = userLocalDatabase.getString("surname", "");
        String phone = userLocalDatabase.getString("phone", "");
        boolean sex = userLocalDatabase.getBoolean("sex", false);

        User storedUser = new User(email, password, name, surname, phone, sex);
        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn() {
        if (userLocalDatabase.getBoolean("loggedIn", false) == true) {
            return true;
        } else
            return false;
    }

    public void clearUserData() {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }

}

