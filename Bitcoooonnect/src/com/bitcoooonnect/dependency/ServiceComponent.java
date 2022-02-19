package com.bitcoooonnect.dependency;

import com.bitcoooonnect.activity.*;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    CreateUserActivity providesCreateUserActivity();
    GetUserActivity providesGetUserActivity();
    UpdateUserActivity providesUpdateUserActivity();
    GetCoinActivity providesGetCoinActivity();
    UpdateCoinActivity providesUpdateCoinActivity();
}
