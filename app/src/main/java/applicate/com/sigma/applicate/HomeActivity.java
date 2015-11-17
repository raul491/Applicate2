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

        this.setContentView(R.layout.activity_home);

        // Add each fragment to our list.
        this._fragments.add(FRAGMENT_EXAMPLE, new Fragment1());
        this._fragments.add(FRAGMENT_EXAMPLE2, new Fragment_2());

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
                    case FRAGMENT_EXAMPLE:
                        return "Example title";
                    default:
                        return null;
                }
            }
        };

        //this._viewPager = (ViewPager) this.findViewById(R.id.pager);
        //this._viewPager.setAdapter(this._fragmentPagerAdapter);

        // Set the default fragment.
        this.openFragment(FRAGMENT_EXAMPLE);

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

