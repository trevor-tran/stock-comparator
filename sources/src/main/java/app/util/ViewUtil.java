package app.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.eclipse.jetty.http.HttpStatus;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

public class ViewUtil {

	/**
    Renders a template given a model and a request
    */
	public static String render (Request request, Map<String,Object> model, String templatePath ) {
		model.put("currentUserId", request.session().attribute("currentUserId"));
		model.put("firstName", request.session().attribute("firstName"));
		model.put("WebPath", Path.Web.class);  // Access application URLs from templates
		return strictVelocityEngine().render( new ModelAndView(model, templatePath));
	}
	
	public static Route notAcceptable = (Request request, Response response) -> {
        response.status(HttpStatus.NOT_ACCEPTABLE_406);
        return "No suitable content found. Please specify either 'html/text' or 'application/json'.";
    };
    
	public static Route notFound = (Request request, Response response) -> {
		response.status(HttpStatus.NOT_FOUND_404);
		return render(request, new HashMap<>(), Path.Templates.NOT_FOUND); 
	};
	
	private static VelocityTemplateEngine strictVelocityEngine() {
        VelocityEngine configuredEngine = new VelocityEngine();
        configuredEngine.setProperty("runtime.references.strict", true);
        configuredEngine.setProperty("resource.loader", "class");
        configuredEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return new VelocityTemplateEngine(configuredEngine);
    }
}
