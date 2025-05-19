import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testEqualsSameObject() {
        Product product = new Product(1, "Телевизор", 50_000);
        Product[] actual = {product};
        Product[] expected = {product};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEqualsSameValues() {
        Product product1 = new Product(1, "Телевизор", 50_000);
        Product product2 = new Product(1, "Телевизор", 50_000);
        Product[] actual = {product1};
        Product[] expected = {product2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHashCodeConsistency() {
        Product product = new Product(1, "Телевизор", 50_000);
        int hash1 = product.hashCode();
        int hash2 = product.hashCode();
        int[] actual = {hash1};
        int[] expected = {hash2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHashCodeSameValues() {
        Product product1 = new Product(1, "Телевизор", 50_000);
        Product product2 = new Product(1, "Телевизор", 50_000);
        int[] actual = {product1.hashCode()};
        int[] expected = {product2.hashCode()};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetters() {
        Product product = new Product(1, "Телевизор", 50_000);
        Object[] actual = {product.getId(), product.getTitle(), product.getPrice()};
        Object[] expected = {1, "Телевизор", 50_000};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSetters() {
        Product product = new Product(1, "Телевизор", 50_000);
        product.setTitle("Холодильник");
        product.setPrice(60_000);
        Object[] actual = {product.getTitle(), product.getPrice()};
        Object[] expected = {"Холодильник", 60_000};
        assertArrayEquals(expected, actual);
    }
}