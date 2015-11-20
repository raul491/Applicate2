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
        botonLogout.setOnClickListener(this);
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


        switch(v.getId()){
            case R.id.botonNotificaciones:
                Intent intent = new Intent(getContext(),ActivityCrearNotificacion.class);
                startActivity(intent);
                break;
            case R.id.botonBuscar:
                Intent intent2 = new Intent(getContext(), BuscarActivity.class);
                startActivity(intent2);
                break;
            case R.id.botonEstadisticas:
                Intent intent3 = new Intent(getContext(), GraficoAlumno.class);
                startActivity(intent3);
                break;
            case R.id.botonLogout:
                borrarTipo();
                Intent intent4 = new Intent (getContext(), HomeActivity.class);
                startActivity(intent4);
                this.getActivity().finish();
                break;

        }

    }
}
