package com.bitcoooonnect.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bitcoooonnect.dependency.DaggerServiceComponent;
import com.bitcoooonnect.models.requests.GetUserRequest;
import com.bitcoooonnect.models.results.GetUserResult;

public class GetUserActivityProvider implements RequestHandler<GetUserRequest, GetUserResult> {

    public GetUserActivityProvider() {

    }

    @Override
    public GetUserResult handleRequest(final GetUserRequest getUserRequest, Context context) {
        return DaggerServiceComponent.create().providesGetUserActivity()
                .handleRequest(getUserRequest, context);
    }
}
