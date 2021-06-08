package hrms.humanResourcesManagementSystem.core.utilities.results.cloudOperations;

import org.springframework.web.multipart.MultipartFile;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;

public interface CloudService {
	DataResult<?> save(MultipartFile file);
}
