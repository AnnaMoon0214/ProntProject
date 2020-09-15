package com.hk.member.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.dbcp2.BasicDataSource;

import com.hk.member.dao.MemberDao;



/**
 * Application Lifecycle Listener implementation class ContextLoaderListener
 *
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
	Connection conn;
	
    /**
     * Default constructor. 
     */
	public ContextLoaderListener() {
        // TODO Auto-generated constructor stub
	}

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
	public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("Listener Init()...");
    	
    	try {
    		ServletContext sc = event.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
	
			//jdbc 1단계
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName(sc.getInitParameter("driver"));
			ds.setUrl(sc.getInitParameter("url"));
			ds.setUsername(sc.getInitParameter("username"));
			ds.setPassword(sc.getInitParameter("password"));
			
			//jdbc 2단계
			conn = ds.getConnection();
			
			MemberDao memberDao = new MemberDao();
			memberDao.setDsConnection(conn);
			
			sc.setAttribute("memberDao", memberDao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    
    }
	
}
