package com.pluralsight.filemanager;

import com.pluralsight.model.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    public static void saveReceipt(Order currentOrder) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = "receipts" + File.separator + now.format(formatter) + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(currentOrder.toString());
            System.out.println("Receipt saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }
}
