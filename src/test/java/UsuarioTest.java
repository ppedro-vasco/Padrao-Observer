import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    @Test
    void deveNotificarUmUsuario() {
        Email email = new Email(2011, 04, 02, "Marcos Vasconcelos", "mevs_hist@yahoo.com.br");
        Usuario usuario = new Usuario(new Email(2019, 04, 13, "Pedro Vasconcelos", "pedrovasconcelos.henrique@gmail.com"));
        usuario.cadastrarEmail(email);
        email.receberEmail(2023, 05, 23, "Marcos Vasconcelos", "Olá, saudações de envio de e-mail.");

        assertEquals("Pedro Vasconcelos, você recebeu um e-mail. => " +
                "Email:{recebido em: 23/05/2023 de: Marcos Vasconcelos - " +
                "(mevs_hist@yahoo.com.br) - conteúdo: Olá, saudações de envio de e-mail.}", usuario.getNotificacao());
    }

    @Test
    void naoDeveNotificarUmUsuario(){

            Email email = new Email(2011, 04, 02, "Marcos", "mevs_hist@yahoo.com.br");
            Usuario usuario = new Usuario(new Email(2019, 04, 13, "Pedro", "pedrovasconcelos.henrique@gmail.com"));
            email.receberEmail(2023, 05, 23, "Marcos Vasconcelos", "Olá, saudações de envio de e-mail.");

            assertEquals(null, usuario.getNotificacao());
    }
}
