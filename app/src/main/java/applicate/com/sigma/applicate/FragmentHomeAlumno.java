package applicate.com.sigma.applicate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


public class FragmentHomeAlumno extends Fragment implements View.OnClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_home_alumno, container, false);
        LinearLayout botonNotificaciones = (LinearLayout) rootView.findViewById(R.id.botonNotificaciones);
        LinearLayout botonBuscar = (LinearLayout) rootView.findViewById(R.id.botonBuscar);
        LinearLayout botonEstadisticas = (LinearLayout) rootView.findViewById(R.id.botonEstadisticas);
        LinearLayout botonLogout = (LinearLayout) rootView.findViewById(R.id.botonLogout);
        botonNotificaciones.setOnClickListener(this);
        botonBuscar.setOnClickListener(this);
        botonEstadisticas.setOnClickListener(this);
        return rootView;
    }
    public void borrarTipo() {
        SharedPreferences prefs = getContext().getSharedPreferences(FragmentLogin.CONFIGURACION,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("tipo", "");
        editor.commit();
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;
        switch(v.getId()){
            case R.id.botonNotificaciones: intent = new Intent(getContext(),ActivityCrearNotificacion.class);
                break;
            case R.id.botonBuscar: intent = new Intent(getContext(), BuscarActivity.class);
                break;
            case R.id.botonEstadisticas: intent = new Intent(getContext(), ActivityGrafico.class);
                break;
            case R.id.botonLogout:
                borrarTipo();
                intent = new Intent (getContext(), HomeActivity.class);
                break;

        }
        startActivity(intent);
    }
}
