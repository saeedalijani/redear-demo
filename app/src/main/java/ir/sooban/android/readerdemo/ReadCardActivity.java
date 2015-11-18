package ir.sooban.android.readerdemo;

import android.app.Fragment;

/**
 * Created by rajabzz on 7/7/15.
 */
public class ReadCardActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ReadCardFragment();
    }
}
