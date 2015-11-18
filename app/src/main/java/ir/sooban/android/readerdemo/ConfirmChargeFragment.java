package ir.sooban.android.readerdemo;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rajabzz on 7/12/15.
 */
public class ConfirmChargeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");
        View v = inflater.inflate(R.layout.confirm_charge_fragment, container, false);

        TextView firstTextView = (TextView) v.findViewById(R.id.confirm_charge_firstTextView);
        firstTextView.setTypeface(typeface);

        TextView chargeAmountTextView = (TextView) v.findViewById(R.id.confirm_charge_chargeAmountTextView);
        chargeAmountTextView.setTypeface(typeface);
        chargeAmountTextView.setText(getActivity().getIntent().getStringExtra(BuyChargeFragment.CHARGE_AMOUNT));

        TextView lastTextView = (TextView) v.findViewById(R.id.confirm_charge_lastTextView);
        lastTextView.setTypeface(typeface);

        Button yesButton = (Button) v.findViewById(R.id.confirm_charge_yesButton);
        yesButton.setTypeface(typeface);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ادامه‌ی فرآیند خرید شارژ نیاز به اتصال به درگاه بانکی دارد", Toast.LENGTH_LONG).show();
            }
        });

        Button noButton = (Button) v.findViewById(R.id.confirm_charge_noButton);
        noButton.setTypeface(typeface);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BuyChargeActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        return v;
    }
}
