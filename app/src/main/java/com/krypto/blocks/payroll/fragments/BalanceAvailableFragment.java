package com.krypto.blocks.payroll.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.TextView;

import com.krypto.blocks.payroll.MainActivity;
import com.krypto.blocks.payroll.MapsActivity;
import com.krypto.blocks.payroll.R;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class BalanceAvailableFragment extends Fragment {
    ImageView send_instantly,invoice,pay_in_store,trnsfr_to_card;
    TextView sendmny_to_bank;
  Toolbar toolbar_balance;
    public void SendAmountFragment() {

        SendAmountFragment sendamountFragment = new SendAmountFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, sendamountFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void Send_to_bankFragment() {

        Send_to_bankFragment sendtobankFragment = new Send_to_bankFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, sendtobankFragment);
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


    public BalanceAvailableFragment() {
        // Required empty public constructor
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_balance_available, container, false);
        send_instantly = view.findViewById(R.id.snd_instant);
        toolbar_balance = view.findViewById(R.id.toolbar_balance);
        invoice = view.findViewById(R.id.submit_invoice);
        pay_in_store = view.findViewById(R.id.pay_in_store);
        trnsfr_to_card = view.findViewById(R.id.transfer_to_card);
        sendmny_to_bank = view.findViewById(R.id.sendmoney_to_bank);
        initToolBar();

        toolbar_balance.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_balance.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         exitdialog();


            }
        });
        sendmny_to_bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Send_to_bankFragment();
            }
        });

       invoice.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), MapsActivity.class);
               startActivity(intent);
           }
       });
        send_instantly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendAmountFragment();

            }
        });
        trnsfr_to_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             TransfertocardFragment();
            }
        });
        return view;
    }
    public void initToolBar() {

        //  toolbar_bitcoin = findViewById(R.id.toolbar_bit);
        toolbar_balance.setTitle(R.string.toolbar_for_balnce);
        toolbar_balance.setTitleTextColor(getResources().getColor(R.color.white));
        //setSupportActionBar(toolbar_bitcoin);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_balance);
    }

    private void exitdialog() {

        final MaterialDialog mMaterialDialog = new MaterialDialog(getContext());

        mMaterialDialog.setTitle("Logout");
        mMaterialDialog.setMessage("Are you sure want to Logout?");
        mMaterialDialog.setPositiveButton("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MainActivity.class);
                startActivity(i);
                //mMaterialDialog.dismiss();


            }
        });
        mMaterialDialog.setNegativeButton("CANCEL", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.dismiss();

            }
        });

        mMaterialDialog.show();

    }
}
