package entities;

import lombok.Data;
import org.w3c.dom.ls.LSOutput;

@Data
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Não há saldo suficiente");
        }
    }

    @Override
    public void depositar(double valor) {
        if(valor > 0) {
            this.saldo += valor;
        }
    }

    @Override
    public void transferir(Conta destino, double valor) {
        System.out.println("Iniciando transferência...");
        if(valor > 0){
            if(this.saldo >= valor) {
                this.sacar(valor);
                destino.depositar(valor);
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Erro: Saldo insuficiente na conta de origem.");
            }
        } else {
            System.out.println("Erro: Valor deve ser maior que 0.");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
