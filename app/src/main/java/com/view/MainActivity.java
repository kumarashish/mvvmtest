package com.view;





import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;


import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.Gson;
import com.testproject.R;
import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.SlideInEffect;


import adapter.ListItemAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import interfaces.OnSubscriberCompleted;
import model.Result;
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
        viewmodelInstance.getReviewModel(this);
        progress.setVisibility(View.VISIBLE);
    }

    public void updateUi() {
        if (viewmodelInstance.getData() != null) {
            listView.setTransitionEffect(new SlideInEffect());
            listView.setAdapter(new ListItemAdapter(viewmodelInstance.getData().getResults(), this));
            progress.setVisibility(View.GONE);
        }
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
    public void onListItemClicked(Result result) {
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

