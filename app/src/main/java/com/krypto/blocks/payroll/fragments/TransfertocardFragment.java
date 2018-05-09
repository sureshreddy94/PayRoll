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
import android.widget.Button;
import android.widget.TextView;

import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;
import com.krypto.blocks.payroll.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransfertocardFragment extends Fragment {
    public void BalanceAvailableFragment() {

        BalanceAvailableFragment balanceAvailableFragment = new BalanceAvailableFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, balanceAvailableFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void PaysuccessFragment() {

        PaysuccessFragment paysuccessFragment = new  PaysuccessFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, paysuccessFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    Toolbar toolbar_cardd;

    public TransfertocardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transfertocard, container, false);
        CardForm cardForm = view.findViewById(R.id.credit_card_form);
        TextView textDes = view.findViewById(R.id.payment_amount);
        Button btnPay = view.findViewById(R.id.btn_pay);


        textDes.setText("Visa");
        btnPay.setText(String.format("payer %s",textDes.getText()));
        toolbar_cardd = view.findViewById(R.id.toolbar_addcard);
        initToolBar();
        toolbar_cardd.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_cardd.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BalanceAvailableFragment();

            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaysuccessFragment();

            }
        });

        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {

          PaysuccessFragment();

            }
        });
        return view;
    }
    public void initToolBar() {
        toolbar_cardd.setTitle(R.string.toolbar_for_credit);
        toolbar_cardd.setTitleTextColor(getResources().getColor(R.color.white));
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_cardd);
    }
}
