package ir.sooban.android.readerdemo;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by rajabzz on 7/12/15.
 */
public class BuyChargeFragment extends Fragment {

    public static final String CHARGE_AMOUNT = "ir.sooban.android.readerdemo.chargeAmount";

    private String chargeAmount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");
        View v = inflater.inflate(R.layout.buy_charge_fragment, container, false);

        TextView textView = (TextView) v.findViewById(R.id.buy_charge_textView);
        textView.setTypeface(typeface);

        Spinner spinner = (Spinner) v.findViewById(R.id.buy_charge_spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getActivity(), R.array.charge_available_values, R.layout.spinner_layout);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chargeAmount = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button buyButton = (Button) v.findViewById(R.id.buy_charge_button);
        buyButton.setTypeface(typeface);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chargeAmount != null) {
                    Intent i = new Intent(getActivity(), ConfirmChargeActivity.class);
                    i.putExtra(CHARGE_AMOUNT, chargeAmount);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        return v;
    }
}
