package com.company;

import java.sql.*;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/sockdb";
    private static final String user = "root";
    private static final String password = "1111";

    private static Connection con;
    private static PreparedStatement psmt;
    private static ResultSet rs;

    static String selectQuery = "SELECT  type_sock_type,size_socks,  color_socks \n" +
            "FROM sockdb.socks\n" +
            "left join sock_types \n" +
            "ON socks.type_socks = sock_types.id_sock_types;";

    static String insertQuery = "Insert into socks (color_socks,size_socks,type_socks) values (?,?,?)";

    public static void selectSocks(PreparedStatement pstm)throws SQLException
    {
        rs = pstm.executeQuery();

        while (rs.next())
        {
            String color= rs.getString(1);
            int size =  rs.getInt(2);
            String type = rs.getString(3);
            System.out.println(color+" | " + size + " | " + type);
        }
    }

    public static void insertSock(PreparedStatement pstm)throws SQLException
    {
        psmt.setString(1,"Gray");
        psmt.setInt(2,33);
        psmt.setInt(3,1);

        psmt.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {

       con = DriverManager.getConnection(url, user, password);
       psmt = con.prepareStatement(selectQuery);
       // psmt = con.prepareStatement(insertQuery);
       selectSocks(psmt);
       //insertSock(psmt);
    }
}
