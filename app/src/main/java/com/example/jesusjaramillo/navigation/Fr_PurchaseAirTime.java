package com.example.jesusjaramillo.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jesus.Jaramillo on 20/10/2015.
 */
public class Fr_PurchaseAirTime extends Fragment {

    public static final String TAG = Fr_PurchaseAirTime.class.getSimpleName();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.content_main2, container, false);

        return v;
    }

    public static Fr_PurchaseAirTime newInstance(android.support.v4.app.FragmentManager fragmentManager) {
        Fr_PurchaseAirTime resp= new Fr_PurchaseAirTime();
        return new Fr_PurchaseAirTime();
    }
}
