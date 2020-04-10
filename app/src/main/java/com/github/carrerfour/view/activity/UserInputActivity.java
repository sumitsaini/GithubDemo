package com.github.carrerfour.view.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.github.carrerfour.R;
import com.github.carrerfour.model.ProfileDetail;
import com.github.carrerfour.viewmodel.UserInputViewModel;
import com.google.android.material.snackbar.Snackbar;


/**
 *
 */
public class UserInputActivity extends AppCompatActivity implements View.OnClickListener {

    private UserInputViewModel viewModel;
    private Button btnSearch;
    private EditText etSearch;
    private ConstraintLayout layoutParent;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);


        viewModel = ViewModelProviders.of(this).get(UserInputViewModel.class);

        initViews();
        setProperties();

    }

    public void initViews() {
        btnSearch = findViewById(R.id.btn_search);
        etSearch = findViewById(R.id.et_search);
        layoutParent = findViewById(R.id.parent);
    }

    public void setProperties() {
        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_search) {
            searchDetails();
        }


    }

    public boolean checkError() {
        if (etSearch.getText().toString().equals("")) {
            showSnackBar("Search can't empty");
            return true;
        }

        return false;
    }


    public void searchDetails() {

        if (checkError()) {
            return;
        }


        showProgressDailog();
        viewModel.getDetails(etSearch.getText().toString()).observe(this, new Observer<ProfileDetail>() {
            @Override
            public void onChanged(ProfileDetail profileDetail) {

                if (dialog != null && dialog.isShowing()) {
                    dialog.cancel();
                }
                if (profileDetail.isSuccess()) {
                    startDetailActivity(profileDetail);
                } else {
                    showSnackBar(profileDetail.getErrorMessage());
                }
            }
        });

    }

    public void startDetailActivity(ProfileDetail profileDetail) {
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra("profileDetail", profileDetail);
        intent.putExtra("searchText", etSearch.getText().toString());
        startActivity(intent);
    }

    public void showProgressDailog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.row_dialog_view);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void showSnackBar(String message) {
        Snackbar.make(layoutParent, message, Snackbar.LENGTH_SHORT).show();
    }
}
