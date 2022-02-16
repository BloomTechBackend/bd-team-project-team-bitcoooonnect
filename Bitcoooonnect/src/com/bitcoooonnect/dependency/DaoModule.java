package com.bitcoooonnect.dependency;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DaoModule {
    @Singleton
    @Provides
    DynamoDBMapper providesDynamoDBMapper() {
        return new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.DEFAULT_REGION));
    }
}

class DynamoDbClientProvider {
    public DynamoDbClientProvider() {
    }

    public static AmazonDynamoDB getDynamoDBClient() {
        return getDynamoDBClient(Regions.US_WEST_2);
    }

    public static AmazonDynamoDB getDynamoDBClient(Regions region) {
        if (null == region) {
            throw new IllegalArgumentException("region cannot be null");
        } else {
            return AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance()).withRegion(region).build();
        }
    }
}
