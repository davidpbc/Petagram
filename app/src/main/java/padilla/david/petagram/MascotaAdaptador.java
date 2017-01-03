package padilla.david.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dave on 2/01/17.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    ArrayList<Mascota> mascotas;
    Activity activity;

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        final int likes = mascota.getLikes();
        holder.imgMascota.setImageResource(mascota.getFoto());
        holder.tvMascotaName.setText(mascota.getNombre());
        holder.tvMascotaLikes.setText(Integer.toString(likes));
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setLikes(likes + 1);
                Toast.makeText(activity, "Diste Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvMascotaName;
        private TextView tvMascotaLikes;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvMascotaName = (TextView) itemView.findViewById(R.id.tvMascotaName);
            tvMascotaLikes = (TextView) itemView.findViewById(R.id.tvMascotaLikes);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
