package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.adapters.emailService.EmailAdapter;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmailActivationDao;
import kodlamaio.hrms.entities.concretes.EmailActivation;
import kodlamaio.hrms.entities.dtos.EmailActivationForVerifyDto;
import kodlamaio.hrms.entities.dtos.EmailActivationWithUserDto;
import kodlamaio.hrms.business.constants.Messages;

@Service
public class EmailActivationManager implements EmailActivationService{

	private EmailActivationDao emailActivationDao;
	private final EmailAdapter emailAdapter;
	private final UserService userService;
	
	@Autowired
	public EmailActivationManager(EmailActivationDao emailActivationDao,EmailAdapter emailAdapter,UserService userService) {
		super();
		this.emailActivationDao = emailActivationDao;
		this.emailAdapter = emailAdapter;
		this.userService = userService;
	}

	@Override
	public Result add(EmailActivation emailActivation) {
		// TODO Auto-generated method stub
		this.emailActivationDao.save(emailActivation);
		return new SuccessResult("E-mail eklendi");
	}

	@Override
	public Result update(EmailActivation emailActivation) {
		// TODO Auto-generated method stub
		return new SuccessResult("E-mail güncellendi");
	}

	@Override
	public Result delete(EmailActivation emailActivation) {
		// TODO Auto-generated method stub
		return new SuccessResult("E-mail silindi");
	}

	@Override
	public DataResult<List<EmailActivation>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<EmailActivation>>(emailActivationDao.findAll());
	}

	@Override
	public DataResult<EmailActivation> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<EmailActivation>(this.emailActivationDao.findById(id).get());
	}

	@Override
	public Result verify(final EmailActivationForVerifyDto emailActivationForVerifyDto) {
		final Optional<EmailActivation> emailActivation = emailActivationDao.findByActivationCode(
				emailActivationForVerifyDto.getActivationCode());

		Result result=BusinessRules.run(this.IsUserForEmail(emailActivationForVerifyDto.getEmail())
						);

		if (result.isSuccess()) {
		return result;
		}
		
		if (emailActivation.isEmpty())
			return new ErrorResult("Email doğrulanamadı");

		emailActivation.get().setIsActivated(true);
		emailActivationDao.save(emailActivation.get());

		return new SuccessResult("Email doğrulandı");
	}
	
	@Override
	public Result createAndSendActivationCodeByMail(final User user, final String... emails) {

		for (final String email : emails) {
			final EmailActivation emailActivation = EmailActivation.builder()
					.user(user)
					.activationCode("EmailActivationCodeTEST") // TODO create activationCode
					.build();
			emailActivationDao.save(emailActivation);
			emailAdapter.send(email,
					"Hesabınızı doğrulayın lütfen",
					String.format("%swww.localhost:8080/api/emailactivations/verify?activationCode=%s&email=%s",
							Messages.emailActivationVerifyEmailBody,
							emailActivation.getActivationCode(),
							email));
		}

		return new SuccessResult(Messages.emailActivationCreatedAndSent);
	}
	
	//EmailActivation tablosundan hedef email olan değeri çekiyor
	@Override
	public DataResult<EmailActivationWithUserDto> getByEmail(String email) {
		final Optional<EmailActivationWithUserDto> emailActivation = emailActivationDao.findByEmail(email);

		if (emailActivation.isEmpty())
			return new ErrorDataResult<EmailActivationWithUserDto>("Email aktivasyon kodu bulunamadı");

		return new SuccessDataResult<EmailActivationWithUserDto>(emailActivation.get());
	}
	
	//User tablosunda hedef email var mı kontrol ediyor
	public Result IsUserForEmail (String email) {
		return userService.getByEmailWithEmail(email).getData().getEmail().isEmpty() ? new SuccessResult()
				: new ErrorResult("Bu emaile ait kullanıcı bulunamadı");
	}

	@Override
	public Result check(String email) {
		// TODO Auto-generated method stub
		return this.getByEmail(email).isSuccess() ? new SuccessResult()
				: new ErrorResult("Bu email doğrulanmamış");
	}
	

}
