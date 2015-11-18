package ir.sooban.android.readerdemo;

import android.app.Fragment;

/**
 * Created by rajabzz on 7/9/15.
 */
public class ChangePasswordActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new ChangePasswordFragment();
    }
}
