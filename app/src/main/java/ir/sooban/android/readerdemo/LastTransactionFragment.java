package ir.sooban.android.readerdemo;

import android.app.Fragment;
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
 * Created by rajabzz on 7/10/15.
 */
public class LastTransactionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");
        View v = inflater.inflate(R.layout.last_transaction_fragment, container, false);

        TextView balanceTextView = (TextView) v.findViewById(R.id.last_transaction_balanceTextView);
        balanceTextView.setTypeface(typeface);

        TextView balanceTextView2 = (TextView) v.findViewById(R.id.last_transaction_balanceTextView2);
        balanceTextView2.setTypeface(typeface);

        TextView historyTextView = (TextView) v.findViewById(R.id.last_transaction_historyTextView);
        historyTextView.setTypeface(typeface);

        TextView priceTextView = (TextView) v.findViewById(R.id.last_transaction_priceTextView);
        priceTextView.setTypeface(typeface);

        TextView transactionTextView = (TextView) v.findViewById(R.id.last_transaction_transactionsTextView);
        transactionTextView.setTypeface(typeface);

        Button tryAgainButton = (Button) v.findViewById(R.id.last_transaction_tryAgainButton);
        tryAgainButton.setTypeface(typeface);
        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast();
            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        makeToast();
    }

    private void makeToast() {
        Toast.makeText(getActivity(), "برای مشاهده نیاز به اتصال به درگاه بانکی است", Toast.LENGTH_LONG).show();
    }
}
