package ps2.restapidb;

import javax.persistence.*;

@Entity
@Table(name = "cuidadores")
public class Cuidador {

    @Id @GeneratedValue
    private long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String regiao;

    @ManyToOne(optional=false)
	private Servico servico;

    public Cuidador() {}
    public Cuidador(long id, String n, String c, String t, String r){

        this.id = id;
        this.nome = n;
        this.cpf = c;
        this.telefone = t;
        this.regiao = r;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getRegiao() {return regiao;}
    public void setRegiao(String regiao) {this.regiao = regiao;}

    public Servico getServico(){
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

}
