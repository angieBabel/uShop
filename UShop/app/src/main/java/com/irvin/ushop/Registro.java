package com.irvin.ushop;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.ParseException;
import android.view.View;
import android.widget.Toast;

public class Registro extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
        return true;
    }

    public void enviarRegistro(View view) {

        EditText username1 = (EditText) findViewById(R.id.usernamereg);
        String username = username1.getText().toString();

        EditText pasw1 = (EditText) findViewById(R.id.paswreg);
        String password = pasw1.getText().toString();

        EditText pasw2 = (EditText) findViewById(R.id.confmpasw);
        String confirmpass = pasw2.getText().toString();

        EditText email1 = (EditText) findViewById(R.id.emailreg);
        String email = email1.getText().toString();

        EditText phone1 = (EditText) findViewById(R.id.telefonoreg);
        String phone = phone1.getText().toString();


        if(password != confirmpass){
            Toast.makeText(this, "La contrasea no coincide", Toast.LENGTH_SHORT).show();
        }else {
            ParseUser user = new ParseUser();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            //"650-253-0000"
            user.put("phone", phone);

            user.signUpInBackground(new SignUpCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        // Hooray! Let them use the app now.
                        //Toast.makeText(getApplication(),"Hooray! Let them use the app now.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MenuShop.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplication(),"Fallo el registro. Revise los campos.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        this.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
