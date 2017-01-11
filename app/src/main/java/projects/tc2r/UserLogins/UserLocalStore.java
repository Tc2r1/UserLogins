package projects.tc2r.UserLogins;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Tc2r on 4/5/2016.
 */
public class UserLocalStore {
    public static final String SP_Name = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_Name, 0);

    }
    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name", user.name);
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);
        spEditor.putInt("age", user.age);
        spEditor.commit();

    }

    public User getLoggedInUser(){
        String name = userLocalDatabase.getString("name", "");
        String password = userLocalDatabase.getString("password", "");
        String username = userLocalDatabase.getString("username", "");
        int age = userLocalDatabase.getInt("age", -1);

        User storedUser = new User(name, age, username, password);
        return storedUser;
    }
    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }
    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("loggedIn", false ) == true){
            return true;
        }else{
            return false;
        }
    }
    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}

