package com.myapp.struts.action;

import com.javarevolutions.jdbc.dao.IfaceLogin;
import com.javarevolutions.jdbc.dao.ImplLogin;
import com.myapp.struts.form.LoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author mxds-2003
 */
public class LoginAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	private static final String SUCCESS = "success";

	/**
	 * This is the action called from the Struts framework.
	 *
	 * @param mapping The ActionMapping used to select this instance.
	 * @param form The optional ActionForm bean for this request.
	 * @param request The HTTP Request we are processing.
	 * @param response The HTTP Response we are processing.
	 * @throws java.lang.Exception
	 * @return
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		LoginForm login = (LoginForm) form;
		System.out.println("user: " + login.getUser());
		System.out.println("password: " + login.getPassword());
		IfaceLogin iface = new ImplLogin();
		login = iface.validaLogin(login);
		if (login != null) {
			System.out.println("nombre: " + login.getNombre());
			System.out.println("edad: " + login.getEdad());
			return mapping.findForward(SUCCESS);
		} else {
			return mapping.findForward("error");
		}
	}
}
