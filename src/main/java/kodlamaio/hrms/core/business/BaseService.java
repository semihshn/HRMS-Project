package kodlamaio.hrms.core.business;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;

public interface BaseService<T, Id> {
	Result add(T entity);

	Result delete(T entity);
	
	Result update(T entity);

	DataResult<List<T>> getAll();

	DataResult<T> getById(Id id);

}
