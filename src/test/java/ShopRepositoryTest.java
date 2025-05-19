import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testProductRepository() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Приставка", 60_000);
        Product product2 = new Product(2, "Ноутбук", 150_000);
        Product product3 = new Product(3, "Смартфон", 100_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(1);
        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testProductRepository2() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Приставка", 60_000);
        Product product2 = new Product(2, "Ноутбук", 150_000);
        Product product3 = new Product(3, "Смартфон", 100_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testProductRepository3() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Приставка", 60_000);
        Product product2 = new Product(2, "Ноутбук", 150_000);
        Product product3 = new Product(3, "Смартфон", 100_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotFound() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Приставка", 60_000);
        Product product2 = new Product(2, "Ноутбук", 150_000);
        Product product3 = new Product(3, "Смартфон", 100_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        assertThrows(NotFoundException.class, () -> repo.remove(10));
    }

    @Test
    public void testFindByIdWhenProductExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Приставка", 60_000);
        Product product2 = new Product(2, "Ноутбук", 150_000);

        repo.add(product1);
        repo.add(product2);

        Product foundProduct = repo.findById(2);
        assertEquals(product2, foundProduct);
    }

    @Test
    public void testFindByIdWhenProductDoesNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Приставка", 60_000);
        Product product2 = new Product(2, "Ноутбук", 150_000);

        repo.add(product1);
        repo.add(product2);

        Product foundProduct = repo.findById(3);
        assertNull(foundProduct);
    }

    @Test
    public void testAddProduct() {
        ShopRepository repo = new ShopRepository();
        Product product = new Product(1, "Приставка", 60_000);

        repo.add(product);

        Product[] actual = repo.findAll();
        Product[] expected = {product};
        assertArrayEquals(expected, actual);
    }
}