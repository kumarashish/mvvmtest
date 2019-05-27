package viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import common.AppController;
import model.ReviewModel;
import rx.Observable;

import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity_ViewModel extends AndroidViewModel {

    private ReviewModel model=null;
     AppController controller;
     Application application;
    public MainActivity_ViewModel (Application application)
{   super(application);
    this.application=application;
}
    public void getReviewModel() {
        if (model == null) {
            controller = (AppController) application;
            Observable<ReviewModel> reviewModelObservable = controller.getWebApi().getReviewData();
            reviewModelObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ReviewModel>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onNext(ReviewModel reviewModel) {
                    model=reviewModel;


                }
            });


        }



    }
    public ReviewModel getData() {
        if (model == null) {

            getReviewModel();
        }
        return model;
    }


}
