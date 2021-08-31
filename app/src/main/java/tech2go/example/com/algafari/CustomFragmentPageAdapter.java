package tech2go.example.com.algafari;

/**
 * Created by AYMAN MNSOR on 4/16/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.transition.TransitionInflater;

public class CustomFragmentPageAdapter extends FragmentPagerAdapter{
    private static final String TAG = CustomFragmentPageAdapter.class.getSimpleName();
    private static final int FRAGMENT_COUNT = 5;
    public CustomFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MirrorFragment1();
            case 1:
                return new MirrorFragment2();
            case 2:
                return new MirrorFragment3();
            case 3:
                return new MirrorFragment4();
            case 4:
                return new MirrorFragment5();
        }
        return null;
    }
    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "";
            case 1:
                return "";
        }
        return null;
    }
}
