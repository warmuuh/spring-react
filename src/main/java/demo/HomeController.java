package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import demo.jsx.JsxViewResolver;

@Controller
@SpringBootApplication
class HomeController {

	public static void main(String[] args) {
		SpringApplication.run(HomeController.class, args);
	}

	@Bean
	public JsxViewResolver resolver() {
		return new JsxViewResolver();
	}

	@RequestMapping("/")
	ModelAndView showDashboard() {
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("server", true);
		return mav;
	}
}