package applicate.com.sigma.applicate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ActivityCrearNotificacion extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_crear_notificacion);

        LinearLayout botonEnviar = (LinearLayout) findViewById(R.id.sendButton);
        botonEnviar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Notificación enviada correctamente",Toast.LENGTH_LONG).show();
        finish();
    }
}
