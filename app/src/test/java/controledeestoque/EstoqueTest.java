package controledeestoque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EstoqueTest {
     @InjectMocks
    private Estoque estoque;

    @Mock
    private Produto produtoMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testeIntegracaoAdicaoProdutoAoEstoque() {
        // Configurar o comportamento do mock para a classe Produto
        when(produtoMock.getNome()).thenReturn("ProdutoMock");
        when(produtoMock.getQuantidade()).thenReturn(5);

        // Adicionar o produto mock ao estoque
        estoque.adicionarProduto(produtoMock);

        // Verificar a quantidade no estoque
        assertEquals(5, estoque.obterQuantidadeEmEstoque("ProdutoMock"));
    }

    @Test
    public void testeIntegracaoAtualizacaoQuantidadeNoEstoque() {
        // Configurar o comportamento do mock para a classe Produto
        when(produtoMock.getNome()).thenReturn("ProdutoMock");
        when(produtoMock.getQuantidade()).thenReturn(10);

        // Adicionar o produto mock ao estoque
        estoque.adicionarProduto(produtoMock);

        // Atualizar a quantidade no estoque
        estoque.atualizarQuantidade("ProdutoMock", 20);

        // Verificar a nova quantidade no estoque
        assertEquals(10, estoque.obterQuantidadeEmEstoque("ProdutoMock"));
    }

    @Test
    public void testeIntegracaoRemocaoDeProdutoDoEstoque() {
        // Configurar o comportamento do mock para a classe Produto
        when(produtoMock.getNome()).thenReturn("ProdutoMock");
        when(produtoMock.getQuantidade()).thenReturn(15);

        // Adicionar o produto mock ao estoque
        estoque.adicionarProduto(produtoMock);

        // Remover o produto mock do estoque
        estoque.removerProduto("ProdutoMock");

        // Verificar se o produto foi removido do estoque
        assertEquals(0, estoque.obterQuantidadeEmEstoque("ProdutoMock"));
    }

    @Test
    public void testeAdicaoDeProdutoAoEstoque() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Produto1", 10);
        estoque.adicionarProduto(produto);
        assertEquals(10, estoque.obterQuantidadeEmEstoque("Produto1"));
    }

    @Test
    public void testeObtencaoDeQuantidadeEmEstoque() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Produto2", 5);
        estoque.adicionarProduto(produto);
        assertEquals(5, estoque.obterQuantidadeEmEstoque("Produto2"));
    }

    @Test
    public void testeAtualizacaoQuantidadeNoEstoque() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Produto3", 15);
        estoque.adicionarProduto(produto);
        estoque.atualizarQuantidade("Produto3", 25);
        assertEquals(25, estoque.obterQuantidadeEmEstoque("Produto3"));
    }

    @Test
    public void testeAbaixoDoEstoqueMinimo() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Produto4", 5);
        estoque.adicionarProduto(produto);
        assertTrue(estoque.abaixoDoEstoqueMinimo("Produto4", 10));
    }

    @Test
    public void testeRemocaoDeProduto() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Produto5", 10);
        estoque.adicionarProduto(produto);
        estoque.removerProduto("Produto5");
        assertEquals(0, estoque.obterQuantidadeEmEstoque("Produto5"));
    }

    @Test
    public void testeConsultaDeProdutoPorNome() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Produto6", 20);
        estoque.adicionarProduto(produto);
        Produto produtoConsultado = estoque.consultarProdutoPorNome("Produto6");
        assertEquals("Produto6", produtoConsultado.getNome());
        assertEquals(20, produtoConsultado.getQuantidade());
    }

    @Test
    public void testeReabastecimentoDeEstoque() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Produto7", 10);
        estoque.adicionarProduto(produto);
        estoque.reabastecerEstoque("Produto7", 20);
        assertEquals(30, estoque.obterQuantidadeEmEstoque("Produto7"));
    }

    @Test
    public void testeRegistroDeMovimentacaoDeEstoque() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Produto8", 30);
        estoque.adicionarProduto(produto);
        estoque.registrarEntrada("Produto8", 5);
        assertEquals(35, estoque.obterQuantidadeEmEstoque("Produto8"));
        estoque.registrarSaida("Produto8", 10);
        assertEquals(25, estoque.obterQuantidadeEmEstoque("Produto8"));
    }

}