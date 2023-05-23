import java.time.LocalDateTime;
import java.util.Observable;

public class Email extends Observable {
    LocalDateTime dateTime = LocalDateTime.now();
    int ano = dateTime.getYear();
    int mes = dateTime.getMonthValue();
    int dia = dateTime.getDayOfMonth();

    static String nomeUsuario;

    String enderecoEmail;
    String remetente;
    String destinatario;
    String conteudo;

    public Email(int ano, int mes, int dia, String nomeUsuario, String enderecoEmail) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.nomeUsuario = nomeUsuario;
        this.enderecoEmail = enderecoEmail;
    }
    public void enviarEmail(int ano, int mes, int dia, String nomeUsuario, String enderecoEmail, String remetente, String destinatario, String conteudo){
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.nomeUsuario = nomeUsuario;
        this.enderecoEmail = enderecoEmail;
        this.remetente = remetente;
        this.destinatario = destinatario;

        setChanged();
    }
    public void receberEmail(int ano, int mes, int dia, String remetente, String conteudo){
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.remetente = remetente;
        this.conteudo = conteudo;

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        String dataFormatada = String.format("%02d/%02d/%04d", dia, mes, ano);
        return "Email:{" +
                "recebido em: " + dataFormatada +
                " de: " + remetente + " - " + "("+enderecoEmail+") -" +
                " conteúdo: " + conteudo +
                '}';
    }
}
