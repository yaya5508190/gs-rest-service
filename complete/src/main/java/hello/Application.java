package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

@ComponentScan
public class Application {

   @Bean
	public AnnotationMethodHandlerAdapter defultAbbitationAdapter(){
		AnnotationMethodHandlerAdapter amhd = new AnnotationMethodHandlerAdapter();
		HttpMessageConverter[] hmc = new HttpMessageConverter[1];
		MappingJackson2HttpMessageConverter mj = new MappingJackson2HttpMessageConverter();
		List<MediaType> l = new ArrayList<MediaType>();
		l.add(MediaType.APPLICATION_JSON);
		mj.setSupportedMediaTypes(l);
		hmc[0]= new MappingJackson2HttpMessageConverter();
		amhd.setMessageConverters(hmc);
		return amhd;
	}
	@Bean
	public EmbeddedServletContainerFactory defultEmbeddedServletContainerFactory(){
		TomcatEmbeddedServletContainerFactory escf = new TomcatEmbeddedServletContainerFactory();
		return escf;
	}
	
	@Bean
	public DispatcherServlet defultDispatcherServlet(){
		DispatcherServlet dahm = new DispatcherServlet();
		return dahm;
		
	}
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
