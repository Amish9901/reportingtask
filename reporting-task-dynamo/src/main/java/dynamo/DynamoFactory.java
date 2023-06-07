package dynamo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dal.DailyTripSummaryDAO;
import dal.model.DAOAbstractFactory;

public class DynamoFactory implements DAOAbstractFactory {
    static final String DUMMY_REGION = "us-west-2";
    static final String URL = "http://localhost:8000";
    private DynamoDailyTripSummaryDAO dynamoDBTripsModelDAO;

    public DynamoFactory() {
        AmazonDynamoDB amazonDynamoDB = createDynamoClient();
        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
        dynamoDBTripsModelDAO = new DynamoDailyTripSummaryDAO(mapper);
    }


    private static AmazonDynamoDB createDynamoClient() {
        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
        if (URL != null) {
            builder = builder.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(URL, DUMMY_REGION));
            builder = builder.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("any", "any")));
        } else {
            builder = builder.withCredentials(new DefaultAWSCredentialsProviderChain());
            builder = builder.withRegion(DUMMY_REGION);
        }
        return builder.build();
    }

    @Override
    public DailyTripSummaryDAO getDailyTripSummaryDAO() {
        return dynamoDBTripsModelDAO;
    }
}
