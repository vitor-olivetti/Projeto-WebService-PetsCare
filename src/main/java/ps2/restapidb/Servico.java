package ps2.restapidb;

import javax.persistence.*;

@Entity
@Table(name = "servicos")
public class Servico {

    @Id @GeneratedValue
    private long id;
    private String status;
    private String data;
    private String valor;
    private int nota;

    public Servico() {}
    public Servico(long id, String s, String d, String v, int n){

        this.id = id;
        this.status = s;
        this.data = d;
        this.valor = v;
        this.nota = n;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public String getData() {return data;}
    public void setData(String data) {this.data = data;}

    public String getValor() {return valor;}
    public void setValor(String valor) {this.valor = valor;}

    public int getNota() {return nota;}
    public void setNota(int nota) {this.nota = nota;}
}
