package applicate.com.sigma.applicate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;

public class FragmentLogin extends Fragment implements View.OnClickListener {

    public static final String CONFIGURACION = "configuracionApplicate";

    View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_fragment_login, container, false);
        Button bLogin = (Button) rootView.findViewById(R.id.button_login);
        bLogin.setOnClickListener(this);
        return rootView;
    }

    public void onClick(View v) {
        int idView = v.getId();
        switch (idView) {
            case R.id.button_login:
                redirectFragment();
                break;
        }
    }

    /**
     * Called when the user clicks the Login button
     */
    public void redirectFragment() {
        //Toast.makeText(getContext(), "HEY", Toast.LENGTH_SHORT).show();

        EditText mEdit = (EditText) rootView.findViewById(R.id.user_name);
        String sUserName = mEdit.getText().toString();
        //Log.v("EditText", mEdit.getText().toString());

        if (sUserName.equals("alumno")) {
            guardarTipo("alumno");

            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new FragmentHomeAlumno(), "fragment_alumno");
            ft.commit();
        } else if (sUserName.equals("profesor")) {
            guardarTipo("profesor");


            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new HomeProfesorFragment(), "fragment_profe");
            ft.commit();
        } else {
            Toast.makeText(getContext(), "Login incorrecto",Toast.LENGTH_LONG).show();
        }
    }

    public void guardarTipo(String tipo) {
        SharedPreferences prefs = getContext().getSharedPreferences(CONFIGURACION,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("tipo", tipo);
        editor.commit();
    }

}
