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

/**
 * Created by Irvin on 20/04/2015.
 */
public class Adaptador_tareas extends ArrayAdapter {
    Model[] modelItems = null;
    Context context;

    public Adaptador_tareas(Context context, Model[] resource) {
        super(context, R.layout.vista_tareas,resource);
        // Auto-generated constructor stub
        this.context = context;
        this.modelItems = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Auto-generated method stub
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.vista_tareas, parent, false);

        TextView name = (TextView) convertView.findViewById(R.id.text_preferencia);

        name.setText(modelItems[position].getName());

        return convertView;
    }
}
