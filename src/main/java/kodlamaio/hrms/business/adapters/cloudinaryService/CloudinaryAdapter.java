package kodlamaio.hrms.business.adapters.cloudinaryService;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.result.DataResult;

public interface CloudinaryAdapter {

	@SuppressWarnings("rawtypes")
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
	
}
