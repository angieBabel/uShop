package com.irvin.ushop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Irvin on 27/03/2015.
 */
public class Usuario extends Fragment {

    ListView liTareas;
    private ArrayList<String> arTsk = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_usuario, container, false);

        ParseUser user = ParseUser.getCurrentUser();
        String username = user.getUsername();

/*        TextView tv = (TextView) rootView.findViewById(R.id.userName);
        tv.setText(username.toString());*/

/*
        liTareas = (ListView) rootView.findViewById(R.id.liUserPref);
        final ArrayAdapter adaptador = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_expandable_list_item_1, arTsk);
        liTareas.setAdapter(adaptador);*/

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
        ParseUser user1 = ParseUser.getCurrentUser();
        query.whereEqualTo("user", user1);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if (e == null) {
                    for (ParseObject parseObject : objects){
                        String tarea;
                        tarea = parseObject.get("taskname").toString();
                        arTsk.add(tarea);
                        /*adaptador.notifyDataSetChanged();*/
                    }
                } else {
                    // Something went wrong.
                    Toast.makeText(getActivity(), "Error: " + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("movie", "The Matrix");
        ParseCloud.callFunctionInBackground("averageStars", params, new FunctionCallback<Float>() {
            void done(Float ratings, ParseException e) {
                if (e == null) {
                    // ratings is 4.5
                }
            }
        });
        */

        return rootView;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
