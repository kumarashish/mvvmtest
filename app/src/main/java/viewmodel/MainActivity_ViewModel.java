package viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import common.AppController;
import interfaces.OnSubscriberCompleted;
import model.ReviewModel;
import rx.Observable;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity_ViewModel extends AndroidViewModel {

    private ReviewModel model=null;
     AppController controller;
     Application application;
     boolean isDataLoading=false;

    public MainActivity_ViewModel(Application application) {
        super(application);
        this.application = application;
    }

    public void getReviewModel(OnSubscriberCompleted callback) {
        if (model == null) {
            isDataLoading = true;
            controller = (AppController) application;
            Observable<ReviewModel> reviewModelObservable = controller.getWebApi().getReviewData();
            reviewModelObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ReviewModel>() {
                @Override
                public void onCompleted() {
                    isDataLoading = false;
                    callback.onCompleted();
                }
                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onNext(ReviewModel reviewModel) {
                    model = reviewModel;
                    isDataLoading = false;
                }
            });

        }


    }



    public ReviewModel getData() {
        return model;
    }


}
