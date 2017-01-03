package padilla.david.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MsscotaFavoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msscota_favoritos);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasFav);
        GridLayoutManager glm = new GridLayoutManager(this, 1);

        rvMascotasFav.setLayoutManager(glm);
        inicializarMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotasFav.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Malteada", 8, R.drawable.perro5));
        mascotas.add(new Mascota("Bonnie", 7, R.drawable.perro3));
        mascotas.add(new Mascota("Charlie", 6, R.drawable.perrro4));
        mascotas.add(new Mascota("Chop", 6, R.drawable.perro2));
        mascotas.add(new Mascota("Marcus", 5, R.drawable.perro1));
    }
}
