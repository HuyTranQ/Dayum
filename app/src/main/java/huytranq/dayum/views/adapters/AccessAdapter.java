package huytranq.dayum.views.adapters;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import huytranq.dayum.views.fragments.access.AccessFragment;
import huytranq.dayum.views.fragments.access.SignInFragment;
import huytranq.dayum.views.fragments.access.SignUpFragment;

/**
 * Created by huytr on 18-01-2016.
 */
public class AccessAdapter extends FragmentStatePagerAdapter {

    private Activity activity;

    public AccessAdapter(Activity activity ,
                         FragmentManager fm) {
        super(fm);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        return AccessFragment.create(activity , position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return "Sign In";
        else
            return "Sign Up";
    }
}
