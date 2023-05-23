
import java.util.Observable;
import java.util.Observer;
public class Usuario implements Observer{
    private Email cadastroEmail;
    private String notificacao;

    public Usuario(Email enderecoEmail) {

        this.cadastroEmail = enderecoEmail;
    }

    public String getNotificacao() {
        return this.notificacao;
    }

    public void cadastrarEmail(Email email) {
        email.addObserver(this);
    }

    public void update(Observable email, Object arg1) {
        this.notificacao = Email.nomeUsuario + ", você recebeu um e-mail. " + "=> " + email.toString();
    }

}
