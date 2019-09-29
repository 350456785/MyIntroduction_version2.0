package top.myideas;

import org.apache.catalina.connector.Connector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan({"top.myideas.mapper","top.myideas.Dao"})
public class MyIntroduction_App {

	public static void main(String[] args) {
		SpringApplication.run(MyIntroduction_App.class, args);
	}
	
	@Bean
	public ConfigurableServletWebServerFactory webServerFactory() {
		TomcatServletWebServerFactory factory=new TomcatServletWebServerFactory();
		factory.addConnectorCustomizers( new TomcatConnectorCustomizer() {

			@Override
			public void customize(Connector connector) {
				System.out.println("用于解决 RFC 3986的报错 ");
				connector.setProperty("relaxedQueryChars", "|{}[]");
			}
			
		});
		return factory;
	}

}
