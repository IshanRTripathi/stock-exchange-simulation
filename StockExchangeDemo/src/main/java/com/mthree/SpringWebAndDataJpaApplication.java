package com.mthree;

import java.io.BufferedReader;
import com.mthree.models.*;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.mthree.engines.MatchingEngine;
import com.mthree.engines.MyEngine;
import com.mthree.models.*;
import com.mthree.support.ToTextFile;
import java.sql.*
;//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class SpringWebAndDataJpaApplication {
	
	
	
	 private static final String INPUT = "C:\\Users\\karan\\Desktop\\Ordersssss.txt";
	 private static final String OUTPUT = "C:\\Users\\karan\\Desktop\\Trades.txt";
	public static void main(String[] args) {
		SpringApplication.run(SpringWebAndDataJpaApplication.class, args);
		ToTextFile obj= new ToTextFile();
		obj.makeTxt();
		Connection con = null;
		PreparedStatement st;
		//------------------------------------
		List data = new ArrayList();
        try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
               
                

               
               
                
        } catch (Exception e) {
                System.out.println(e);
        }
		//------------------------------------
		
		
		
		
		
		
		 MatchingEngine matchingEngine = new MyEngine();
	        BufferedReader br = null;
	        BufferedWriter bw = null;
	        try {
	            br = new BufferedReader(new FileReader(INPUT));
	            bw = new BufferedWriter(new FileWriter(OUTPUT));
	            for (String line; (line = br.readLine()) != null; ) {
//	                Thread.sleep(150);
	                try {
	                    Order order = new Order(line);
	                    System.out.println("--Entered order : " + order);
	                    List<Trade> trades = matchingEngine.enterOrder(order);
	                    
	                    
	                    
	                    for (Trade trade : trades) {
	                        System.out.println("----Trade : " + trade);
	                        try {
								st = con.prepareStatement("insert into trade_table(id,buyer,price,quantity,seller,stock,time_stamp) values(?,?,?,?,?,?,?)");
								
								int id=Integer.parseInt(String.valueOf(trade.getId()));
								st.setInt(1, id);
								
								st.setString(2,trade.getBuyer());
								st.setBigDecimal(3, trade.getPrice());
								st.setBigDecimal(4, trade.getQuantity());
								st.setString(5,trade.getSeller());
								st.setString(6,trade.getStock());
								st.setString(7, trade.getTimeStamp());
								
								st.executeUpdate();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	                        
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


