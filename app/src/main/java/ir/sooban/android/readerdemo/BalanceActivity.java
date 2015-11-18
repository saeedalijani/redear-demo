package ir.sooban.android.readerdemo;

import android.app.Fragment;

/**
 * Created by rajabzz on 7/10/15.
 */
public class BalanceActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new BalanceFragment();
    }
}
