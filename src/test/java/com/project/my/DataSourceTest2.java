package com.project.my;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;

public class DataSourceTest2 {

	@Inject
    private DataSource dataSource;
    
    @Test
    public void testConnection() throws Exception {
        
        try(Connection con = dataSource.getConnection()) {
            
            System.out.println(">>>>>>>>> mysql datasource connection Start <<<<<<<<< ");
            System.out.println(con);
            System.out.println(">>>>>>>>> mysql datasource connection End <<<<<<<<< ");
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
