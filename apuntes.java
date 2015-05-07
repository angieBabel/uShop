final ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
        ParseUser user = ParseUser.getCurrentUser();
        query.whereEqualTo("user", user);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, com.parse.ParseException e) {
                if (e == null) {
                    // The query was successful.
                    //int numItems = parseObjects.size();
                    //modelItems = new Model[numItems];
                    Log.d("Tareas", "Resividas " + parseObjects.size() + " tareas");
                    for (ParseObject parseObject : parseObjects){
                        String tarea;
                        tarea = parseObject.get("taskname").toString();
                        Log.d("Tarea", tarea);
                    }
                    /*for (ParseObject dealsObject : parseObjects) {
                        // use dealsObject.get('columnName') to access the properties of the Deals object.
                        dealsObject.get('taskname');
                    }*/
                } else {
                    // Something went wrong.
                    Log.d("Usuario", "Error: " + e.getMessage());
                }
            }
        });

//Toda la clase Tareas antes de modificar
package com.irvin.ushop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irvin on 14/04/2015.
 */
public class Tareas extends Fragment {

    //ListView lista_tareas;

    private ListView lista_tareas;
    private EditText et;
    private String listview_array[];
    private String[] element;
    private ArrayList<String> array_task = new ArrayList<>();
    int lenght=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tareas, container, false);

        //lista_tareas = (ListView) rootView.findViewById(R.id.listTask);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
        ParseUser user = ParseUser.getCurrentUser();
        query.whereEqualTo("user", user);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if (e == null) {
                    for (ParseObject parseObject : objects){
                    }
                } else {
                    // Something went wrong.
                    Log.d("Usuario", "Error: " + e.getMessage());
                }
            }
        });
       //lista_tareas = (ListView) rootView.findViewById(R.id.listTask);
       //lista_tareas.setAdapter(new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_expandable_list_item_1, listview_array));


        //AdptadorPreferencia adapter = new AdptadorPreferencia(this.getActivity(), modelItems);
        //lista_tareas.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); //hasMenu
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_add_tareas, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
                builder.setTitle("Añadir tarea");
                builder.setMessage("¿Que es lo que vas hacer?");
                final EditText inputField = new EditText(this.getActivity());
                builder.setView(inputField);
                builder.setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Tareas", inputField.getText().toString());

                        ParseUser currentUser = ParseUser.getCurrentUser();
                        ParseObject tareas = new ParseObject("Task");
                        tareas.put("taskname", inputField.getText().toString());
                        tareas.put("user", currentUser);
                        tareas.saveInBackground();

                    }
                });

                builder.setNegativeButton("Cancelar", null);

                builder.create().show();

            default:
                return super.onContextItemSelected(item);
        }

    }
}



//otro
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tareas, container, false);

        ArrayList<ModeloTarea> tareas = new ArrayList<ModeloTarea>();
        tareas.add(new ModeloTarea("Tarea 1"));

        ListView listView = (ListView)rootView.findViewById(R.id.listTask);
        listView.setAdapter(new AdaptadorTareas(this, R.layout.vista_tareas, tareas){
            @Override
            public void onEntrada(Object entrada, View view) {
                TextView texto_superior_entrada = (TextView) view.findViewById(R.id.taskTextView);
                texto_superior_entrada.setText(((ModeloTarea) entrada).get_textoEncima());
            }
        });

        return rootView;
    }


    //Confirmar contraseña

    @Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
 
    ctlLogin = (ControlLogin)findViewById(R.id.CtlLogin);
 
    ctlLogin.setOnLoginListener(new OnLoginListener()
    {
    @Override
    public void onLogin(String usuario, String password)
    {
        //Validamos el usuario y la contraseña
        if (usuario.equals("demo") && password.equals("demo"))
            ctlLogin.setMensaje("Login correcto!");
        else
            ctlLogin.setMensaje("Vuelva a intentarlo.");
    }
    });
}


//clase preferencias sin modificar
package com.irvin.ushop;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irvin on 27/03/2015.
 */
