package ir.sooban.android.readerdemo;

import android.app.Fragment;

/**
 * Created by rajabzz on 7/12/15.
 */
public class ConfirmChargeActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ConfirmChargeFragment();
    }
}
