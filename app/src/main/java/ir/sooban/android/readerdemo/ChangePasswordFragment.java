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
import android.widget.TextView;

import org.w3c.dom.Text;

import ir.sooban.android.readerdemo.model.Password;

/**
 * Created by rajabzz on 7/9/15.
 */
public class ChangePasswordFragment extends Fragment {

    Password mPass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPass = Password.getInstance(getActivity(), "8080");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");
        View v = inflater.inflate(R.layout.change_password_fragment, container, false);

        final TextView errorTextView = (TextView) v.findViewById(R.id.change_password_errorTextField);
        errorTextView.setTypeface(typeface);
        errorTextView.setVisibility(View.INVISIBLE);

        final EditText oldPassEditText = (EditText) v.findViewById(R.id.old_pass_editText);
        oldPassEditText.setTypeface(typeface);

        final EditText newPassEditText = (EditText) v.findViewById(R.id.new_pass_editText);
        newPassEditText.setTypeface(typeface);

        final EditText newPassRepeatEditText = (EditText) v.findViewById(R.id.new_pass_repeat_editText);
        newPassRepeatEditText.setTypeface(typeface);

        Button button = (Button) v.findViewById(R.id.change_pass_button);
        button.setTypeface(typeface);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!oldPassEditText.getText().toString().equals(mPass.toString())) {
                    errorTextView.setText("رمز قبلی اشتباه وارد شده!");
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(getResources().getColor(R.color.red));
                    return;
                }
                if (!newPassEditText.getText().toString().equals(newPassRepeatEditText.getText().toString())) {
                    errorTextView.setText("رمز جدید و تکرار آن مطابقت ندارند!");
                    errorTextView.setTextColor(getResources().getColor(R.color.red));
                    errorTextView.setVisibility(View.VISIBLE);
                    return;
                }

                if (newPassEditText.getText().toString().length() != 4) {
                    errorTextView.setText("رمز جدید باید ۴ کاراکتر داشته باشد");
                    errorTextView.setTextColor(getResources().getColor(R.color.red));
                    errorTextView.setVisibility(View.VISIBLE);
                    return;
                }

                mPass.setPass(newPassEditText.getText().toString());
                errorTextView.setText("رمز با موفقیت تغییر کرد");
                errorTextView.setTextColor(getResources().getColor(R.color.green));
                errorTextView.setVisibility(View.VISIBLE);
            }
        });

        return v;
    }
}
