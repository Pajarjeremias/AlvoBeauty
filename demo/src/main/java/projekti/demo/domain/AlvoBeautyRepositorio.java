package projekti.demo.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface AlvoBeautyRepositorio extends CrudRepository<AlvoBeauty, Long>{
    AlvoBeauty findByaBId(Long aBId);
}
