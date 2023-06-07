package dynamo.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = SCHEMA.TABLE_NAME_SUMMARY)
public class DailyTripSummaryDynamo {
    @DynamoDBHashKey(attributeName = SCHEMA.COL_SUMMARY_DRIVER_ID)
    private String driverID;
    @DynamoDBRangeKey(attributeName = SCHEMA.COL_SUMMARY_TRIP_DATE)
    private String tripDate;
    @DynamoDBAttribute(attributeName = SCHEMA.COL_SUMMARY_TRIP_COUNT)
    private long tripCount;
    @DynamoDBAttribute(attributeName = SCHEMA.COL_SUMMARY_ACCLERATIO_COUNT )
    private long acclerationCount;
    @DynamoDBAttribute(attributeName = SCHEMA.COL_SUMMARY_BREAKING_COUNT)
    private long breakingCount;
    @DynamoDBAttribute(attributeName = SCHEMA.COL_SUMMARY_CORNERING_COUNT)
    private long corneringCount;
    @DynamoDBAttribute(attributeName = SCHEMA.COL_SUMMARY_SPEEDING_COUNT)
    private long speedingCount;
    @DynamoDBAttribute(attributeName = SCHEMA.COL_SUMMARY_PHONE_DISTRACTION_COUNT)
    private long phoneDistractionCount;

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public long getTripCount() {
        return tripCount;
    }

    public void setTripCount(long tripCount) {
        this.tripCount = tripCount;
    }

    public long getAcclerationCount() {
        return acclerationCount;
    }

    public void setAcclerationCount(long acclerationCount) {
        this.acclerationCount = acclerationCount;
    }

    public long getBreakingCount() {
        return breakingCount;
    }

    public void setBreakingCount(long breakingCount) {
        this.breakingCount = breakingCount;
    }

    public long getCorneringCount() {
        return corneringCount;
    }

    public void setCorneringCount(long corneringCount) {
        this.corneringCount = corneringCount;
    }

    public long getSpeedingCount() {
        return speedingCount;
    }

    public void setSpeedingCount(long speedingCount) {
        this.speedingCount = speedingCount;
    }

    public long getPhoneDistractionCount() {
        return phoneDistractionCount;
    }

    public void setPhoneDistractionCount(long phoneDistractionCount) {
        this.phoneDistractionCount = phoneDistractionCount;
    }
}
