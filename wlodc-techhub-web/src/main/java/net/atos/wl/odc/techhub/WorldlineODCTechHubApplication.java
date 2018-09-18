/**
 * 
 */
package net.atos.wl.odc.techhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Entry point for the Worldline ODC Technology Hub Application.
 * 
 * <p>
 * The @SpringBootApplication is a convenience annotation that adds all of the
 * following:
 * <ul>
 * <li>@Configuration tags the class as a source of bean definitions for the
 * application context.</li>
 * <li>@EnableAutoConfiguration tells Spring Boot to start adding beans based on
 * classpath settings, other beans, and various property settings.</li>
 * <li>Normally you would add @EnableWebMvc for a Spring MVC app, but Spring
 * Boot adds it automatically when it sees spring-webmvc on the classpath. This
 * flags the application as a web application and activates key behaviors such
 * as setting up a DispatcherServlet.</li>
 * <li>@ComponentScan tells Spring to look for other components, configurations,
 * and services in the package, allowing it to find the controllers.</li>
 * </ul>
 * </p>
 * 
 * @author a120065
 */
@SpringBootApplication
@ImportResource({"classpath*:wlodc-techhub-web.xml"})
public class WorldlineODCTechHubApplication {

    /**
     * The main method uses Spring Boots SpringApplication.run method to launch
     * an application.
     * 
     * @param args
     *            String[]
     */
    public static void main(final String[] args) {
        SpringApplication.run(WorldlineODCTechHubApplication.class, args);
    }
}
