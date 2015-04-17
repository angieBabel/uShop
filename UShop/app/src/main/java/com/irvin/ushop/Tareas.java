package com.irvin.ushop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayDeque;
import java.util.zip.Inflater;

/**
 * Created by Irvin on 14/04/2015.
 */
public class Tareas extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tareas, container, false);
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

                        ParseObject tsk = new ParseObject("Task");
                        tsk.put("taskname",inputField.getText().toString());
                        tsk.put("User",currentUser.toString());
                        tsk.saveInBackground();


                    }
                });

                builder.setNegativeButton("Cancelar", null);

                builder.create().show();

            default:
                return super.onContextItemSelected(item);
        }

    }
}
