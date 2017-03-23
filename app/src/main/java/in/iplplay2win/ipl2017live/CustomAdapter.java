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

import in.iplplay2win.ipl2017live.utils.ScheduleList;

/**
 * Created by Anand on 23-03-2017.
 */

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    private Context context;
    private List<ScheduleList> scheduleList;

    public CustomAdapter(Context context, List<ScheduleList> scheduleList) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View scheduleCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedulecard,parent,false);

        return new ViewHolder(scheduleCardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.day.setText(scheduleList.get(position).getDay());
        holder.date.setText(scheduleList.get(position).getDate());
        holder.time.setText(scheduleList.get(position).getTime());
        holder.place.setText(scheduleList.get(position).getPlace());
       // Glide.with(context).load(scheduleList.get(position).getTeams()).into(holder.teamlogos)
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

//        ImageView teamA;
//        ImageView teamB;
//        TextView teamAShort;
//        TextView teamBShort;

        TextView day,date,time,place;

        public ViewHolder(View itemView) {
            super(itemView);

//            teamAShort=(TextView) itemView.findViewById(R.id.teamA_text);
//            teamA=(ImageView) itemView.findViewById(R.id.teamA_logo);
//
//            teamB=(ImageView) itemView.findViewById(R.id.teamB_logo);
//            teamBShort=(TextView) itemView.findViewById(R.id.teamB_text);

            day=(TextView) itemView.findViewById(R.id.day);
            date=(TextView) itemView.findViewById(R.id.match_date);
            time=(TextView) itemView.findViewById(R.id.match_time);
            place=(TextView) itemView.findViewById(R.id.place_schedule);


        }
    }
}
