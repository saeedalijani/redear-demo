package ir.sooban.android.readerdemo;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoneyTransferFragment extends Fragment {
    public static final String EXTRA_CARD_NUM = "ir.sooban.android.readerdemo.cardNum";
    public static final String EXTRA_MONEY_AMOUNT = "ir.sooban.android.readerdemo.moneyAmount";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");
        View v = inflater.inflate(R.layout.money_transfer_fragment, container, false);

        final TextView errorTextView = (TextView) v.findViewById(R.id.money_transfer_errorTextView);
        errorTextView.setTypeface(typeface);
        errorTextView.setVisibility(View.INVISIBLE);

        TextView rialTextView = (TextView) v.findViewById(R.id.money_transfer_rialTextView);
        rialTextView.setTypeface(typeface);

        final EditText moneyEditText = (EditText) v.findViewById(R.id.money_transfer_moneyAmtEditText);
        moneyEditText.addTextChangedListener(new TextWatcher() {

            boolean isManualChange = false;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isManualChange) {
                    isManualChange = false;
                    return;
                }

                isManualChange = true;
                if (s.toString().equals(""))
                    return;

                moneyEditText.setText(NumberFormat.getNumberInstance(Locale.US)
                        .format(Long.parseLong(s.toString().replace(",", ""))));
                moneyEditText.setSelection(moneyEditText.getText().length());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        moneyEditText.setTypeface(typeface);

        final EditText cardNumEditText = (EditText) v.findViewById(R.id.money_transfer_cardNumEditText);
        cardNumEditText.setTypeface(typeface);
        cardNumEditText.addTextChangedListener(new TextWatcher() {

            boolean isManualChange = false;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (isManualChange) {
                    isManualChange = false;
                    return;
                }

                isManualChange = true;
                if (s.toString().equals(""))
                    return;

                StringBuilder strBuilder = new StringBuilder(s.toString().replace("-", ""));
                int idx = strBuilder.length() - 4;

                while (idx > 0)
                {
                    strBuilder.insert(idx, "-");
                    idx = idx - 4;
                }


                cardNumEditText.setText(strBuilder.toString());
                cardNumEditText.setSelection(cardNumEditText.getText().length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // TODO check if the card number is valid or not field is empty or not

        Button button = (Button) v.findViewById(R.id.money_transfer_nextButton);
        button.setTypeface(typeface);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean hasError = false;

                if (cardNumEditText.getText().toString().length() == 0
                        && moneyEditText.getText().toString().length() == 0) {
                    errorTextView.setText(getString(R.string.error_both__fields_are_empty));
                    hasError = true;
                }

                else if (cardNumEditText.getText().toString().length() == 0) {
                    errorTextView.setText(getString(R.string.error_cardnum_is_empty));
                    hasError = true;
                }

                else if (moneyEditText.getText().toString().length() == 0) {
                    errorTextView.setText(getString(R.string.error_money_amount_is_empty));
                    hasError = true;
                }

                else if (cardNumEditText.getText().toString().length() != 19) {
                    errorTextView.setText(getString(R.string.error_invalid_cardnum));
                    hasError = true;
                }

                if (hasError) {
                    errorTextView.setVisibility(View.VISIBLE);
                    return;
                }

                Intent i = new Intent(getActivity(), TransferConfirmationActivity.class);
                i.putExtra(EXTRA_MONEY_AMOUNT, moneyEditText.getText().toString());
                i.putExtra(EXTRA_CARD_NUM, cardNumEditText.getText().toString());
                cardNumEditText.setText("");
                startActivity(i);
                getActivity().finish();
            }
        });

        return v;
    }
}
