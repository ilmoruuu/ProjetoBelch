package PadroesProjeto.Observer;

import PadroesProjeto.Strategy.Pedido;

import java.util.List;

public class Cliente implements ClienteObserver{

    private String nome;
    private String email;
    private String telefone;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public void atualizar(Produto produto) {
        if (!produto.isDisponivel()) {
            System.out.println("O produto " + produto.getNome() + " está indisponível no momento.");
        } else {
            System.out.println("O produto " + produto.getNome() + " está disponível no momento.");
        }

        if (!produto.getPrecoAtual().equals(produto.getPrecoAnterior())) {
            System.out.println("O preço do produto " + produto.getNome() + " mudou!");
            System.out.println("Preço anterior: R$ " + produto.getPrecoAnterior());
            System.out.println("Novo preço: R$ " + produto.getPrecoAtual());
        } else {
            System.out.println("O preço do produto " + produto.getNome() + " permanece em R$ " + produto.getPrecoAtual());
        }
    }

    @Override
    public void atualizar(Pedido pedido) {
        if(pedido.isConfirmado()){
            System.out.println("O pedido foi confirmado.");
        } else {
            System.out.println("O pedido foi negado.");
        }
    }
}
