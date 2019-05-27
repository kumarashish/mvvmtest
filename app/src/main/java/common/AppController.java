package common;

import android.app.Application;

import daggercomponent.AppModule;
import daggercomponent.AppComponent;
import daggercomponent.DaggerAppComponent;
import network.ApiCall;

public class AppController extends Application {
    AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
      appComponent= DaggerAppComponent.builder().appModule(new AppModule()).build();


    }

    public ApiCall getWebApi() {
        return appComponent.getAPIService();

    }
}
