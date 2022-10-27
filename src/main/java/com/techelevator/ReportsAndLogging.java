package com.techelevator;
import com.techelevator.Product.Product;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ReportsAndLogging {
    private static String logEntry = "";
    private static String logMessage = "";
    private static final int MAX_QUANTITY=5;



    public static String logMessageBuilder(String itemChoiceFromUser, String productName, double productPrice) {


        logMessage.format("%5s %5s %.2f", itemChoiceFromUser, productName, productPrice  );


        return logMessage;
    }

    public static String logMessageBuilderHelper () {

        return logMessage;
    }

    public static String log(String message) {
        String logFile = "src/main/java/com/techelevator/log/log.txt";
        File searchLogFile = new File(logFile);
        logEntry = (getTimeForLog() + "  " + message);
        try (PrintWriter exceptionLog = new PrintWriter(new FileOutputStream(searchLogFile, true))){
            exceptionLog.println(logEntry);
        } catch (FileNotFoundException e) {
            System.out.println(e + "An error has occurred (ReportsAndLogging class)");
        }
        return logEntry;
    }


    public static String getLogEntry() {
        return logEntry;
    }

    public static void setLogEntry(String logEntry) {
        ReportsAndLogging.logEntry = logEntry;
    }

    public static String getTimeForLog(){
        LocalDateTime date =  LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");
        return date.format(formatter);
    }
    public static String getTimeForReports(){
        LocalDateTime date =  LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd--HH-mm-ss");
        return date.format(formatter);
    }



    public  static void getSalesReports(Map<String, Product> products, double totalSales){

        String folderSales= "src/main/java/com/techelevator/SalesReports/";
        File salesRapportFile = new File(folderSales+"Sales--"+getTimeForReports()+".txt");
        try (PrintWriter outPutData = new PrintWriter(salesRapportFile, "UTF-8")) {
            for (Map.Entry<String,Product>product:products.entrySet()){
                int soldQuantity = MAX_QUANTITY - product.getValue().getQuantity();
                outPutData.println(product.getValue().getName()+"|"+ soldQuantity);
            }
            outPutData.printf("%s %.2f ", "\n Total Sales: $", totalSales);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");
        }catch (UnsupportedEncodingException e2){
            System.out.println(e2.getMessage());
        }
    }



}



