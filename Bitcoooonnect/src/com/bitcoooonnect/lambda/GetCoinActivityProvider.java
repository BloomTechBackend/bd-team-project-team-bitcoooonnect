package com.bitcoooonnect.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bitcoooonnect.models.requests.GetCoinRequest;
import com.bitcoooonnect.models.results.GetCoinResult;
import com.bitcoooonnect.dependency.DaggerServiceComponent;

public class GetCoinActivityProvider implements RequestHandler<GetCoinRequest, GetCoinResult> {

    public GetCoinActivityProvider() {

    }

    @Override
    public GetCoinResult handleRequest(final GetCoinRequest getCoinRequest,
                                          Context context) {
        return DaggerServiceComponent.create().providesGetCoinActivity().handleRequest(
                getCoinRequest, context
        );
    }
}
