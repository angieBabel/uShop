package com.irvin.ushop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.Parse;
import com.parse.ParseUser;

/**
 * Created by Irvin on 13/04/2015.
 */
public class Main extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Parse.initialize(this, "Y4Z18hEnQtZYFxpMju1cvethHHtKZfu9aS4QyIag", "oB4lTch3tn57FeXB6dYdCgBIZfkKveTaYkkZeLDV");
      //Parse.enableLocalDatastore(this);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if(currentUser == null){
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        }else{
            Intent i = new Intent(this, MenuShop.class);
            startActivity(i);
        }

        this.finish();
    }
}