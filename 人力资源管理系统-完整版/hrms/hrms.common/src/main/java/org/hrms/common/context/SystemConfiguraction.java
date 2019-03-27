package org.hrms.common.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfiguraction {

	@Value("#{application[website]}") 
    public String website;  
	
	@Value("#{application[webname]}")
    public String webname;
	
	@Value("#{application[upload]}")
    public String upload;
	
	@Value("#{application[report]}")
    public String report;
	
}
