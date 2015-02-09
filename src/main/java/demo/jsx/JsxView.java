package demo.jsx;

import java.text.MessageFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;

import org.apache.commons.io.IOUtils;
import org.springframework.web.servlet.view.AbstractView;

import de.matrixweb.jreact.JReact;

@AllArgsConstructor
public class JsxView extends AbstractView {

	private JReact renderer;
	private String viewName;
	private MessageFormat indexTemplate;

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		String content = renderer.renderToString("./"+viewName, model);
		renderer.reset();
		
		IOUtils.write(indexTemplate.format(new String[]{content}), response.getOutputStream());
	}

}
