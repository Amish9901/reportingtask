package main;

import dal.model.DailyTripSummary;
import dynamo.DynamoFactory;
import mysql.MysqlFactory;
import org.omg.DynamicAny.DynAnyFactory;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        String date = "2023-03-27";
        DailyTripSummary dailyTripSummary = null;

        MysqlFactory mysqlFactory = new MysqlFactory("test");
         dailyTripSummary = mysqlFactory.saveTripSummary(date);
        mysqlFactory.getDailyTripSummaryDAO().saveDailyTripSummary(dailyTripSummary);

        DynamoFactory dynamoFactory = new DynamoFactory();
        dynamoFactory.getDailyTripSummaryDAO().saveDailyTripSummary(dailyTripSummary);

        System.out.println("daily trip summary has been saved in both sql and dynamo tables");

    }
}