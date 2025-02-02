package aplicacao.entidades;

import padroesProjeto.observer.ClienteObserver;
import padroesProjeto.observer.Subject;
import padroesProjeto.strategy.strategyInterface.PagamentoStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Subject {

    private List<ClienteObserver> clientes;
    private PagamentoStrategy pagamentoStrategy;
    private float valorPedido;
    private List<Produto> conteudoPedido;
    private String nomeCliente;
    private LocalDateTime dataHoraPedido;
    private boolean confirmado;

    public Pedido(String nomeCliente) {
        this.clientes = new ArrayList<>();
        this.pagamentoStrategy = pagamentoStrategy;
        this.conteudoPedido = conteudoPedido;
        this.nomeCliente = nomeCliente;
        this.dataHoraPedido = dataHoraPedido;
        this.confirmado = false;
    }

    @Override
    public void adicionarObservador(ClienteObserver clienteObserver) {
        if (!clientes.contains(clienteObserver)) {
            clientes.add(clienteObserver);
        }
    }

    @Override
    public void removerObservador(ClienteObserver clienteObserver) {
        clientes.remove(clienteObserver);
    }

    @Override
    public void notificar() {
        for (ClienteObserver clienteObserver : clientes) {
            clienteObserver.atualizar(this);
        }
    }

    public float calcularPagamento(){
        float acc = 0;
        for (Produto p : conteudoPedido){
            acc += p.getPrecoAtual();
        }
        return acc;
    }

    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void realizarPagamento(float valorSerPago) {
        pagamentoStrategy.realizarPagamento(valorSerPago);
    }

    public void setValorPedido(float valorPedido) {
        this.valorPedido = valorPedido;
    }

    public List<ClienteObserver> getCliente() {
        return clientes;
    }

    public PagamentoStrategy getPagamentoStrategy() {
        return pagamentoStrategy;
    }

    public float getValorPedido() {
        return valorPedido;
    }

    public List<Produto> getConteudoPedido() {
        return conteudoPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDateTime getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setConteudoPedido(List<Produto> conteudoPedido) {
        this.conteudoPedido = conteudoPedido;
    }
}

