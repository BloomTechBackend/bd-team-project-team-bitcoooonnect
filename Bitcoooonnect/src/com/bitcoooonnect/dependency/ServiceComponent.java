package com.bitcoooonnect.dependency;

import com.bitcoooonnect.activity.CreateUserActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    CreateUserActivity providesCreateUserActivity();
}
