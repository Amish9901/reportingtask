package mysql;

import com.edriving.commons.dal.jdbc.BaseDao;
import com.edriving.commons.dal.jdbc.JdbcConnectionPool;
import dal.DailyTripSummaryDAO;
import dal.model.DailyTripSummary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MysqlDailyTripSummaryDAO extends BaseDao implements DailyTripSummaryDAO {

    private static final String test = ""+
            "SELECT" +
            " driverID," +
            " tripDate," +
            " CONVERT(trip_count, SIGNED) AS trip_count," +
            " CONVERT(speeding_count, SIGNED) AS speeding_count," +
            " CONVERT(breaking_Count, SIGNED) AS breaking_Count," +
            " CONVERT(accleration_count, SIGNED) AS accleration_count," +
            " CONVERT(cornering_count, SIGNED) AS cornering_count," +
            " CONVERT(phoneDistraction_count, SIGNED) AS phoneDistraction_count" +
            " FROM (" +
            " SELECT" +
            " wrm_trips.driverID," +
            " wrm_trips.tripDate," +
            " COUNT(DISTINCT wrm_trips.tripID) AS trip_count," +
            " SUM(CASE WHEN wrm_trip_event_counts.eventType = 'SPEEDING' THEN wrm_trip_event_counts.eventCount ELSE 0 END) AS speeding_count," +
            " SUM(CASE WHEN wrm_trip_event_counts.eventType = 'HARD_BRAKING' THEN wrm_trip_event_counts.eventCount ELSE 0 END) AS breaking_Count," +
            " SUM(CASE WHEN wrm_trip_event_counts.eventType = 'HARD_ACCELERATION' THEN wrm_trip_event_counts.eventCount ELSE 0 END) AS accleration_count," +
            " SUM(CASE WHEN wrm_trip_event_counts.eventType = 'HARD_CORNERING' THEN wrm_trip_event_counts.eventCount ELSE 0 END) AS cornering_count," +
            " SUM(CASE WHEN wrm_trip_event_counts.eventType = 'PHONE_DISTRACTION' THEN wrm_trip_event_counts.eventCount ELSE 0 END) AS phoneDistraction_count" +
            " FROM" +
            " wrm_trips" +
            " INNER JOIN" +
            " wrm_trip_event_counts ON wrm_trips.tripID = wrm_trip_event_counts.tripID" +
            " WHERE" +
            " wrm_trips.tripDate = ?" +
            " GROUP BY" +
            " wrm_trips.driverID," +
            " wrm_trips.tripDate" +
            ") AS subquery;";

    private static final String SQL_SAVE_DAILY_TRIP_SUMMARY = "" +
            "insert into wrm_daily_trip_summary (driverID,tripDate,tripCount,speeding_count,breaking_Count,accleration_count,cornering_count,phone_distraction) values (?,?,?,?,?,?,?,?)";


    public MysqlDailyTripSummaryDAO(String datasourceName){
        super(JdbcConnectionPool.getInstance().initializeDataSource(datasourceName));
    }

    public DailyTripSummary fetchDailyTripSummaryFromSql(String Date) {

        List<DailyTripSummary> result = new ArrayList<>();
        List<Map<String, Object>> rows;
        try {
            rows = query(test, Date);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Map<String, Object> row : rows) {
            DailyTripSummary record = new DailyTripSummary();
            record.setDriverID(BaseDao.cast(row.get("driverID".toUpperCase()), String.class));
            record.setDate(BaseDao.cast(row.get("tripDate".toUpperCase()), String.class));
            record.setTripCount(BaseDao.cast(row.get("trip_count".toUpperCase()), Long.class));
            record.setSpeeding_count( BaseDao.cast(row.get("speeding_count".toUpperCase()), Long.class));
            record.setBreaking_Count(BaseDao.cast(row.get("breaking_Count".toUpperCase()), Long.class));
            record.setAccleration_count(BaseDao.cast(row.get("accleration_count".toUpperCase()), Long.class));
            record.setCornering_count(BaseDao.cast(row.get("cornering_count".toUpperCase()), Long.class));
            record.setPhoneDistraction_count(BaseDao.cast(row.get("phoneDistraction_count".toUpperCase()), Long.class));
            result.add(record);
        }
        return result.get(0);

    }

    @Override
    public void saveDailyTripSummary(DailyTripSummary tripSummary) {

        try{
            update(SQL_SAVE_DAILY_TRIP_SUMMARY,
                    tripSummary.getDriverID(),
                    tripSummary.getDate(),
                    tripSummary.getTripCount(),
                    tripSummary.getSpeeding_count(),
                    tripSummary.getBreaking_Count(),
                    tripSummary.getAccleration_count(),
                    tripSummary.getCornering_count(),
                    tripSummary.getPhoneDistraction_count()
            );
        }catch (SQLException e)  {
            throw new RuntimeException(e);
        }
    }
}
