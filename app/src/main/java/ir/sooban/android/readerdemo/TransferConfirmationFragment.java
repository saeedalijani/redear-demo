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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by rajabzz on 7/6/15.
 */
public class TransferConfirmationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");
        View v = inflater.inflate(R.layout.transfer_confirm_fragment, container, false);

        Intent i = getActivity().getIntent();

        TextView textView = (TextView) v.findViewById(R.id.transfer_confirm_textView);
        textView.setTypeface(typeface);
        textView.setText(getString(R.string.confirm_1)
                + " " + i.getStringExtra(MoneyTransferFragment.EXTRA_MONEY_AMOUNT)
                + " " + getString(R.string.rial)
                + "\n"
                + " " + getString(R.string.confirm_2));

        TextView cardNumTextView = (TextView) v.findViewById(R.id.transfer_confirm_cardNumTextView);
        cardNumTextView.setTypeface(typeface);
        cardNumTextView.setText(i.getStringExtra(MoneyTransferFragment.EXTRA_CARD_NUM));

        TextView lastTextView = (TextView) v.findViewById(R.id.transfer_confirm_lastTextView);
        lastTextView.setTypeface(typeface);
        lastTextView.setText(getString(R.string.confirm_3));

        Button yesButton = (Button) v.findViewById(R.id.transfer_confirm_yesButton);
        yesButton.setTypeface(typeface);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "برای ادامه‌ی فرآیند نیاز به اتصال به درگاه بانکی است", Toast.LENGTH_SHORT).show();
            }
        });

        Button noButton = (Button) v.findViewById(R.id.transfer_confirm_noButton);
        noButton.setTypeface(typeface);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MoneyTransferActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        return v;
    }
}
