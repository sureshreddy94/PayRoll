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
import android.widget.EditText;
import android.widget.ImageView;

import com.krypto.blocks.payroll.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendAmountFragment extends Fragment {

    public void BalanceAvailableFragment() {

        BalanceAvailableFragment balanceAvailableFragment = new BalanceAvailableFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, balanceAvailableFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    ImageView send;
    EditText amnt;
    private String msend;
    Toolbar toolbar_sndamnt;


    public SendAmountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_amount, container, false);

        send = view.findViewById(R.id.send);
        amnt =view.findViewById(R.id.amnt);
        toolbar_sndamnt = view.findViewById(R.id.toolbar_sendamount);
        initToolBar();

        toolbar_sndamnt.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_sndamnt.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BalanceAvailableFragment();

            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msend = amnt.getText().toString();

                FragmentTransaction transection=getFragmentManager().beginTransaction();
                SelectAccountFragment selectAccountFragment=new SelectAccountFragment();

                //using Bundle to send data
                Bundle bundle=new Bundle();
                bundle.putString("amnt",msend);
                selectAccountFragment.setArguments(bundle); //data being send to SecondFragment
                transection.replace(R.id.content_frame, selectAccountFragment);
                transection.commit();

            }
        });
        return view;
    }
    public void initToolBar() {

        //  toolbar_bitcoin = findViewById(R.id.toolbar_bit);
        toolbar_sndamnt.setTitle(R.string.toolbar_for_sendamount);
        toolbar_sndamnt.setTitleTextColor(getResources().getColor(R.color.white));
        //setSupportActionBar(toolbar_bitcoin);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_sndamnt);
    }
}
