import java.sql.*;

public class Test1 {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        //1.加载驱动
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlserver://120.79.254.77:1433;databaseName=SPJ;user=sa;password=Tam137731";//sa身份连接
        //2.获取与数据库连接
        con = DriverManager.getConnection(url);
        //3.获取用于向sql发送命令的statement
        Statement stmt = null;
        stmt = con.createStatement();
        //4.向数据库发送SQL命令
//        String sql = "insert into test values('R','male','35',10500)";
//        if (stmt.executeUpdate(sql) > 0) {
//            System.out.println("新增数据成功");
//        } else {
//            System.out.println("新增数据失败！");
//        }
        //5.关闭连接
        stmt.close();
        con.close();

    }
//    public static void main(String args[]) {
//        // Create a variable for the connection string.
////        String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=DBLinkTest;integratedSecurity=true;";
//
//        String url = "jdbc:sqlserver://120.79.254.77:1433;databaseName=DBLinkTest;user=sa;password=TAM137731";//sa身份连接
//
////        String url2 = "jdbc:sqlserver://127.0.0.1:1433;databaseName=DBLinkTest;integratedSecurity=true;";//windows集成模式连接
//
//        // Declare the JDBC objects.
//        Connection con = url;
//        Statement stmt = url;
//        ResultSet rs = url;
//
//        try {
//        // Establish the connection.
//        System.out.println("begin.");
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        con = DriverManager.getConnection(url);
//        System.out.println("end.");
//
//        // Create and execute an SQL statement that returns some data.
//        String SQL = "SELECT  * FROM TestTable1";
//        stmt = con.createStatement();
//        rs = stmt.executeQuery(SQL);
//
//        // Iterate through the data in the result set and display it.
//        while (rs.next()) {
//        System.out.println(rs.getString(1) + " " + rs.getString(2));
//        }
//        }
//
//        // Handle any errors that may have occurred.
//        catch (Exception e) {
//        e.printStackTrace();
//        } finally {
//        if (rs != null)
//        try {
//        rs.close();
//        } catch (Exception e) {
//        }
//        if (stmt != null)
//        try {
//        stmt.close();
//        } catch (Exception e) {
//        }
//        if (con != null)
//        try {
//        con.close();
//        } catch (Exception e) {
//        }
}