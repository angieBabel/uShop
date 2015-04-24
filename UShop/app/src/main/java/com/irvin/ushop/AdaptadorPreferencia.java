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
 * Created by Irvin on 23/04/2015.
 */
public class AdaptadorPreferencia extends ArrayAdapter {
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
        CheckBox check = (CheckBox) convertView.findViewById(R.id.check_preferencia);

        name.setText(modPref[position].getName());

        /*if(modelItems[position].getValue() == 1) {
            cb.setChecked(true);
            //Toast.makeText(getContext(), modelItems[position].toString(), Toast.LENGTH_SHORT).show();
        }else
            cb.setChecked(false);
*/
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();
                if (isChecked) {
                    Toast.makeText(getContext(), "Checkbox " + modPref[position].getName().toString() + " marcado!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(), "Checkbox " + modPref[position].getName().toString() + " desmarcado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return convertView;
    }
}
