package dynamo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dal.DailyTripSummaryDAO;
import dal.model.DailyTripSummary;
import dynamo.model.DailyTripSummaryDynamo;

public class DynamoDailyTripSummaryDAO implements DailyTripSummaryDAO {
    DynamoDBMapper mapper = null;
    public DynamoDailyTripSummaryDAO(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void saveDailyTripSummary(DailyTripSummary tripSummary) {
        DailyTripSummaryDynamo dailyTripSummaryDynamo = new DailyTripSummaryDynamo();
        dailyTripSummaryDynamo.setDriverID(tripSummary.getDriverID());
        dailyTripSummaryDynamo.setTripDate(tripSummary.getDate());
        dailyTripSummaryDynamo.setTripCount(tripSummary.getTripCount());
        dailyTripSummaryDynamo.setAcclerationCount(tripSummary.getAccleration_count());
        dailyTripSummaryDynamo.setBreakingCount(tripSummary.getBreaking_Count());
        dailyTripSummaryDynamo.setCorneringCount(tripSummary.getCornering_count());
        dailyTripSummaryDynamo.setSpeedingCount(tripSummary.getSpeeding_count());
        dailyTripSummaryDynamo.setPhoneDistractionCount(tripSummary.getPhoneDistraction_count());
        mapper.save(dailyTripSummaryDynamo);


    }
}
