package top.myideas.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Error implements ErrorController{
	private static final String ERROR_PATH = "/error";

	@RequestMapping(value = ERROR_PATH)
	public String handleError(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(req.getContextPath());
		return "404";
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
