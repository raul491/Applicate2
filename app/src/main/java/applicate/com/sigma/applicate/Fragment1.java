package applicate.com.sigma.applicate;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

        switch (idV){
            case 0:

                break;
        }
    }
}
