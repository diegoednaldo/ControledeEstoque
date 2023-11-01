package controledeestoque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estoque {
    private Map<String, Produto> produtos = new HashMap<>();

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getNome(), produto);
    }

    public int obterQuantidadeEmEstoque(String nome) {
        Produto produto = produtos.get(nome);
        return produto != null ? produto.getQuantidade() : 0;
    }

    public List<String> listarProdutosEmEstoque() {
        return new ArrayList<>(produtos.keySet());
    }

    public void atualizarQuantidade(String nome, int novaQuantidade) {
        Produto produto = produtos.get(nome);
        if (produto != null) {
            produto.atualizarQuantidade(novaQuantidade);
        }
    }

    public boolean abaixoDoEstoqueMinimo(String nome, int limiteMinimo) {
        int quantidadeEmEstoque = obterQuantidadeEmEstoque(nome);
        return quantidadeEmEstoque < limiteMinimo;
    }

    public void removerProduto(String nome) {
        produtos.remove(nome);
    }

    public Produto consultarProdutoPorNome(String nome) {
        return produtos.get(nome);
    }

    public void reabastecerEstoque(String nome, int quantidade) {
        Produto produto = produtos.get(nome);
        if (produto != null) {
            produto.atualizarQuantidade(produto.getQuantidade() + quantidade);
        }
    }

    public void registrarEntrada(String nome, int quantidade) {
        Produto produto = produtos.get(nome);
        if (produto != null) {
            produto.atualizarQuantidade(produto.getQuantidade() + quantidade);
        }
    }

    public void registrarSaida(String nome, int quantidade) {
        Produto produto = produtos.get(nome);
        if (produto != null) {
            produto.atualizarQuantidade(produto.getQuantidade() - quantidade);
        }
    }
}