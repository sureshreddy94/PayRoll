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
import android.widget.ImageView;
import android.widget.TextView;

import com.krypto.blocks.payroll.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectAccountFragment extends Fragment {

    public void BalanceAvailableFragment() {

        BalanceAvailableFragment balanceAvailableFragment = new BalanceAvailableFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, balanceAvailableFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void SendAmountFragment() {

        SendAmountFragment sendamountFragment = new SendAmountFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, sendamountFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private TextView amnt;
    ImageView send;
    Toolbar toolbar_select_account;

    public SelectAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_account, container, false);
        amnt = view.findViewById(R.id.amount);
        send = view.findViewById(R.id.send_white);
        toolbar_select_account = view.findViewById(R.id.toolbar_select_account);
        initToolBar();
        toolbar_select_account.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_select_account.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SendAmountFragment();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BalanceAvailableFragment();
            }
        });

        //retrieving data using bundle
        Bundle bundle=getArguments();
        amnt.setText(String.valueOf(bundle.getString("amnt")));
        return view;
    }
    public void initToolBar() {

        //  toolbar_bitcoin = findViewById(R.id.toolbar_bit);
        toolbar_select_account.setTitle(R.string.toolbar_for_selct_account);
        toolbar_select_account.setTitleTextColor(getResources().getColor(R.color.white));
        //setSupportActionBar(toolbar_bitcoin);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_select_account);
    }
}
