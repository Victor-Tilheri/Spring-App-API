package victortilheri.SpringApp.repository;

import org.springframework.data.repository.CrudRepository;
import victortilheri.SpringApp.model.UsuarioModel;

public interface UsuarioRespository extends CrudRepository<UsuarioModel, Integer> {
}
