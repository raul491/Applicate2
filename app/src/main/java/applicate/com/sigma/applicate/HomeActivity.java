package applicate.com.sigma.applicate;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends FragmentActivity {
    /**
     * Identifier for the example fragment.
     */
    public static final int FRAGMENT_EXAMPLE = 1;
    public static final int FRAGMENT_EXAMPLE2 = 2;

    /**
     * The adapter definition of the fragments.
     */
    private FragmentPagerAdapter _fragmentPagerAdapter;

    /**
     * The ViewPager that hosts the section contents.
     */
    private ViewPager _viewPager;

    /**
     * List of fragments.
     */
    private List<Fragment> _fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.fragment_fragment_login);


    }

    public void test() {
        // Add each fragment to our list.
        this._fragments.add(new Fragment1());
        this._fragments.add(new Fragment_2());

        // Setup the fragments, defining the number of fragments, the screens and titles.
        this._fragmentPagerAdapter = new FragmentPagerAdapter(this.getSupportFragmentManager()){
            @Override
            public int getCount() {
                return HomeActivity.this._fragments.size();
            }
            @Override
            public Fragment getItem(final int position) {
                return HomeActivity.this._fragments.get(position);
            }
            @Override
            public CharSequence getPageTitle(final int position) {
                // Define titles for each fragment.
                switch (position) {
                    case 0:
                        return "Example title";
                    default:
                        return null;
                }
            }
        };

        this._viewPager = (ViewPager) this.findViewById(R.id.pager1);
        this._viewPager.setAdapter(this._fragmentPagerAdapter);
        this._viewPager.setCurrentItem(0);
        // Set the default fragment.
        this.openFragment(0);

    }
    /**
     * Open the specified fragment.
     * @param fragment
     */
    public void openFragment(final int fragment) {
        this._viewPager.setCurrentItem(fragment);
    }

    /**
     * Get the fragment object for the specified fragment.
     * @param fragment
     * @return
     */
    public Fragment getFragment(final int fragment) {
        return this._fragments.get(fragment);
    }

}

