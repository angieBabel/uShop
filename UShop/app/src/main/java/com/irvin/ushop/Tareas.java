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

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;

/**
 * Created by Irvin on 14/04/2015.
 */
public class Tareas extends Fragment {

    ListView lista_tareas;
    Model[] Items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tareas, container, false);

        lista_tareas = (ListView) rootView.findViewById(R.id.listTask);

        Items = new Model[100];

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
        query.whereEqualTo("user", user);
        query.findInBackground(new FindCallback<ParseObject>() {

        });

        CustomAdapter adapter = new CustomAdapter(this.getActivity(), Items);
        lista_tareas.setAdapter(adapter);

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
