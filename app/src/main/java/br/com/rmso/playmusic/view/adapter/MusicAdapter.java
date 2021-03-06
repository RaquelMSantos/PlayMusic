package br.com.rmso.playmusic.view.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.rmso.playmusic.R;
import br.com.rmso.playmusic.service.model.Track;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {

    private List<Track> mTrackList;
    private Context mContext;

    public MusicAdapter (ArrayList<Track> trackList, Context context){
        mTrackList = trackList;
        mContext = context;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        final Track track = mTrackList.get(position);
        holder.mMusicOrderTextView.setText(position+1 + "");
        holder.mMusicNameTextView.setText(track.getTitle());
        holder.mAlbumNameTextView.setText(track.getAlbum().getTitle());

        Typeface custom_font_roboto_bold = Typeface.createFromAsset(mContext.getAssets(),  "Roboto-Bold.ttf");
        holder.mMusicNameTextView.setTypeface(custom_font_roboto_bold);
        Typeface custom_font_roboto_regular = Typeface.createFromAsset(mContext.getAssets(),  "Roboto-Regular.ttf");
        holder.mMusicOrderTextView.setTypeface(custom_font_roboto_regular);
        holder.mAlbumNameTextView.setTypeface(custom_font_roboto_regular);
    }

    @Override
    public int getItemCount() {
        if (mTrackList != null) return mTrackList.size(); else return 0;
    }

    public void setTrack(List<Track> trackList){
        if (trackList != null){
            this.mTrackList = trackList;
            notifyDataSetChanged();
        }
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {

        public final TextView mMusicOrderTextView;
        public final TextView mMusicNameTextView;
        public final TextView mAlbumNameTextView;

        public MusicViewHolder(View itemView) {
            super(itemView);
            mMusicOrderTextView = itemView.findViewById(R.id.tv_music_order);
            mMusicNameTextView = itemView.findViewById(R.id.tv_music_name);
            mAlbumNameTextView = itemView.findViewById(R.id.tv_album_name);
        }
    }

}
