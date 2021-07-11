package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Image;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
	
	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		this.imageService=imageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Image>> getAll(){
		return this.imageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam(value = "jobseekerId") int jobseekerId,@RequestParam(value = "imageFile") MultipartFile imageFile) {
		return this.imageService.add(jobseekerId,imageFile);
	}

}
