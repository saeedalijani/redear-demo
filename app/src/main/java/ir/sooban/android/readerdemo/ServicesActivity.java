package ir.sooban.android.readerdemo;

import android.app.Fragment;

/**
 * Created by rajabzz on 7/7/15.
 */
public class ServicesActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ServicesFragment();
    }
}
