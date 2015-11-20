package applicate.com.sigma.applicate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class HomeProfesorFragment extends Fragment implements View.OnClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home_profesor, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.listAlumnos);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm
        );

        ImageButton botonCrearNotificaciones = (ImageButton) rootView.findViewById(R.id.buttonMenuNotificaciones);
        botonCrearNotificaciones.setOnClickListener(this);
        ImageButton botonBuscar = (ImageButton) rootView.findViewById(R.id.buttonMenuBuscar);
        botonBuscar.setOnClickListener(this);
        ImageButton botonEstadisticas= (ImageButton) rootView.findViewById(R.id.buttonMenuEstadisticas);
        botonEstadisticas.setOnClickListener(this);


        List<Alumno> listAlumnos = new ArrayList<>();


        Alumno a1 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "dentro", "");
        Alumno a2 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "dentro", "");
        Alumno a3 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "dentro", "");
        Alumno a4 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "dentro", "");
        Alumno a5 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "dentro", "");
        Alumno a6 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "dentro", "");
        Alumno a7 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "dentro", "");
        Alumno a8 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "dentro", "");
        Alumno a9 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "dentro", "");
        Alumno a10 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "fuera", "");
        Alumno a11 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "fuera", "");
        Alumno a12 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "fuera", "");
        Alumno a13 = new Alumno("Nombre", "Apellido 1", "Apellido 2", "ausencia", "");

        listAlumnos.add(a1);
        listAlumnos.add(a2);
        listAlumnos.add(a3);
        listAlumnos.add(a4);
        listAlumnos.add(a5);
        listAlumnos.add(a6);
        listAlumnos.add(a7);
        listAlumnos.add(a8);
        listAlumnos.add(a9);
        listAlumnos.add(a10);
        listAlumnos.add(a11);
        listAlumnos.add(a12);
        listAlumnos.add(a13);

        AdaptadorListaAlumnos adaptador = new AdaptadorListaAlumnos(listAlumnos);

        rv.setAdapter(adaptador);
        adaptador.setControl(true);

        return rootView;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonMenuNotificaciones:
                Intent intent = new Intent(getContext(),ActivityCrearNotificacion.class);
                startActivity(intent);
                break;
            case R.id.buttonMenuBuscar:
                Intent intent2 = new Intent(getContext(),BuscarActivity.class);
                startActivity(intent2);
                break;
            case R.id.buttonMenuEstadisticas:
                Intent intent3 = new Intent(getContext(),ActivityGrafico.class);
                startActivity(intent3);
                break;
        }

    }
}
