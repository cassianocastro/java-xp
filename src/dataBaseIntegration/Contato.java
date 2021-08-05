package dataBaseIntegration;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * @author cassiano
 */
public class Contato {
    private Long ID;
    private String nome, email, endereco;
    private Calendar data_nascimento;
    
    public Contato( Long ID, String nome, String email, String endereco, Calendar data_nascimento ){
        this.ID              = ID;
        this.nome            = nome;
        this.email           = email;
        this.endereco        = endereco;
        this.data_nascimento = data_nascimento;
    }
    public Long getID(){
        return this.ID;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public Calendar getData_nascimento() {
        return this.data_nascimento;
    }
    
    public String getDados(){
        return  "\nID: "                 + this.ID +
                "\nNome: "               + this.nome +
                "\nE-mail: "             + this.email +
                "\nEndereço: "           + this.endereco +
                "\nData de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy")
                                        .format(this.data_nascimento.getTime());
    }
}