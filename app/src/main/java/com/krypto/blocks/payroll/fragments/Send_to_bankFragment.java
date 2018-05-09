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

import com.krypto.blocks.payroll.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Send_to_bankFragment extends Fragment {
    ImageView addaccnt;
    Toolbar toolbar_card;

    public void BalanceAvailableFragment() {

        BalanceAvailableFragment balanceAvailableFragment = new BalanceAvailableFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, balanceAvailableFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void TransfertocardFragment() {

        TransfertocardFragment transfertocardFragment = new  TransfertocardFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, transfertocardFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public Send_to_bankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_to_bank, container, false);
        addaccnt = view.findViewById(R.id.add_account_btn);
        toolbar_card = view.findViewById(R.id.toolbar_cardf);

        initToolBar();

        toolbar_card.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_card.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

         BalanceAvailableFragment();

            }
        });
        addaccnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransfertocardFragment();
            }
        });
        return view;
    }
    public void initToolBar() {

        //  toolbar_bitcoin = findViewById(R.id.toolbar_bit);
        toolbar_card.setTitle(R.string.toolbar_for_card);
        toolbar_card.setTitleTextColor(getResources().getColor(R.color.white));
        //setSupportActionBar(toolbar_bitcoin);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_card);
    }
}
