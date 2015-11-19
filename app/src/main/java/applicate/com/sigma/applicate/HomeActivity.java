package applicate.com.sigma.applicate;



import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends FragmentActivity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout

            SharedPreferences prefs = this.getSharedPreferences(FragmentLogin.CONFIGURACION,
                    Context.MODE_PRIVATE);
            String tipo = prefs.getString("tipo", "valor por defecto");
            Fragment firstFragment;
            if (tipo.equals("alumno")) {
                firstFragment = new FragmentHomeAlumno();
            } else if(tipo.equals("profesor")) {
                firstFragment = new HomeProfesorFragment();
            } else {
                firstFragment = new FragmentLogin();
            }

            //Fragment firstFragment3 = new HomeProfesorFragment();
            //Fragment firstFragment4 = new FragmentHomeAlumno();
            //Fragment firstFragment2 = new FragmentLogin();
            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            //firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }
        //View rootView2 = View.inflate(this,R.layout.fragment_fragment1, )



    }

    @Override
    public void onClick(View v) {
        int idV=v.getId();

        if (idV == R.id.button1) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();;

            Fragment newFragment = new Fragment_2();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

// Commit the transaction
            transaction.commit();
        }
    }
}

