package controledeestoque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IntegracaoTest {
    @Test
    public void testeIntegracaoAdicaoEQuantidade() {
        // Crie um mock para a classe Estoque
        Estoque estoqueMock = Mockito.mock(Estoque.class);

        // Crie um objeto Produto
        Produto produto = new Produto("Produto1", 10);

        // Configurar o mock para retornar 0 quando verificar a quantidade no estoque
        Mockito.when(estoqueMock.obterQuantidadeEmEstoque("Produto1")).thenReturn(10);

        // Adicione o produto ao estoque
        estoqueMock.adicionarProduto(produto);

        // Verifique se o método de adição foi chamado
        Mockito.verify(estoqueMock).adicionarProduto(produto);

        // Verifique se a quantidade no estoque agora é 10
        int quantidadeNoEstoque = estoqueMock.obterQuantidadeEmEstoque("Produto1");
        assertEquals(10, quantidadeNoEstoque);
    }
}
