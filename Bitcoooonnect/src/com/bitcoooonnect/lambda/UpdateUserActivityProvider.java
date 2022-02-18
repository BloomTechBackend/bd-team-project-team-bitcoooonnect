package com.bitcoooonnect.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bitcoooonnect.dependency.DaggerServiceComponent;
import com.bitcoooonnect.models.requests.UpdateUserRequest;
import com.bitcoooonnect.models.results.UpdateUserResult;

public class UpdateUserActivityProvider implements RequestHandler<UpdateUserRequest, UpdateUserResult> {

    public UpdateUserActivityProvider() {

    }

    @Override
    public UpdateUserResult handleRequest(final UpdateUserRequest updateUserRequest, Context context) {
        return DaggerServiceComponent.create().providesUpdateUserActivity()
                .handleRequest(updateUserRequest, context);
    }
}
