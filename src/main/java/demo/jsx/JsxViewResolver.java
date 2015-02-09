package demo.jsx;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Locale;

import javax.annotation.PostConstruct;

import lombok.Setter;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import de.matrixweb.jreact.JReact;

public class JsxViewResolver implements ViewResolver {

	@Setter String prefix = "static/";
	@Setter String suffix = ".js";
	@Setter String indexFile = "/templates/index.html";

	private JReact renderer;
	private MessageFormat format;

	@PostConstruct
	public void init() throws IOException{
		renderer = new JReact(true);
		renderer.addRequirePath(prefix);
		
		ClassPathResource res = new ClassPathResource(indexFile);
		format = new MessageFormat(IOUtils.toString(res.getInputStream()));
		
		//warmup js engine:
		try {
			renderer.renderToString("non.existant", Collections.emptyMap());
		} catch (Throwable e) { /* ignore */ }
		renderer.reset();
	}
	
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		return new JsxView(renderer, viewName + suffix, format);
	}
}
