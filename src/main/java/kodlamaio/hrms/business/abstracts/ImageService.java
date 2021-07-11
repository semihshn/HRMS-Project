package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService extends BaseService<Image,Integer>{
	
	Result add(int jobSeekerId,MultipartFile imageFile);

}
