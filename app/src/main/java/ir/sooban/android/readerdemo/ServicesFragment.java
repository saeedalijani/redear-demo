package ir.sooban.android.readerdemo;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rajabzz on 7/7/15.
 */
public class ServicesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");

        View v = inflater.inflate(R.layout.services_list_fragment, container, false);

        TextView balanceTextView = (TextView) v.findViewById(R.id.service_list_balanceTextView);
        balanceTextView.setTypeface(typeface);

        TextView buyChargeTextView = (TextView) v.findViewById(R.id.service_list_chargeTextView);
        buyChargeTextView.setTypeface(typeface);

        TextView transferMoneyTextView = (TextView) v.findViewById(R.id.service_list_moneyTransferTextView);
        transferMoneyTextView.setTypeface(typeface);

        TextView lastTransactionTextView = (TextView) v.findViewById(R.id.service_list_lastTransactionTextView);
        lastTransactionTextView.setTypeface(typeface);

        TextView payBillsTextView = (TextView) v.findViewById(R.id.service_list_payBillsTextView);
        payBillsTextView.setTypeface(typeface);

        TextView changePassTextView = (TextView) v.findViewById(R.id.service_list_changePassTextview);
        changePassTextView.setTypeface(typeface);


        ImageView transferImageView = (ImageView) v.findViewById(R.id.service_list_moneyTransferImageView);
        transferImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MoneyTransferActivity.class);
                startActivity(i);
            }
        });

        ImageView changePassImageView = (ImageView) v.findViewById(R.id.service_list_changePassImageView);
        changePassImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ChangePasswordActivity.class);
                startActivity(i);
            }
        });

        ImageView payBillsImageView = (ImageView) v.findViewById(R.id.service_list_payBillsImageView);
        payBillsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BillsListActivity.class);
                startActivity(i);
            }
        });

        ImageView balanceImageView = (ImageView) v.findViewById(R.id.service_list_balanceImageView);
        balanceImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BalanceActivity.class);
                startActivity(i);
            }
        });

        ImageView lastTransactionImageView = (ImageView) v.findViewById(R.id.service_list_lastTransactionImageView);
        lastTransactionImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LastTransactionActivity.class);
                startActivity(i);
            }
        });

        ImageView chargeImageView = (ImageView) v.findViewById(R.id.service_list_chargeImageView);
        chargeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ChargeListActivity.class);
                startActivity(i);
            }
        });

        return v;
    }
}
