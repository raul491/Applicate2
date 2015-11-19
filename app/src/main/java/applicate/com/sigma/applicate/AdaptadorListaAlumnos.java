package applicate.com.sigma.applicate;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by raul.molina on 18/11/15.
 */
public class AdaptadorListaAlumnos extends RecyclerView.Adapter<AdaptadorListaAlumnos.AlumnoViewHolder> {

    private List<Alumno> items = new ArrayList<>();
    private int position;
    private Alumno alumno;
    private boolean control = false;

    public void setControl(boolean valor) {
        control = valor;
    }

    public AdaptadorListaAlumnos(List<Alumno> items) {
        Collections.sort(items, new Comparator<Alumno>() {
            @Override
            public int compare(Alumno lhs, Alumno rhs) {
                switch (lhs.getStatus()) {
                    case "dentro":
                        if (rhs.getStatus().equals("dentro")) {
                            return 0;
                        } else if (rhs.getStatus().equals("fuera")) {
                            return 0;
                        } else {
                            return 0;
                        }
                    case "fuera":
                        if (rhs.getStatus().equals("dentro")) {
                            return 1;
                        } else if (rhs.getStatus().equals("fuera")) {
                            return 0;
                        } else {
                            return 0;
                        }
                    case "ausencia":
                        if (rhs.getStatus().equals("dentro")) {
                            return 1;
                        } else if (rhs.getStatus().equals("fuera")) {
                            return 1;
                        } else {
                            return 0;
                        }
                }
                return 0;
            }
        });
        this.items = items;
    }

    @Override
    public AlumnoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_alumno, viewGroup, false);
        AlumnoViewHolder avh = new AlumnoViewHolder(rootView, this);

        position = i;
        return avh;
    }

    @Override
    public void onBindViewHolder(AlumnoViewHolder alumnoVIewHolder, int i) {
        alumno = items.get(i);
        //alumnoVIewHolder.image.setImageDrawable(alumno.getFoto());
        alumnoVIewHolder.nombre.setText(alumno.getNom());
        alumnoVIewHolder.apellido1.setText(alumno.getApellido1());
        alumnoVIewHolder.apellido2.setText(alumno.getApellido2());
        switch (alumno.getStatus()) {
            case "dentro":
                alumnoVIewHolder.checkbox.setChecked(true);
                alumnoVIewHolder.linearLayoutRowMenu.setBackgroundColor(Color.rgb(229, 255, 229));
                break;
            case "fuera":
                alumnoVIewHolder.checkbox.setChecked(false);
                alumnoVIewHolder.linearLayoutRowMenu.setBackgroundColor(Color.rgb(255, 179, 179));
                break;
            case "ausencia":
                alumnoVIewHolder.checkbox.setChecked(false);
                alumnoVIewHolder.linearLayoutRowMenu.setBackgroundColor(Color.rgb(255, 255, 153));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class AlumnoViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {

        private final AdaptadorListaAlumnos adapter;
        ImageView image;
        TextView nombre;
        TextView apellido1;
        TextView apellido2;
        CheckBox checkbox;
        LinearLayout linearLayoutRowMenu;

        public AlumnoViewHolder(View itemView, AdaptadorListaAlumnos adaptadorListaAlumnos) {
            super(itemView);
            this.adapter = adaptadorListaAlumnos;
            image = (ImageView) itemView.findViewById(R.id.listaAlumnosImagen);
            nombre = (TextView) itemView.findViewById(R.id.listaAlumnosNombre);
            apellido1 = (TextView) itemView.findViewById(R.id.listaAlumnosApellido1);
            apellido2 = (TextView) itemView.findViewById(R.id.listaAlumnosApellido2);
            checkbox = (CheckBox) itemView.findViewById(R.id.listaAlumnosCheckBox);
            linearLayoutRowMenu = (LinearLayout) itemView.findViewById(R.id.linearLayoutRowMenu);
            checkbox.setOnCheckedChangeListener(this);
        }


        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                linearLayoutRowMenu.setBackgroundColor(Color.rgb(229, 255, 229));
                Log.v("prova", Boolean.toString(adapter.control));
                if (!adapter.control) {
                    //adapter.notifyDataSetChanged();
                }
            } else {
                linearLayoutRowMenu.setBackgroundColor(Color.rgb(255, 179, 179));
                Log.v("prova", Boolean.toString(adapter.control));
                if (!adapter.control) {
                    //adapter.notifyDataSetChanged();
                }
            }

        }
    }

}
