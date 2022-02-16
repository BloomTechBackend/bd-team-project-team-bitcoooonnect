package com.bitcoooonnect.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bitcoooonnect.dependency.DaggerServiceComponent;
import com.bitcoooonnect.models.requests.CreateUserRequest;
import com.bitcoooonnect.models.results.CreateUserResult;

public class CreateUserActivityProvider implements RequestHandler<CreateUserRequest, CreateUserResult> {

    public CreateUserActivityProvider() {

    }

    @Override
    public CreateUserResult handleRequest(final CreateUserRequest createUserRequest, Context context) {
        return DaggerServiceComponent.create().providesCreateUserActivity()
                .handleRequest(createUserRequest, context);
    }
}
