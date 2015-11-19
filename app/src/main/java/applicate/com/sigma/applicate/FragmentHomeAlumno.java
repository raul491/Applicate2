package applicate.com.sigma.applicate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


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
        /*LinearLayout botonEstadisticas = (LinearLayout) rootView.findViewById(R.id.botonEstadisticas);*/
        botonNotificaciones.setOnClickListener(this);
        botonBuscar.setOnClickListener(this);
        //botonEstadisticas.setOnClickListener(this);
        return inflater.inflate(R.layout.fragment_fragment_home_alumno, container, false);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.botonNotificaciones: intent = new Intent(getContext(),ActivityCrearNotificacion.class);
                break;
            case R.id.botonBuscar: intent = new Intent(getContext(), BuscarActivity.class);
                break;
            /*case R.id.botonEstadisticas: intent = new Intent(getContext(), ActivityGrafico.class);
                break;*/
        }
        startActivity(intent);
    }
}
