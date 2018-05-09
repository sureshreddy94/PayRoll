package com.krypto.blocks.payroll.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.krypto.blocks.payroll.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaysuccessFragment extends Fragment {

    public void BalanceAvailableFragment() {

        BalanceAvailableFragment balanceAvailableFragment = new  BalanceAvailableFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, balanceAvailableFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    TextView payok;

    public PaysuccessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_paysuccess, container, false);
        payok = view.findViewById(R.id.pay_ok);
        payok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BalanceAvailableFragment();

            }
        });
        return view;
    }

}
