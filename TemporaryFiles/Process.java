package com.nasdaq.internship;

import java.io.*;
import java.util.List;

public class Process {
    private static final String INPUT = "Orders.txt";
    private static final String OUTPUT = "Trades.txt";

    public static void main(String[] args) {
        System.out.println("Nasdaq Summer Internship Test : Matching Engine");
        MatchingEngine matchingEngine = new MyEngine();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(INPUT));
            bw = new BufferedWriter(new FileWriter(OUTPUT));
            for (String line; (line = br.readLine()) != null; ) {
//                Thread.sleep(150);
                try {
                    Order order = new Order(line);
                    System.out.println("--Entered order : " + order);
                    List<Trade> trades = matchingEngine.enterOrder(order);
                    for (Trade trade : trades) {
                        System.out.println("----Trade : " + trade);
                        bw.write(trade.toStringShort() + "\n");
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println(e.toString());
                    System.err.println("Skipping line : " + line);
                }
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
