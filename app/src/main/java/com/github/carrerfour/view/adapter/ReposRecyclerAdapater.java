package com.github.carrerfour.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.github.carrerfour.R;
import com.github.carrerfour.model.ProfileRepo;

import java.util.ArrayList;

public class ReposRecyclerAdapater extends RecyclerView.Adapter<ReposRecyclerAdapater.RepoViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<ProfileRepo> profileRepoArrayList;

    public ReposRecyclerAdapater(Context context, ArrayList<ProfileRepo> profileRepoArrayList) {
        this.profileRepoArrayList = profileRepoArrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) layoutInflater.inflate(R.layout.row_repo, null);
        RepoViewHolder newsViewHolder = new RepoViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, final int position) {
        ProfileRepo profileRepo = profileRepoArrayList.get(position);
        holder.tvRepoName.setText(profileRepo.getName());
        holder.tvLastUpdated.setText(profileRepo.getUpdatedAt());

    }

    @Override
    public int getItemCount() {
        return profileRepoArrayList.size();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRepoName;
        private TextView tvLastUpdated;
        private CardView cardView;

        public RepoViewHolder(View view) {
            super(view);

            tvRepoName = view.findViewById(R.id.tv_repo_name);
            tvLastUpdated = view.findViewById(R.id.tv_last_update);
            cardView = view.findViewById(R.id.card_view);

            CardView.LayoutParams layoutParams = new CardView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(8, 0, 8, 32);
            cardView.setLayoutParams(layoutParams);


        }
    }
}
