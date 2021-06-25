package ps2.restapidb;

import org.springframework.data.repository.CrudRepository;

public interface CuidadorRepo extends CrudRepository<Cuidador, Long> {
    Iterable<Cuidador> findByServicoId(Long servicoId);
}
