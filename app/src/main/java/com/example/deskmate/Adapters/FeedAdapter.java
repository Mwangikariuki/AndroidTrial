package com.example.deskmate.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deskmate.R;
import com.example.deskmate.model.Feed;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder>{

    private ArrayList<Feed> feedList;

    public FeedAdapter(ArrayList<Feed> feedList) {
        this.feedList = feedList;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.feed_layout,parent,false);

        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {

        holder.messageText.setText(feedList.get(position).getPostMsg());
        holder.createdAtText.setText(feedList.get(position).getCreatedAt());

    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    class FeedViewHolder extends RecyclerView.ViewHolder {

        TextView messageText;
        TextView createdAtText;

        public FeedViewHolder (View itemView) {
            super(itemView);

            messageText = itemView.findViewById(R.id.message);
            createdAtText = itemView.findViewById(R.id.createdAt);
        }
    }


}
