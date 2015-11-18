package applicate.com.sigma.applicate;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment1, container, false);

        Button button= (Button) rootView.findViewById(R.id.button1);
        button.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        int idV=v.getId();

        if (idV == R.id.button1) {
            Toast.makeText(getContext(), "PROVA", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getContext(), "PROVA2", Toast.LENGTH_LONG).show();
        }



        switch (idV){
            case R.id.button1:

                break;
        }
    }
}
