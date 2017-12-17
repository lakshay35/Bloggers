package boundary;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class TemplateProcessor {

    private String templateDir;
    private Configuration cfg;

    public TemplateProcessor(String templateDir, ServletContext servletContext) {
        this.setTemplateDir(templateDir);
        cfg = new Configuration(Configuration.VERSION_2_3_26);
        cfg.setServletContextForTemplateLoading(servletContext, templateDir);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

    }

    public void process(String templateName, HashMap root, HttpServletResponse response) {
        try {
            Template template = cfg.getTemplate(templateName);
            template.process(root, response.getWriter());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTemplateDir() {
        return templateDir;
    }

    public void setTemplateDir(String templateDir) {
        this.templateDir = templateDir;
    }

    public Configuration getCfg() {
        return cfg;
    }

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }
}
