package ps2.restapidb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
class CuidadorController {

    @Autowired
    private CuidadorRepo cuidadorRepo;

    public CuidadorController(){

    }

    //Listar todos os cuidadores da tabela
    @GetMapping("/api/cuidadores")
    Iterable<Cuidador> getCuidadores(@RequestParam Optional<Long> servicoId) {
		if (servicoId.isEmpty()) {
			return cuidadorRepo.findAll();			
		}
		return cuidadorRepo.findByServicoId(servicoId.get());
	}

    //Listar cuiador por Id
    @GetMapping("/api/cuidadores/{id}")
    Optional<Cuidador> getCuidador(@PathVariable long id) {
        return cuidadorRepo.findById(id);
    }

    //Criar um cuidador
    @PostMapping("/api/cuidadores")
    Cuidador createCuidador(@RequestBody Cuidador c) {
        Cuidador createdCuidador = cuidadorRepo.save(c);
        return createdCuidador;
    }

    //Editar um cuidador
    @PutMapping("/api/cuidadores/{cuidadorId}")
    Optional<Cuidador> updateCuidador(@RequestBody Cuidador cuidadorRequest, @PathVariable long cuidadorId) {
		Optional<Cuidador> opt = cuidadorRepo.findById(cuidadorId);
		if (opt.isPresent()) {
			if (cuidadorRequest.getId() == cuidadorId) {
				cuidadorRepo.save(cuidadorRequest);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do cuidador com id " + cuidadorId);	
	}	

    //Deletar um cuidador
    @DeleteMapping(value = "/api/cuidadores/{id}")
    void deleteCuidador(@PathVariable long id) {
        cuidadorRepo.deleteById(id);
    }

}
