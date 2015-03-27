package com.irvin.ushop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Irvin on 27/03/2015.
 */
public class Usuario extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_usuario, container, false);
        return rootView;
    }
}
