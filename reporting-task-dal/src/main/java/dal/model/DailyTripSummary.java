package dal.model;

public class DailyTripSummary {
    private String driverID;
    private String date;
    private long tripCount;
    private long accleration_count;
    private long breaking_Count;
    private long cornering_count;
    private long speeding_count;
    private long phoneDistraction_count;

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTripCount() {
        return tripCount;
    }

    public void setTripCount(long tripCount) {
        this.tripCount = tripCount;
    }

    public long getAccleration_count() {
        return accleration_count;
    }

    public void setAccleration_count(long accleration_count) {
        this.accleration_count = accleration_count;
    }

    public long getBreaking_Count() {
        return breaking_Count;
    }

    public void setBreaking_Count(long breaking_Count) {
        this.breaking_Count = breaking_Count;
    }

    public long getCornering_count() {
        return cornering_count;
    }

    public void setCornering_count(long cornering_count) {
        this.cornering_count = cornering_count;
    }

    public long getSpeeding_count() {
        return speeding_count;
    }

    public void setSpeeding_count(long speeding_count) {
        this.speeding_count = speeding_count;
    }

    public long getPhoneDistraction_count() {
        return phoneDistraction_count;
    }

    public void setPhoneDistraction_count(long phoneDistraction_count) {
        this.phoneDistraction_count = phoneDistraction_count;
    }
}
