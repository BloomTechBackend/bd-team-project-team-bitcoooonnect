package com.bitcoooonnect.dependency;

import com.bitcoooonnect.activity.CreateUserActivity;
import com.bitcoooonnect.activity.GetUserActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    CreateUserActivity providesCreateUserActivity();
    GetUserActivity providesGetUserActivity();
}
