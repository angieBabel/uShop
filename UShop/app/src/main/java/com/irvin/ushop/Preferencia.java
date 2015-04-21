package com.irvin.ushop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by Irvin on 27/03/2015.
 */
public class Preferencia extends Fragment {

    ListView lista_preferencias;
    Model[] modelItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_preferencia, container, false);

        lista_preferencias = (ListView) rootView.findViewById(R.id.list_preferencias);

        modelItems = new Model[16];
        modelItems[0]= new Model ("Audio",0);
        modelItems[1]= new Model ("Autos",0);
        modelItems[2]= new Model ("Libros",0);
        modelItems[3]= new Model ("Bebés",0);
        modelItems[4]= new Model ("Celulares",0);
        modelItems[5]= new Model ("Computadoras",0);
        modelItems[6]= new Model ("Deportes",0);
        modelItems[7]= new Model ("Electronica",0);
        modelItems[8]= new Model ("Electrodomésticos",0);
        modelItems[9]= new Model ("Hogar",0);
        modelItems[10]= new Model ("Juguetes",0);
        modelItems[11]= new Model ("Mascotas",0);
        modelItems[12]= new Model ("Salud y Belleza",0);
        modelItems[13]= new Model ("Video Juegos",0);
        modelItems[14]= new Model ("Regalos para El",0);
        modelItems[15]= new Model ("Regalos para Ella",0);

        CustomAdapter adapter = new CustomAdapter(this.getActivity(), modelItems);
        lista_preferencias.setAdapter(adapter);

        //ArrayAdapter adaptador = new ArrayAdapter (this.getActivity(), android.R.layout.simple_list_item_1, preferencias);

        //lista_preferencias = (ListView) rootView.findViewById(R.id.list_preferencias);
        //lista_preferencias.setAdapter(adaptador);

        return rootView;
    }
}