public class Preferencia extends Fragment {
    ListView lista_preferencias;
    ModeloPreferencia[] modPref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_preferencia, container, false);


        lista_preferencias = (ListView) rootView.findViewById(R.id.list_preferencias);

        modPref = new ModeloPreferencia[16];
        modPref[0]= new ModeloPreferencia ("Audio",0);
        modPref[1]= new ModeloPreferencia ("Autos",0);
        modPref[2]= new ModeloPreferencia ("Libros",0);
        modPref[3]= new ModeloPreferencia ("Bebés",0);
        modPref[4]= new ModeloPreferencia ("Celulares",0);
        modPref[5]= new ModeloPreferencia ("Computadoras",0);
        modPref[6]= new ModeloPreferencia ("Deportes",0);
        modPref[7]= new ModeloPreferencia ("Electronica",0);
        modPref[8]= new ModeloPreferencia ("Electrodomésticos",0);
        modPref[9]= new ModeloPreferencia ("Hogar",0);
        modPref[10]= new ModeloPreferencia ("Juguetes",0);
        modPref[11]= new ModeloPreferencia ("Mascotas",0);
        modPref[12]= new ModeloPreferencia ("Salud y Belleza",0);
        modPref[13]= new ModeloPreferencia ("Video Juegos",0);
        modPref[14]= new ModeloPreferencia ("Regalos para El",0);
        modPref[15]= new ModeloPreferencia ("Regalos para Ella",0);

        AdaptadorPreferencia adapter = new AdaptadorPreferencia(this.getActivity(), modPref);
        lista_preferencias.setAdapter(adapter);

        //ArrayAdapter adaptador = new ArrayAdapter (this.getActivity(), android.R.layout.simple_list_item_1, preferencias);
        //lista_preferencias = (ListView) rootView.findViewById(R.id.list_preferencias);
        //lista_preferencias.setAdapter(adaptador);

        return rootView;
    }
}

        ArrayList<ModeloPreferencia> preferencesList = new ArrayList<ModeloPreferencia>();
        ModeloPreferencia preferencia = new ModeloPreferencia ("Audio",0);
        preferencesList.add(preferencia);
        preferencia = new ModeloPreferencia ("Autos",0);
        preferencesList.add(preferencia);
        preferencia = new ModeloPreferencia ("Libros",0);
        preferencesList.add(preferencia);

        array_pref[0]=("Audio");
        array_pref[1]=("Autos");
        array_pref[2]=("Libros");
        array_pref[3]=("Bebés");
        array_pref[4]=("Celulares");
        array_pref[5]=("Computadoras");
        array_pref[6]=("Deportes");
        array_pref[7]=("Electronica");
        array_pref[8]=("Electrodomésticos");
        array_pref[9]=("Hogar");
        array_pref[10]=("Juguetes");
        array_pref[11]=("Mascotas");
        array_pref[12]=("Salud y Belleza");
        array_pref[13]=("Video Juegos");
        array_pref[14]=("Regalos para El");
        array_pref[15]=("Regalos para Ella");

        for(int i=0; i<=16; i++){
            modPref[i]= new ModeloPreferencia (array_pref[i].toString(),);
        }



        modPref = new ModeloPreferencia[16];
        modPref[0]= new ModeloPreferencia ("Audio",0);
        modPref[1]= new ModeloPreferencia ("Autos",0);
        modPref[2]= new ModeloPreferencia ("Libros",0);
        modPref[3]= new ModeloPreferencia ("Bebés",0);
        modPref[4]= new ModeloPreferencia ("Celulares",0);
        modPref[5]= new ModeloPreferencia ("Computadoras",0);
        modPref[6]= new ModeloPreferencia ("Deportes",0);
        modPref[7]= new ModeloPreferencia ("Electronica",0);
        modPref[8]= new ModeloPreferencia ("Electrodomésticos",0);
        modPref[9]= new ModeloPreferencia ("Hogar",0);
        modPref[10]= new ModeloPreferencia ("Juguetes",0);
        modPref[11]= new ModeloPreferencia ("Mascotas",0);
        modPref[12]= new ModeloPreferencia ("Salud y Belleza",0);
        modPref[13]= new ModeloPreferencia ("Video Juegos",0);
        modPref[14]= new ModeloPreferencia ("Regalos para El",0);
        modPref[15]= new ModeloPreferencia ("Regalos para Ella",0);




array_pref.add("");
        
        array_pref[0]=("Audio");
        array_pref[1]=("Autos");
        array_pref[2]=("Libros");
        array_pref[3]=("Bebés");
        array_pref[4]=("Celulares");
        array_pref[5]=("Computadoras");
        array_pref[6]=("Deportes");
        array_pref[7]=("Electronica");
        array_pref[8]=("Electrodomésticos");
        array_pref[9]=("Hogar");
        array_pref[10]=("Juguetes");
        array_pref[11]=("Mascotas");
        array_pref[12]=("Salud y Belleza");
        array_pref[13]=("Video Juegos");
        array_pref[14]=("Regalos para El");
        array_pref[15]=("Regalos para Ella");

        if(modPref[position].getValue() == 1) {
            check.setChecked(true);
            //Toast.makeText(getContext(), modelItems[position].toString(), Toast.LENGTH_SHORT).show();
        }else
            check.setChecked(false);

  modPref = new ModeloPreferencia[16];
        "Audio",
        "Autos",
        "Libros",
        "Bebés",
        "Celulares",
        "Computadoras",
        "Deportes",
        "Electronica",
        "Electrodomésticos",
        "Hogar",
        "Juguetes",
        "Mascotas",
        "Salud y Belleza",
        "Video Juegos",
        "Regalos para El",
        "Regalos para Ella",