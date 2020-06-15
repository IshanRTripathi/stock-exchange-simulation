package com.mthree.support;
import java.io.*;
import java.sql.*;
import java.util.*;
public class ToTextFile {
	
	
   // public static void main(String[] args) {
	
	
	
	
    public void makeTxt() {
    		
    		try {
    	FileWriter fileWriter = new FileWriter("C:\\Users\\karan\\Desktop\\Ordersssss.txt", false);}
    		catch(Exception e) {
    			e.getMessage();
    		}
    	
            List data = new ArrayList();
            try {
                    Connection con = null;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("Select * from order_table");

                    while (rs.next()) {
                            double id = rs.getDouble("id");
                            String client = rs.getString("client");
                            String orderType = rs.getString("order_type");
                            double price=rs.getDouble("price");
                            double quantity=rs.getDouble("quantity");
                            String stock = rs.getString("stock");
                            
                            data.add(client+" "+orderType+" "+stock+" "+quantity+"@"+price);

                    }
                    writeToFile(data, "C:\\Users\\karan\\Desktop\\Ordersssss.txt");
                    rs.close();
                    st.close();
            } catch (Exception e) {
                    System.out.println(e);
            }
    }

    private static void writeToFile(java.util.List list, String path) {
            BufferedWriter out = null;
            try {
                    File file = new File(path);
                    out = new BufferedWriter(new FileWriter(file, true));
                    for (Object s : list) {
                            out.write((String)s);
                            out.newLine();

                    }
                    out.close();
            } catch (IOException e) {
            }
    }}
