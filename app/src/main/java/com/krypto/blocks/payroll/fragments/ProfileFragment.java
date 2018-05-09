package com.krypto.blocks.payroll.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krypto.blocks.payroll.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    public void BalanceAvailableFragment() {

        BalanceAvailableFragment balanceAvailableFragment = new  BalanceAvailableFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, balanceAvailableFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void NotifyFragment() {

        NotifyFragment notifyFragment = new  NotifyFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, notifyFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    Toolbar toolbar_profile;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        toolbar_profile = view.findViewById(R.id.toolbar_profile);
        initToolBar();
        toolbar_profile.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_profile.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           // BalanceAvailableFragment();
                NotifyFragment();


            }
        });
        return view;
    }
    public void initToolBar() {

        //  toolbar_bitcoin = findViewById(R.id.toolbar_bit);
        toolbar_profile.setTitle(R.string.toolbar_for_balnce);
        toolbar_profile.setTitleTextColor(getResources().getColor(R.color.white));
        //setSupportActionBar(toolbar_bitcoin);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_profile);
    }
}
