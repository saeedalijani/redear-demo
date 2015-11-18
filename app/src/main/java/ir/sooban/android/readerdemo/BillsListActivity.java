package ir.sooban.android.readerdemo;

import android.app.Fragment;

/**
 * Created by rajabzz on 7/13/15.
 */
public class BillsListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new BillsListFragment();
    }
}
