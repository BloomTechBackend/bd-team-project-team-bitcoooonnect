package com.bitcoooonnect.dependency;

import com.bitcoooonnect.activity.CreateUserActivity;
import com.bitcoooonnect.activity.GetUserActivity;
import com.bitcoooonnect.activity.UpdateUserActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    CreateUserActivity providesCreateUserActivity();
    GetUserActivity providesGetUserActivity();
    UpdateUserActivity providesUpdateUserActivity();
}
