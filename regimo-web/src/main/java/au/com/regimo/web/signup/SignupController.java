package au.com.regimo.web.signup;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import au.com.regimo.core.domain.Document;
import au.com.regimo.core.domain.User;

import au.com.regimo.core.service.DocumentService;
import au.com.regimo.core.service.UserService;
import au.com.regimo.core.utils.BeanUtilsExtend;
import au.com.regimo.core.utils.SecurityUtils;

import au.com.regimo.web.form.UserNewForm;

@Controller
public class SignupController {

	private UserService userService;
	private DocumentService documentService;
	
	/**
	 * Render a signup form to the person as HTML in their web browser.
	 */
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public UserNewForm signupForm(WebRequest request) {
		return new UserNewForm();
	}

	/**
	 * Process a signup form submission.
	 * Redirects the new member to the application home page on successful sign-in.
	 * @throws IOException 
	 */
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid UserNewForm form, BindingResult formBinding) {
		if (formBinding.hasErrors()) {
			return null;
		}
		User user = new User();
		BeanUtilsExtend.copyPropertiesWithoutNull(form, user, "image");
		userService.signup(user);
		SecurityUtils.setAuthentcation(user, form.getPassword());
		return "redirect:/";
	}
	
	@RequestMapping(value="/rest/user", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void restSignup(@Valid @ModelAttribute UserNewForm form, BindingResult formBinding, 
			HttpServletResponse response) throws IOException {
		if (formBinding.hasErrors()) {
			return ;
		}
		User user = new User();
		BeanUtilsExtend.copyPropertiesWithoutNull(form, user, "image");
		if(form.getImage()!=null){
			Document image = documentService.saveBase64DecodeImage("userimage.jpg", form.getImage(), "image/jpeg");
			user.setImage(image);
		}
		userService.signup(user);		
		response.addHeader("Location", user.getId().toString());
	}

	@Inject
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Inject
	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
	
}
