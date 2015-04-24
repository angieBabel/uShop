package com.irvin.ushop;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Irvin on 20/04/2015.
 */
public class AdaptadorTareas extends ArrayAdapter<ModeloTarea> {
    ModeloTarea[] tItems = null;
    Context context;

    public AdaptadorTareas(Context context, ModeloTarea[] tareas) {
        super(context, R.layout.vista_tareas,tareas);
        // Auto-generated constructor stub
        this.context = context;
        this.tItems = tareas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Auto-generated method stub
        ModeloTarea tsk = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_tareas,parent,false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.taskTextView);
        name.setText(tItems[position].getName());
        return convertView;
    }
}
