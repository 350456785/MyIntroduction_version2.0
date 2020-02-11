package top.myideas;

import org.apache.catalina.connector.Connector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan({"top.myideas.mapper", "top.myideas.Dao"})
@PropertySource(value = {"classpath:config.properties"}, encoding = "utf-8")
@EnableSwagger2
public class MyIntroduction_App {
    public static void main(String[] args) {
        SpringApplication.run(MyIntroduction_App.class, args);
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {

            @Override
            public void customize(Connector connector) {
                //用于解决 RFC 3986的报错
                connector.setProperty("relaxedQueryChars", "|{}[]");
            }

        });
        return factory;
    }

}
