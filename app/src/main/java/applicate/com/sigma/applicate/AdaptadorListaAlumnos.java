package applicate.com.sigma.applicate;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raul.molina on 18/11/15.
 */
public class AdaptadorListaAlumnos extends RecyclerView.Adapter<AdaptadorListaAlumnos.AlumnoViewHolder>  implements View.OnClickListener {

    private List<Alumno> items = new ArrayList<>();
    private int position;
    private Alumno alumno;

    public AdaptadorListaAlumnos(List<Alumno> items) {
        this.items = items;
    }

    @Override
    public AlumnoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_alumno, viewGroup, false);
        AlumnoViewHolder avh = new AlumnoViewHolder(v);
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
                alumnoVIewHolder.linearLayoutRowMenu.setBackgroundColor(Color.rgb(223, 255, 128));
                break;
            case "fuera":
                alumnoVIewHolder.checkbox.setChecked(false);
                alumnoVIewHolder.linearLayoutRowMenu.setBackgroundColor(Color.rgb(255, 128, 128));
                break;
            case "ausencia":
                alumnoVIewHolder.checkbox.setChecked(false);
                alumnoVIewHolder.linearLayoutRowMenu.setBackgroundColor(Color.rgb(255, 148, 77));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(View v) {

    }

    public static class AlumnoViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView nombre;
        TextView apellido1;
        TextView apellido2;
        CheckBox checkbox;
        LinearLayout linearLayoutRowMenu;

        public AlumnoViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.listaAlumnosImagen);
            nombre = (TextView) itemView.findViewById(R.id.listaAlumnosNombre);
            apellido1 = (TextView) itemView.findViewById(R.id.listaAlumnosApellido1);
            apellido2 = (TextView) itemView.findViewById(R.id.listaAlumnosApellido2);
            checkbox = (CheckBox) itemView.findViewById(R.id.listaAlumnosCheckBox);
            linearLayoutRowMenu = (LinearLayout) itemView.findViewById(R.id.linearLayoutRowMenu);
        }
    }

}
