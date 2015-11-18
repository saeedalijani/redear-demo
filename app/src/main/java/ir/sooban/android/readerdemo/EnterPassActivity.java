package ir.sooban.android.readerdemo;

import android.app.Fragment;

/**
 * Created by rajabzz on 7/6/15.
 */
public class EnterPassActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new EnterPassFragment();
    }
}
