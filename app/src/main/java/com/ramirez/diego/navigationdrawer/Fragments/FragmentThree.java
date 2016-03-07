package com.ramirez.diego.navigationdrawer.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramirez.diego.navigationdrawer.R;

/**
 * Created by Diego on 06/03/2016.
 */
public class FragmentThree extends Fragment {

    View rootView;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_three,container,false);

        return rootView;
    }
}
