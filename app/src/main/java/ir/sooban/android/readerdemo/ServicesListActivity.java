package ir.sooban.android.readerdemo;

import android.app.Fragment;


public class ServicesListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ServicesListFragment();
    }

}
