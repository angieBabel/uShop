package com.irvin.ushop;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ParseException;
import com.parse.LogInCallback;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "Y4Z18hEnQtZYFxpMju1cvethHHtKZfu9aS4QyIag", "oB4lTch3tn57FeXB6dYdCgBIZfkKveTaYkkZeLDV");

    }

    public void ingresarUsuario(View view){

        //Metodo para obtener el nombre de usuario ingresado
        EditText usr = (EditText )findViewById(R.id.usernamelog);
        String usuario = usr.getText().toString();
        //Obtencion de la contraseña ingresada
        EditText pasw = (EditText)findViewById(R.id.paswlog);
        String contrasena = pasw.getText().toString();

        //Pase de parametros enviados a parse para ingresar
        ParseUser.logInInBackground(usuario, contrasena, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    // Hooray! The user is logged in.
                    TextView mensaje =(TextView)findViewById(R.id.mensajelog);
                    mensaje.setText("Hooray! The user is logged in.");
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                    TextView mensaje =(TextView)findViewById(R.id.mensajelog);
                    mensaje.setText("Signup failed. Look at the ParseException to see what happened.");
                }
            }
        });
    }

    //metodo para
    public void mostrarVistaRegistro(View view) {
        Intent i = new Intent(this, Registro.class );
        startActivity(i);
    }

    public void mostrarVistaUsuario(View view){
        Intent i = new Intent(this, Usuario.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
