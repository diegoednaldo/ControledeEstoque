package controledeestoque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProdutoTest {
    @Test
    public void testeConstrutorProduto() {
        Produto produto = new Produto("Produto1", 10);
        assertEquals("Produto1", produto.getNome());
        assertEquals(10, produto.getQuantidade());
    }

    @Test
    public void testeGetNomeProduto() {
        Produto produto = new Produto("Produto2", 5);
        assertEquals("Produto2", produto.getNome());
    }

    @Test
public void testeAtualizarQuantidadeProduto() {
    Produto produto = new Produto("Produto3", 15);
    produto.atualizarQuantidade(20);
    assertEquals(20, produto.getQuantidade());
}

@Test
public void testeAtualizarQuantidadeMaiorProduto() {
    Produto produto = new Produto("Produto6", 10);
    produto.atualizarQuantidade(15);
    assertEquals(15, produto.getQuantidade()); // Verifique se a quantidade pode ser atualizada para um valor maior
}
}
