package projekti.demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface AlvoBeautyRepositorio extends CrudRepository<AlvoBeauty, Long>{
    AlvoBeauty findByaBId(Long aBId);
    /*List<AlvoBeauty> findByPalvId(Long palvId);
    List<AlvoBeauty> findBytTId(Long tTId);*/
}
