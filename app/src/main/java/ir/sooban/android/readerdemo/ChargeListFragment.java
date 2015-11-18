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
 * Created by rajabzz on 7/12/15.
 */
public class ChargeListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");

        View v = inflater.inflate(R.layout.charge_list_fragment, container, false);

        TextView irancellTextView = (TextView) v.findViewById(R.id.charge_list_irancellTextView);
        irancellTextView.setTypeface(typeface);

        TextView hamraheAvalTextView = (TextView) v.findViewById(R.id.charge_list_hamraheAvalTextView);
        hamraheAvalTextView.setTypeface(typeface);

        TextView rightelTextView = (TextView) v.findViewById(R.id.charge_list_rightelTextView);
        rightelTextView.setTypeface(typeface);

        TextView taliaTextView = (TextView) v.findViewById(R.id.charge_list_taliaTextView);
        taliaTextView.setTypeface(typeface);


        ImageView irancellImageView = (ImageView) v.findViewById(R.id.charge_list_irancellImageView);
        irancellImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BuyChargeActivity.class);
                startActivity(i);
            }
        });

        ImageView hamraheAvalImageView = (ImageView) v.findViewById(R.id.charge_list_hamraheAvalImageView);
        hamraheAvalImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BuyChargeActivity.class);
                startActivity(i);
            }
        });

        ImageView rightelImageView = (ImageView) v.findViewById(R.id.charge_list_rightelImageView);
        rightelImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BuyChargeActivity.class);
                startActivity(i);
            }
        });

        ImageView taliaImageView = (ImageView) v.findViewById(R.id.charge_list_taliaImageView);
        taliaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BuyChargeActivity.class);
                startActivity(i);
            }
        });


        return v;
    }

}
