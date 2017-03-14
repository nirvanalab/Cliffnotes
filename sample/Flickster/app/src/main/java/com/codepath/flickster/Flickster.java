package com.codepath.flickster;

import android.app.Application;

import com.codepath.flickster.networking.MovieRestClient;

import javax.inject.Inject;

public class Flickster extends Application implements ComponentProvider {

    @Inject
    protected MovieRestClient mMovieRestClient;

    private AppComponent mComponent;

    @Override
    public AppComponent applicationComponent() {
        return mComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mComponent.inject(this);
    }
}
