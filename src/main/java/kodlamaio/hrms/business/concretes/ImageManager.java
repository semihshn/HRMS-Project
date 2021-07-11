package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.adapters.cloudinaryService.CloudinaryAdapter;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class ImageManager implements ImageService{
	
	private ImageDao imageDao;
	private JobSeekerDao jobSeekerDao;
	private CloudinaryAdapter cloudinaryAdapter;
	
	@Autowired
	public ImageManager(ImageDao imageDao,CloudinaryAdapter cloudinaryAdapter,
						JobSeekerDao jobSeekerDao) {
		
		this.imageDao = imageDao;
		this.cloudinaryAdapter=cloudinaryAdapter;
		this.jobSeekerDao=jobSeekerDao;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Result add(int jobSeekerId, MultipartFile imageFile) {
		
		Map<String,String> uploadImage = this.cloudinaryAdapter.uploadImageFile(imageFile).getData();
		
		Image image=new Image();
		JobSeeker jobSeeker=this.jobSeekerDao.getOne(jobSeekerId);
		
		image.setUser(jobSeeker.getUser());
		image.setImageLink(uploadImage.get("url"));
		
		this.imageDao.save(image);
		return new SuccessResult("Image added");
		
	}
	
	@Override
	public Result add(Image entity) {
		// TODO Auto-generated method stub
		this.imageDao.save(entity);
		return new SuccessResult("Resim eklendi");
	}

	@Override
	public Result delete(Image entity) {
		// TODO Auto-generated method stub
		imageDao.delete(entity);
		return new SuccessResult("Resim kaydı silindi");
	}

	@Override
	public Result update(Image entity) {
		// TODO Auto-generated method stub
		this.imageDao.save(entity);
		return new SuccessResult("Resim kaydı güncellendi");
	}

	@Override
	public DataResult<List<Image>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(),"Resimler başarılı şekilde getirildi");
	}

	@Override
	public DataResult<Image> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Image>(this.imageDao.findById(id).get());
	}

}
