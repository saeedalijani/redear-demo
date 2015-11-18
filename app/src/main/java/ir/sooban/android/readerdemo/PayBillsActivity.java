package ir.sooban.android.readerdemo;

import android.app.Activity;
import android.app.Fragment;

/**
 * Created by rajabzz on 7/9/15.
 */
public class PayBillsActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new PayBillsFragment();
    }
}
