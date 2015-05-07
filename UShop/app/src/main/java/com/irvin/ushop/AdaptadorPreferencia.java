package com.irvin.ushop;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Irvin on 06/05/2015.
 */
public class AdaptadorPreferencia extends ArrayAdapter{
        ModeloPreferencia[] modPref = null;
        Context context;

        public AdaptadorPreferencia(Context context, ModeloPreferencia[] resource){
            super(context,R.layout.vista_preferencias,resource);
            this.context = context;
            this.modPref = resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.vista_preferencias, parent, false);

            TextView name = (TextView) convertView.findViewById(R.id.text_preferencia);
            //CheckBox cb = (CheckBox) convertView.findViewById(R.id.check_preferencia);
            final CheckBox check = (CheckBox) convertView.findViewById(R.id.check_preferencia);

            name.setText(modPref[position].getName());

            if(modPref[position].getValue() == 1) {
                check.setChecked(true);
                //Toast.makeText(getContext(), modelItems[position].toString(), Toast.LENGTH_SHORT).show();
            }else
                check.setChecked(false);

            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isChecked = ((CheckBox)view).isChecked();

                    ParseUser now = new ParseUser();
                    ArrayList nueva = (ArrayList) now.get("Preferences");
                    JSONArray myArray = now.getJSONArray("Preferences");

                    if (isChecked) {
                            try {
                                myArray.put(position);
                                nueva.add(myArray.getString(position));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        now.put("Preferences", nueva);
                        now.saveInBackground();

                        Toast.makeText(getContext(), "Checkbox " + modPref[position].getName().toString() + " marcado!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //modPref[position] = new ModeloPreferencia(modPref[position].getName().toString(),0);
                        Toast.makeText(getContext(), "Checkbox " + modPref[position].getName().toString() + " desmarcado!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return convertView;
        }
    }
    /*public void onListItemClick(ListView parent, View view, int position, long id){
        CheckedTextView item = (CheckedTextView) view;
        Toast.makeText(this.getActivity(), city[position] + " cheked: " + item.isChecked(), Toast.LENGTH_SHORT).show();
    }*/
