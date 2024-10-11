package programa1.model.exceptions;

// CRIANDO EXCEPETION PARA SER LANÇADO NA RESERVA
// runtime exception (Não é obrigado a tratar a exceção)
// Exception ( é obrigado a tratar a exceção)
public class DomainException  extends RuntimeException{
    private static final long serialVersionUID = 1L; // versão da classe serializer

    // permitir que a excepetion seja instanciada com uma mensagem
    public  DomainException(String msg){
        super(msg);
    }



}
