package in.iplplay2win.ipl2017live;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import in.iplplay2win.ipl2017live.utils.*;

/**
 * Created by Anand on 23-03-2017.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

     Context context;
     List<team_L> teamList;

    public TeamAdapter(Context context, List<team_L> teamList) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View TeamCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.teamcard,parent,false);
        return new TeamAdapter.ViewHolder(TeamCardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

      holder.TeamName.setText(teamList.get(position).getteam_full());
        Glide.with(context).load(teamList.get(position).getteamlogo()).into(holder.TeamLogo);
    }

    @Override
    public int getItemCount() {

        return teamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView TeamName;
        ImageView TeamLogo;

        public ViewHolder(View itemView) {
            super(itemView);

            TeamName = (TextView) itemView.findViewById(R.id.teamName);
            TeamLogo = (ImageView) itemView.findViewById(R.id.team_logo);

        }
    }
}
