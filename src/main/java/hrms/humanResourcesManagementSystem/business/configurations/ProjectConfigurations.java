package hrms.humanResourcesManagementSystem.business.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.humanResourcesManagementSystem.core.utilities.results.cloudOperations.CloudService;
import hrms.humanResourcesManagementSystem.core.utilities.results.cloudOperations.CloudinaryManager;

@Configuration
public class ProjectConfigurations {

    @Value("${cld.access-key}")
    String apiAccessKey;
    @Value("${cld.secret-key}")
    String apiSecretKey;

	@Bean
	public Cloudinary cloudinaryUser() {
		return new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "da9ahn6im",
			"api_key", apiAccessKey,
			"api_secret", apiSecretKey
			));
	}

    @Bean
    public CloudService cloudService() {
        return new CloudinaryManager(cloudinaryUser());
    }

    @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}

