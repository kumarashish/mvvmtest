package daggercomponent;

import network.ApiCall;
import dagger.Component;

@Component(modules= AppModule.class)
public interface AppComponent {
  ApiCall getAPIService();
}
