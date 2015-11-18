package ir.sooban.android.readerdemo;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by rajabzz on 7/9/15.
 */
public class PayBillsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");
        View v = inflater.inflate(R.layout.pay_bills_fragment, container, false);

        EditText billIdEditText = (EditText) v.findViewById(R.id.pay_bills_billId);
        billIdEditText.setTypeface(typeface);

        EditText payIdEditText = (EditText) v.findViewById(R.id.pay_bills_payId);
        payIdEditText.setTypeface(typeface);

        Button payButton = (Button) v.findViewById(R.id.pay_bills_payButton);
        payButton.setTypeface(typeface);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "برای انجام عملیات نیاز به اتصال به درگاه بانکی است", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
