package com.view;





import android.os.Bundle;
import android.widget.ListView;


import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;

import com.testproject.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import viewmodel.MainActivity_ViewModel;

public class MainActivity extends FragmentActivity implements LifecycleOwner {

@BindView(R.id.listView)
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainActivity_ViewModel viewmodelInstance= ViewModelProviders.of(this).get(MainActivity_ViewModel.class);


    }


}
