package mailtemplatehandler;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import mailtemplatehandler.service.MailTypesService;

@Profile("test")
@Configuration
public class RunProjectTestConfiguration {
   @Bean
   @Primary
   public MailTypesService mailTypesService() {
	   
      return Mockito.mock(MailTypesService.class);
   }
}