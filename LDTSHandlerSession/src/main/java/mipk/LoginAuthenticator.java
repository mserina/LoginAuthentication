package mipk;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginAuthenticator
 * 
 * Esto es una clase que se deriva de la clase HttpServlet por lo que se considera como un servlet
 * ACLARACION: Un servlet es una clase Java que maneja solicitudes HTTP 
 */
public class LoginAuthenticator extends HttpServlet {
	
	//es como una etiqueta de versión para asegurarse de que los objetos serializados y deserializados son compatibles.
	//SERELIZADO: OBJETO --> BYTES
	//DESREALIZADO: BYTES --> OBJETO
	private static final long serialVersionUID = 1L;
	private String usuvalido = "admin";
	private String pwdvalida = "123";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAuthenticator() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Es un metodo de una clase servlet, que se encarga de manejar las solictudes HTTP GET
     * REQUEST --> La solicitud que recibe el servlet
     * RESPONSE --> La respuesta que enviara el servlet al cliente (p ej: navegador web) 
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		beanDB db = new beanDB();
		HttpSession session = request.getSession();
		String usuario=request.getParameter("usuario");
		String pass=request.getParameter("pass");
		if (usuario == null) usuario="";
		if (pass == null) pass="";
		boolean ok=false;
		
		if(usuario.equals(usuvalido) && pass.equals(pwdvalida)) {
			session.setAttribute("attributo2",usuario);
			session.setAttribute("attributo1","1");
			ok=true;
		}
				
		if (ok) response.sendRedirect("bienvenido.jsp");
		else response.sendRedirect("index.jsp");

	}


}
