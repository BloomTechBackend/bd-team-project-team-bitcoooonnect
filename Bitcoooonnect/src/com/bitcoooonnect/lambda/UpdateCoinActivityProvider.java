package com.bitcoooonnect.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bitcoooonnect.dependency.DaggerServiceComponent;
import com.bitcoooonnect.models.requests.UpdateCoinRequest;
import com.bitcoooonnect.models.results.UpdateCoinResult;

public class UpdateCoinActivityProvider implements RequestHandler<UpdateCoinRequest, UpdateCoinResult> {

    public UpdateCoinActivityProvider() {

    }

    @Override
    public UpdateCoinResult handleRequest(final UpdateCoinRequest updateCoinRequest,
                                     Context context) {
        return DaggerServiceComponent.create().providesUpdateCoinActivity()
                .handleRequest(updateCoinRequest, context);
    }
}
