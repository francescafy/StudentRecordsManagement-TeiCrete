
package classes.database;

import classes.person.Lessons;
import classes.person.Teacher;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbconnection {


    public dbconnection() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");

            String dbUser = "root";
            String dbPass = "fra4405";

            String dbHost = "127.0.0.1";
            String dbPort = "3306";
            String dbName = "tei";
            String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

            //Connection con = DriverManager.getConnection(url, dbUser, dbPass);
            con = DriverManager.getConnection(url, dbUser, dbPass);
            
            System.out.println("Connection established successfully!");
            
            //String ret = doLogin("asdf", "adas");
            //System.out.println(ret);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace(System.out);

        } catch (SQLException ex) {
            System.out.println("ERROR: Connection not  established");
            ex.printStackTrace(System.out);
        }
    }
    static Connection con;

   
    
    public boolean doLogin(String user, String pass) {
        
        System.out.println("here2");
                
                    boolean login = false;
                    
                    try {
                        Statement stmt = con.createStatement();
                        String sql = "select login, password from users where login = '" + user + "' and password = '" + pass + "'";
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {                
                            login = true;
                        }
                        stmt.close();
                    } catch(SQLException e) {
                            System.out.println("We have an error-doLogin: "+e);
                    }
                    
                    return login;

                   
                   
                    
    }

    
    public boolean doInsert(String username, String password, String email, String lname, String fname) {
                    
                    boolean userFound = this.doLogin(username, password);
                    boolean inserted = false;
 
                    if (userFound ) {
                        System.out.println("User not found,insert aborted");
                        
                    } 
                    else
                    {
                       System.out.println("User found,proceed with inserting");
                        String sql2 = "insert into users (login, password, email, lastname, firstname) values('"+username+"','"+password+"','"+email+"','"+lname+"','"+fname+"')";
                    
                         try {
                            Statement stmt1 = con.createStatement();

                            stmt1.executeUpdate(sql2);
                            stmt1.close();
                            System.out.println("Insert complete");
                            inserted = true;
                            } 
                        catch(SQLException e) {
                            System.out.println("We have an error-doInsert: "+e);
                        }
                    }
                    return inserted;
                    
        
    }
                    
    public boolean doUpdate(String username, String password, String email, String lname, String fname)  {
                    
                    boolean userFound = this.doLogin(username, password);
                    boolean updated = false;

                    if (userFound ) {
                        System.out.println("User found,proceed with updating");
                        String sql = "update users set email = '"+email+"',lastname = '"+lname+"',firstname = '"+fname+"'where login = '"+username+"'and password = '"+password+"'";

                        try {
                            Statement stmt = con.createStatement();

                            stmt.executeUpdate(sql);
                            stmt.close();
                            System.out.println("Update complete");
                            updated=true;
                        } catch(SQLException e) {
                            System.out.println("We have an error-doUpdate: "+e);
                        }
                    } 
                    else
                    {
                       System.out.println("User non exist");
                       
                    }
                    return updated;
        
    }

   
    
    public boolean doDelete(String username, String password, String email, String lname, String fname) {
                    
                    boolean userFound = this.doLogin(username, password); 
                    boolean deleted = false;
                    
                    if (userFound) {
                        System.out.println("User found, proceed with deleting.");
                        String sql = "delete from users where login = '"+username+"'and password = '"+password+"'";

                        try {
                            Statement stmt = con.createStatement();

                            stmt.executeUpdate(sql);
                            stmt.close();
                            System.out.println("Delete complete");
                            deleted = true;
                        } catch(SQLException e) {
                            System.out.println("We have an error-doDelete: "+e);
                        }
                    } else {
                        System.out.println("User not found, delete aborted.");
                    }
                    
                    return deleted;
                    
    }
    
    public ArrayList<Lessons> getLessons() {
        ArrayList<Lessons> lessons = new ArrayList<Lessons>();

        Statement st;
        ResultSet rs;
        Lessons l;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM lesson");

            while (rs.next()) {
                l = new Lessons(
                        rs.getInt("idlesson"),
                        rs.getString("name"),
                        rs.getString("description")
                );
                lessons.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lessons;
    }
    
     public ArrayList<Teacher> getTeacher() {
        ArrayList<Teacher> teacher = new ArrayList<Teacher>();

        Statement st;
        ResultSet rs;
        Teacher t;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT users.lastname,users.firstname,teacher.eidikotita,teacher.tilefono FROM users,teacher WHERE idusers=idteacher");

            while (rs.next()) {
                t = new Teacher(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("eidikotita"),
                        rs.getString("tilefono")
                );
                teacher.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return teacher;
    }
}