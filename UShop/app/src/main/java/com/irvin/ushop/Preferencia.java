package com.irvin.ushop;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Irvin on 27/03/2015.
 */
public class Preferencia extends Fragment {
    ListView lista_preferencias;
    ModeloPreferencia[] modPref;
    private ArrayList<String> array_pref = new ArrayList<>();
    //String[] array_pref = new String[16];

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

        final AdaptadorPreferencia adapter = new AdaptadorPreferencia(this.getActivity(), modPref);
        lista_preferencias.setAdapter(adapter);

        return rootView;
    }
}