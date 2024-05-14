package entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Banco {

    private String nome;
    private List<Conta> contas = new ArrayList<Conta>();

    public void listarClientes() {
        System.out.println("=== Lista de clientes (tipo de conta) ===");
        for (Conta conta : contas) {
            System.out.println(conta.getCliente().getNome()
                    + (conta instanceof ContaCorrente ? " (Conta Corrente)" : " (Conta Poupança)"));
        }
    }
}
