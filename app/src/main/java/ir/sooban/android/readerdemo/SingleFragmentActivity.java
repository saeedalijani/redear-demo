package ir.sooban.android.readerdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public abstract class SingleFragmentActivity extends ActionBarActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getFragmentManager();

        if (fm.findFragmentById(R.id.activity_fragment_fragmentContainer) == null) {
            fm.beginTransaction().add(R.id.activity_fragment_fragmentContainer, createFragment()).commit();
        }
    }
}
