package com.example.jesusjaramillo.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jesus.Jaramillo on 20/10/2015.
 */
public class Fr_PurchaseAirTime2 extends Fragment {

    public static final String TAG = Fr_PurchaseAirTime2.class.getSimpleName();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.content_main3, container, false);

        return v;
    }

    public static Fr_PurchaseAirTime2 newInstance(android.support.v4.app.FragmentManager fragmentManager) {
        Fr_PurchaseAirTime2 resp= new Fr_PurchaseAirTime2();
        return new Fr_PurchaseAirTime2();
    }
}
