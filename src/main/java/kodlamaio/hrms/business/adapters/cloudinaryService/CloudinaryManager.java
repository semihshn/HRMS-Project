package kodlamaio.hrms.business.adapters.cloudinaryService;

import java.io.IOException;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryAdapter{
	
	private Cloudinary cloudinary;
	
	public CloudinaryManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dumceaten",
				"api_key", "223613328412727",
				"api_secret", "IhKdztXhR4ZbCtvhKGb8_wwWG4Y",
				"secure", true));
		
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return new ErrorDataResult<Map>();
		
	}
}

