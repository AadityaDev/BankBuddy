package com.technawabs.bankbuddy.custom_views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.aditya.edforaapp.R;
import com.aditya.edforaapp.models.SongInfo;
import com.aditya.edforaapp.utils.StringUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {

    private Context context;
    private List<SongInfo> songInfoList;

    public SongsAdapter(@NonNull Context context, @NonNull List<SongInfo> songInfoList) {
        this.context = context;
        this.songInfoList = songInfoList;
    }

    @Override
    public SongsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, @NonNull int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_card, parent, false);
        return new SongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsViewHolder holder, @NonNull int position) {
        final SongInfo songInfo = songInfoList.get(position);
        if ((holder != null) && (songInfo != null)) {
            if (!StringUtils.isNull(songInfo.getCover_image())) {
                Picasso.with(context).load(songInfo.getCover_image()).into(holder.coverImage);
            }
            if (!StringUtils.isNull(songInfo.getArtists())) {
                holder.artists.setText(songInfo.getArtists());
            }
            if (!StringUtils.isNull(songInfo.getSong())) {
                holder.song.setText(songInfo.getSong());
            }
            if (!StringUtils.isNull(songInfo.getUrl())) {

            }
            if (songInfo.isFavourite()) {
                holder.isFavourite.setChecked(true);
            } else {
                holder.isFavourite.setChecked(false);
            }
        }
    }

    @Override
    public int getItemCount() {
        return songInfoList.size();
    }

    public static class SongsViewHolder extends RecyclerView.ViewHolder {

        private ImageView coverImage;
        private TextView song;
        private TextView artists;
        private ToggleButton isFavourite;

        public SongsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.coverImage = (ImageView) itemView.findViewById(R.id.cover_image);
            this.song = (TextView) itemView.findViewById(R.id.song);
            this.artists = (TextView) itemView.findViewById(R.id.song_artists);
            this.isFavourite = (ToggleButton) itemView.findViewById(R.id.song_favourite);
        }
    }

}
