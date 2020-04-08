package com.github.carrerfour.view.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.carrerfour.R;
import com.github.carrerfour.model.ProfileDetail;
import com.github.carrerfour.model.ProfileRepo;
import com.github.carrerfour.view.adapter.ReposRecyclerAdapater;
import com.github.carrerfour.viewmodel.UserDetailViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserDetailActivity extends AppCompatActivity {

    private ProfileDetail profileDetail;
    private UserDetailViewModel userDetailViewModel;
    private ArrayList<ProfileRepo> profileRepoArrayList;
    private RecyclerView recyclerView;
    private ReposRecyclerAdapater reposRecyclerAdapater;
    private String searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        profileDetail = (ProfileDetail) getIntent().getExtras().get("profileDetail");
        searchText = (String) getIntent().getExtras().get("searchText");

        userDetailViewModel = ViewModelProviders.of(this).get(UserDetailViewModel.class);

        initViews();
        setProperties();

    }

    public void initViews() {

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        profileRepoArrayList = new ArrayList<>();
    }

    public void setProperties() {

        ((TextView) findViewById(R.id.tv_name)).setText(profileDetail.getName());
        ((TextView) findViewById(R.id.tv_company)).setText(profileDetail.getCompany());
        ((TextView) findViewById(R.id.tv_location)).setText(profileDetail.getLocation());
        ((TextView) findViewById(R.id.tv_blog)).setText(profileDetail.getBlog());

        ImageView ivAvatar = findViewById(R.id.iv_logo);
        Picasso.get().load(profileDetail.getAvatarUrl()).placeholder(R.drawable.github_icon).into(ivAvatar);

        reposRecyclerAdapater = new ReposRecyclerAdapater(this, profileRepoArrayList);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(reposRecyclerAdapater);

        userDetailViewModel.getRepos(searchText).observe(this, new Observer<ArrayList<ProfileRepo>>() {
            @Override
            public void onChanged(ArrayList<ProfileRepo> profileRepos) {
                if (profileRepos != null && profileRepos.size() > 0) {
                    profileRepoArrayList.clear();
                    profileRepoArrayList.addAll(profileRepos);
                    reposRecyclerAdapater.notifyDataSetChanged();
                }


            }
        });
    }


}
