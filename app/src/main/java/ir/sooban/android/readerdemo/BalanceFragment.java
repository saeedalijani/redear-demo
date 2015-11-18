package ir.sooban.android.readerdemo;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rajabzz on 7/10/15.
 */
public class BalanceFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");
        View v = inflater.inflate(R.layout.balance_fragment, container, false);

        TextView accNumTextView1 = (TextView) v.findViewById(R.id.balance_accNumTextView);
        accNumTextView1.setTypeface(typeface);

        TextView accNumTextView2 = (TextView) v.findViewById(R.id.balance_accNumTextView2);
        accNumTextView2.setTypeface(typeface);

        TextView balanceTextView1 = (TextView) v.findViewById(R.id.balance_balanceTextView);
        balanceTextView1.setTypeface(typeface);

        TextView balanceTextView2 = (TextView) v.findViewById(R.id.balance_balanceTextView2);
        balanceTextView2.setTypeface(typeface);

        TextView historyTextView1 = (TextView) v.findViewById(R.id.balance_historyTextView);
        historyTextView1.setTypeface(typeface);

        TextView historyTextView2 = (TextView) v.findViewById(R.id.balance_historyTextView2);
        historyTextView2.setTypeface(typeface);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "برای مشاهده نیاز به اتصال به درگاه بانکی است", Toast.LENGTH_LONG).show();
    }
}
