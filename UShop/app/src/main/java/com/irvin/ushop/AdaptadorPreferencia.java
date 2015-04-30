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

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irvin on 23/04/2015.
 */
public class AdaptadorPreferencia extends ArrayAdapter {
    ModeloPreferencia[] modPref = null;
    Context context;
    String query2;

    public AdaptadorPreferencia(Context context, ModeloPreferencia[] resource){
        super(context,R.layout.vista_preferencias,resource);
        this.context = context;
        this.modPref = resource;

        ParseQuery<ParseUser> query  = ParseUser.getQuery();
        query.whereEqualTo("username",ParseUser.getCurrentUser().getUsername());
        query.findInBackground(new FindCallback<ParseUser>() {
            public void done(List<ParseUser> preferenceObjects, com.parse.ParseException e) {
                if (e == null) {
                    Log.d("THE OBJECT", "" + preferenceObjects.size());
                    for (ParseObject object : preferenceObjects) {
                        String name = object.get("Preferences").toString();
                        Log.d("THE QUERY ", "" + name);
                    }
                } else {
                    Log.d("ERROR:", "" + e.getMessage());
                }
            }
        });
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

        final ArrayList<String> preference_array = new ArrayList<>();
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();
                if (isChecked) {
                    //modPref[position] = new ModeloPreferencia(modPref[position].getName().toString(),1);
                    Toast.makeText(getContext(), "Checkbox " + modPref[position].getName().toString() + " marcado!", Toast.LENGTH_SHORT).show();
                    //Log.d("Preferencias: ", pref[position].toString() + " Position: " + position);
                    preference_array.add(""+position+"");
                    Log.d("Array: ", preference_array.toString());
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
