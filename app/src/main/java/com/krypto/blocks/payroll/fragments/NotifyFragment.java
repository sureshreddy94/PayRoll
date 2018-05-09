package com.krypto.blocks.payroll.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.krypto.blocks.payroll.JobCompletionReportActivity;
import com.krypto.blocks.payroll.R;
import com.krypto.blocks.payroll.WeeklySummaryActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotifyFragment extends Fragment {
    public void BalanceAvailableFragment() {

        BalanceAvailableFragment balanceAvailableFragment = new BalanceAvailableFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, balanceAvailableFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

LinearLayout notify,mail_notify,bit_notify,bit_mail_notify;
    public NotifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notify, container, false);
        notify =view.findViewById(R.id.notify);
        mail_notify = view.findViewById(R.id.mailnotify);
        bit_notify = view.findViewById(R.id.bitnotify);
        bit_mail_notify = view.findViewById(R.id.bitmailnotify);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               BalanceAvailableFragment();
            }
        });
        mail_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),WeeklySummaryActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        bit_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),WeeklySummaryActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        bit_mail_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),WeeklySummaryActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        return view;
    }

}
