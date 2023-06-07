package dal.model;

import dal.DailyTripSummaryDAO;

public interface DAOAbstractFactory {
    DailyTripSummaryDAO getDailyTripSummaryDAO();
}
