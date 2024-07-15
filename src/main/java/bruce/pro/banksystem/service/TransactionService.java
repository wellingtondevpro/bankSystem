package bruce.pro.banksystem.service;


import bruce.pro.banksystem.domain.repository.TransactionRepository;
import bruce.pro.banksystem.domain.repository.UsuarioRepository;
import bruce.pro.banksystem.domain.transaction.Transaction;
import bruce.pro.banksystem.domain.transaction.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@Service

public class TransactionService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RestTemplate restTemplate;

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public Transaction createTransaction(TransactionDTO transaction) throws Exception {

        var payer = this.usuarioService.BuscarUsuarioId(transaction.payerId());
        var payee = this.usuarioService.BuscarUsuarioId(transaction.payeeId());

        if(payer == null || payee == null) {
            throw new Exception("Esse usuario não existe");
        }
        usuarioService.validactionUsuario(payer, transaction.amount());

        boolean isAuthorize = authorizeTransaction();

        if (!isAuthorize) {
            throw new Exception("Transação não autorizada para o usuario");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.amount());
        newTransaction.setPayer(payer);
        newTransaction.setPayee(payee);
        newTransaction.setTransactionTime(LocalDateTime.now());


        payer.setBalance(payer.getBalance().subtract(transaction.amount()));
        payee.setBalance(payee.getBalance().add(transaction.amount()));

        this.transactionRepository.save(newTransaction);
        this.usuarioService.atualizarUsuario(payer);
        this.usuarioService.atualizarUsuario(payee);

        return newTransaction;
    }


    public boolean authorizeTransaction(){
        var response = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

        if(response.getStatusCode() == HttpStatus.OK){
            String message = (String) response.getBody().get("message");
            return "Authorizado com sucesso!".equalsIgnoreCase("massage");
        }else return false;
    }
}
