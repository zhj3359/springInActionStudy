package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by jhj on 2016-05-10.
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ WebConfig.class };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ RootConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
