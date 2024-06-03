package mipk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class beanDB {
	   // Variables del bean
	   private Connection cn;   //La conexion a la base de datos

	   //----- Metodo que realiza la conexion a la BD
		public void conectarBD() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			cn=DriverManager.getConnection("jdbc:mysql://servidormysql/nombredb","usuariodb","passwddb");
		}

	    //----- Método que realiza la desconexión de la BD
	    public void desconectarBD()
	    {
	        try{
	         	cn.close();
	        }catch (NullPointerException e){
	        	System.out.println("Excepcion, en metodo DesconectarBD: " + e.getMessage());
	        }
	    	catch (SQLException e){
	    		System.out.println("Excepcion, en metodo DesconectarBD: " + e.getMessage());
	    	}
	    }


	    public  String[][] resConsultaSelectA3(String selec) throws SQLException
		   {
		    Statement stmt=null;
		    ResultSet rs=null;
		    String[][] result=null;

		    try{
		          stmt=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		          rs=stmt.executeQuery(selec);
		          boolean hayFilas=rs.last(); //Movemos a la ultima fila para comprobar si hay filas, 
		          if (hayFilas) 
		          {
		        	  ResultSetMetaData rsmd = rs.getMetaData();
		        	  int numberOfColumns = rsmd.getColumnCount();
		        	  int numberOfRows = rs.getRow();
		        	  result=new String[numberOfRows][numberOfColumns];
		        	  rs.beforeFirst();
		        	  int i=0;
		        	  while (rs.next())
		        	  {
		        		  int j = 0;
		        		  while (j<numberOfColumns)
		        		  {
		        			  try {
		        				  if (!rs.getString(j+1).equals("null")) result[i][j]=rs.getString(j+1);
		        				  else result[i][j]="";
		        			  }
		        			  catch (Exception e2) {
		        				  result[i][j]="";
		        			  }
		        			  j++;
		        		  }
	        			  i++;
		        	  }
		          }
		          
		    }catch(SQLException e){
		          System.out.println("Excepcion, en acceso a BD: " + e.getMessage());
		          System.out.println("La consulta ejecutada fue: " + selec);
		    }
		    catch (NullPointerException e) {
		    	System.out.println(e.getMessage());
		    }
		    catch (Exception e)
		    {
		    	System.out.println(e.getMessage());
		    }
		    return result;
		   }

		public  void update(String updateStatement)
		{
			Statement stmt=null;
			try
			{
				stmt=cn.createStatement();
				stmt.executeUpdate(updateStatement);
			}
			catch(SQLException e)
			{
		          System.out.println("Excepcion, en acceso a BD: " + e.getMessage());
		          System.out.println("La consulta ejecutada fue: " + updateStatement);
			}
		}

		public void insert(String insertStatement)
		{
			Statement stmt=null;
			try
			{
	      		stmt=cn.createStatement();
				stmt.execute(insertStatement);
			}
			catch(SQLException e)
			{
		          System.out.println("Excepcion, en acceso a BD: " + e.getMessage());
		          System.out.println("La consulta ejecutada fue: " + insertStatement);
			}
		}

		public  void delete(String deleteStatement)
		{
			Statement stmt=null;
			try
			{
	      		stmt=cn.createStatement();
				stmt.execute(deleteStatement);
			}
			catch(SQLException e)
			{
		          System.out.println("Excepcion, en acceso a BD: " + e.getMessage());
		          System.out.println("La consulta ejecutada fue: " + deleteStatement);
			}
			desconectarBD();
		}
		
	
}
