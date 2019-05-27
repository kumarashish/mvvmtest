package com.view;





import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.google.gson.Gson;
import com.testproject.R;
import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.SlideInEffect;


import adapter.ListItemAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import common.Utils;
import interfaces.OnSubscriberCompleted;
import model.Result;
import room.Data;
import room.Database;
import viewmodel.MainActivity_ViewModel;

public class MainActivity extends FragmentActivity implements OnSubscriberCompleted {

    @BindView(R.id.listView)
    JazzyListView listView;
    @BindView(R.id.progressbar)
    ProgressBar progress;
    MainActivity_ViewModel viewmodelInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewmodelInstance = ViewModelProviders.of(this).get(MainActivity_ViewModel.class);
        if (Utils.isNetworkAvailable(this)) {
            progress.setVisibility(View.VISIBLE);
            viewmodelInstance.getReviewModel(this);
        } else {
            if (viewmodelInstance.getData().size() != 0) {
                progress.setVisibility(View.VISIBLE);
                updateUi();
            } else {
                showAlert("No Data Available for offline mode,Please connect to internet atleast for once  inorder to use offline data.");
            }
            Toast.makeText(MainActivity.this, "You are using offline data", Toast.LENGTH_SHORT).show();
        }

    }

    public void updateUi() {

        listView.setTransitionEffect(new SlideInEffect());
        listView.setAdapter(new ListItemAdapter(viewmodelInstance.getData(), this));
        progress.setVisibility(View.GONE);
    }

    public void showAlert(String message) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setNeutralButton("Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



    @Override
    public void onCompleted() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updateUi();
            }
        });
    }

    @Override
    public void onListItemClicked(Data result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("resultdata", new Gson().toJson(result));
                startActivity(intent);
            }
        });
    }
    }

