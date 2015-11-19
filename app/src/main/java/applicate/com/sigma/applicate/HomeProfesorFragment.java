package applicate.com.sigma.applicate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeProfesorFragment extends Fragment {


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

        return rootView;

    }


}
