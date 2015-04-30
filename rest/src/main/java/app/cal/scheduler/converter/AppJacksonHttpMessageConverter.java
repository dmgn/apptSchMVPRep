package app.cal.scheduler.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

@SuppressWarnings("deprecation")
public class AppJacksonHttpMessageConverter extends
		MappingJacksonHttpMessageConverter {
	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType){
		return clazz.equals(String.class) ? false 
				: (this.getObjectMapper().canSerialize(clazz) && canWrite(mediaType));
		
	}
}
