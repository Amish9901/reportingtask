package mysql;

import dal.DailyTripSummaryDAO;
import dal.model.DAOAbstractFactory;
import dal.model.DailyTripSummary;

public class MysqlFactory implements DAOAbstractFactory {

    private MysqlDailyTripSummaryDAO mysqlDailyTripSummary;

    public MysqlFactory(String dataSourceName) {
        System.out.println("inside the mysql");

        mysqlDailyTripSummary = new MysqlDailyTripSummaryDAO(dataSourceName);
    }
    public DailyTripSummary saveTripSummary(String date){
        return mysqlDailyTripSummary.fetchDailyTripSummaryFromSql(date);
    }

    @Override
    public DailyTripSummaryDAO getDailyTripSummaryDAO() {
        return mysqlDailyTripSummary;
    }
}
