import entities.*;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Samuel");

        Conta cc = new ContaCorrente(cliente);
        cc.depositar(100);
        cc.imprimirExtrato();

        Conta poupanca = new ContaPoupanca(cliente);
        cc.transferir(poupanca, 200);
        poupanca.imprimirExtrato();

        Banco banco = new Banco();
        banco.getContas().add(cc);
        banco.getContas().add(poupanca);
        banco.listarClientes();
    }
}
