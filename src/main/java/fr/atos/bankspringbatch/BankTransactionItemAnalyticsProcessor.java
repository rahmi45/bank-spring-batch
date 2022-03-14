package fr.atos.bankspringbatch;

import fr.atos.bankspringbatch.dao.BankTransaction;
import lombok.Getter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

//@Component
// processor avec etat => les attributs + memoire il va stocker des données.
//un processor est statless : c-à-d il y a une méthode qui fait des choses, mais ne garde rien.
public class BankTransactionItemAnalyticsProcessor implements ItemProcessor<BankTransaction, BankTransaction> {
    @Getter private double totalDebit;
    @Getter private double totalCredit;

    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        if(bankTransaction.getTransactionType().equals("D"))totalDebit += bankTransaction.getAmount();
        else if(bankTransaction.getTransactionType().equals("C"))totalCredit += bankTransaction.getAmount();

        return bankTransaction;
    }
}
