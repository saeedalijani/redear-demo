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
 * Created by rajabzz on 7/13/15.
 */
public class BillsListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");

        View v = inflater.inflate(R.layout.bills_list_fragment, container, false);

        TextView gasTextView = (TextView) v.findViewById(R.id.bills_list_gasTextView);
        gasTextView.setTypeface(typeface);

        TextView elecTextView = (TextView) v.findViewById(R.id.bills_list_electTextView);
        elecTextView.setTypeface(typeface);

        TextView telTextView = (TextView) v.findViewById(R.id.bills_list_telTextView);
        telTextView.setTypeface(typeface);

        TextView waterTextView = (TextView) v.findViewById(R.id.bills_list_waterTextView);
        waterTextView.setTypeface(typeface);


        ImageView gasImageView = (ImageView) v.findViewById(R.id.bills_list_gasImageView);
        gasImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PayBillsActivity.class);
                startActivity(i);
            }
        });

        ImageView elecImageView = (ImageView) v.findViewById(R.id.bills_list_electImageView);
        elecImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PayBillsActivity.class);
                startActivity(i);
            }
        });

        ImageView telImageView = (ImageView) v.findViewById(R.id.bills_list_telImageView);
        telImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PayBillsActivity.class);
                startActivity(i);
            }
        });

        ImageView waterImageView = (ImageView) v.findViewById(R.id.bills_list_waterImageView);
        waterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PayBillsActivity.class);
                startActivity(i);
            }
        });

        return v;
    }
}
