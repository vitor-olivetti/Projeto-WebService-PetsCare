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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
class ServicoController {

    @Autowired
    private ServicoRepo servicoRepo;

    public ServicoController(){

    }

    //Listar todos os servicos da tabela
    @GetMapping("/api/servicos")
    Iterable<Servico> getServicos() {return servicoRepo.findAll();}

    //Listar cuiador por Id
    @GetMapping("/api/servicos/{id}")
    Optional<Servico> getServico(@PathVariable long id) {return servicoRepo.findById(id);}

    //Criar um servico
    @PostMapping("/api/servicos")
    Servico createServico(@RequestBody Servico s) {
        Servico createdServico = servicoRepo.save(s);
        return createdServico;
    }

    //Editar um servico
    @PutMapping("/api/servicos/{servicoId}")
    Optional<Servico> updateServico(@RequestBody Servico servicoRequest, @PathVariable long servicoId) {
        Optional<Servico> opt = this.getServico(servicoId);

        if (opt.isPresent()) {
            Servico servico = opt.get();

            if (servicoRequest.getId() == servico.getId()) {
                servico.setStatus(servicoRequest.getStatus());
                servico.setData(servicoRequest.getData());
                servico.setValor(servicoRequest.getValor());
                servico.setNota(servicoRequest.getNota());

                servicoRepo.save(servico);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do servico de id " + servicoId);
    }

    //Deletar um servico
    @DeleteMapping(value = "/api/servicos/{id}")
    void deleteServico(@PathVariable long id) {servicoRepo.deleteById(id);}

}