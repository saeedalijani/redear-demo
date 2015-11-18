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
import android.widget.EditText;
import android.widget.TextView;

import ir.sooban.android.readerdemo.model.Password;

/**
 * Created by rajabzz on 7/6/15.
 */
public class EnterPassFragment extends Fragment {
    Password mPass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPass = Password.getInstance(getActivity(), "8080");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.enter_pass_fragment, container, false);

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");

        final TextView errorTextView = (TextView) v.findViewById(R.id.enter_pass_passwIsWrongTextView);
        errorTextView.setVisibility(View.INVISIBLE);

        TextView textView = (TextView) v.findViewById(R.id.enter_pass_fragment_textView);
        textView.setTypeface(typeface);

        final EditText editText = (EditText) v.findViewById(R.id.enter_pass_fragment_editText);

        // TODO check if the field is empty

        Button button = (Button) v.findViewById(R.id.enter_pass_fragment_nextButton);
        button.setTypeface(typeface);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorTextView.setVisibility(View.INVISIBLE);
                if (editText.getText().toString().equals(mPass.toString())) {
                    editText.setText("");
                    Intent i = new Intent(getActivity(), ServicesActivity.class);
                    startActivity(i);
                    getActivity().finish();
                } else {
                    errorTextView.setVisibility(View.VISIBLE);
                    editText.setText("");
                }
            }
        });

        return v;
    }
}
