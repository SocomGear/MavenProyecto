

package com.gonzalez.mavenproyecto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableWebMvc
@Configuration
@ComponentScan("com.gonzalez.mavenproyecto")
public class WebAppConfig extends WebMvcConfigurerAdapter {
 
 
}
