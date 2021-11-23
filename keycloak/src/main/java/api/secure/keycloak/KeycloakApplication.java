package api.secure.keycloak;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeycloakApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeycloakApplication.class, args);
    }

    private static Log logger = LogFactory.getLog(ProductApplication.class);

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {

            public void contextInitialized(ServletContextEvent sce) {
                logger.info("ServletContext initialized");
            }

            public void contextDestroyed(ServletContextEvent sce) {
                logger.info("ServletContext destroyed");
            }

        };
    }

    @Bean
    public CacheControlHandlerInterceptor cacheControlHandlerInterceptor() {
        return new CacheControlHandlerInterceptor();
    }
}
