package in.iplplay2win.ipl2017live;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

/**
 * Created by Anand on 24-03-2017.
 */

class AdapterTeam extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<TeamData> data= Collections.emptyList();
    TeamData current;
    int currentPos=0;

    public AdapterTeam(Context context, List<TeamData> data) {
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.teamcard, parent,false);
        AdapterTeam.MyHolder holder=new AdapterTeam.MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // Get current position of item in recyclerview to bind data and assign values from list
        AdapterTeam.MyHolder myHolder= (AdapterTeam.MyHolder) holder;
        TeamData current=data.get(position);
        myHolder.TeamName.setText(current.TeamName);

        // load image into imageview using glide
        Glide.with(context).load(current.TeamLogo)
                .placeholder(R.drawable.ic_img_placeholder)
                .error(R.drawable.ic_img_error)
                .into(myHolder.teamlogo);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        ImageView teamlogo;
        TextView TeamName;

        public MyHolder(View itemView) {
            super(itemView);

            teamlogo=(ImageView)itemView.findViewById(R.id.team_logo);

            TeamName =(TextView) itemView.findViewById(R.id.teamName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent teamdetails = new Intent(context,team_profile.class);
                    context.startActivity(teamdetails);
                }
            });

        }
    }
}
