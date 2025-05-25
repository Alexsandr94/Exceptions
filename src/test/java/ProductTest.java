import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testConstructor() {
        // Arrange & Act
        Product product = new Product(1, "Телевизор", 50_000);

        // Assert
        Product[] actual = {product};
        Product[] expected = {new Product(1, "Телевизор", 50_000)};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        Product product = new Product(2, "Холодильник", 80_000);

        // Act
        product.setTitle("Микроволновка");
        product.setPrice(15_000);

        // Assert
        Product[] actual = {product};
        Product[] expected = {new Product(2, "Микроволновка", 15_000)};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEquals_SameObject() {
        // Arrange
        Product product = new Product(3, "Пылесос", 20_000);

        // Act & Assert
        Product[] actual = {product};
        Product[] expected = {product};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEquals_DifferentObjectsWithSameFields() {
        // Arrange
        Product product1 = new Product(4, "Кофемолка", 5_000);
        Product product2 = new Product(4, "Кофемолка", 5_000);

        // Act & Assert
        Product[] actual = {product1};
        Product[] expected = {product2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEquals_DifferentObjectsWithDifferentFields() {
        // Arrange
        Product product1 = new Product(5, "Чайник", 3_000);
        Product product2 = new Product(6, "Чайник", 3_000);

        // Act & Assert
        assertFalse(product1.equals(product2), "Объекты с разными id не должны быть равны");
    }

    @Test
    public void testEquals_NullObject() {
        // Arrange
        Product product = new Product(7, "Утюг", 7_000);

        // Act & Assert
        assertFalse(product.equals(null), "Объект не должен быть равен null");
    }

    @Test
    public void testEquals_DifferentClass() {
        // Arrange
        Product product = new Product(8, "Фен", 4_000);
        String notAProduct = "Not a Product";

        // Act & Assert
        assertFalse(product.equals(notAProduct), "Объект не должен быть равен объекту другого класса");
    }

    @Test
    public void testHashCode_EqualObjects() {
        // Arrange
        Product product1 = new Product(9, "Блендер", 10_000);
        Product product2 = new Product(9, "Блендер", 10_000);

        // Act & Assert
        assertEquals(product1.hashCode(), product2.hashCode(), "Хэш-коды равных объектов должны совпадать");
    }

    @Test
    public void testHashCode_DifferentObjects() {
        // Arrange
        Product product1 = new Product(10, "Миксер", 8_000);
        Product product2 = new Product(11, "Миксер", 8_000);

        // Act & Assert
        assertNotEquals(product1.hashCode(), product2.hashCode(), "Хэш-коды разных объектов должны быть разными");
    }

    @Test
    public void testGetTitle() {
        // Arrange
        Product product = new Product(20, "Телевизор", 50_000);

        // Act
        String actual = product.getTitle();

        // Assert
        assertEquals("Телевизор", actual);
    }

    @Test
    public void testGetPrice() {
        // Arrange
        Product product = new Product(21, "Холодильник", 80_000);

        // Act
        int actual = product.getPrice();

        // Assert
        assertEquals(80_000, actual);
    }

    @Test
    public void testEquals_DifferentId() {
        // Arrange
        Product product1 = new Product(22, "Чайник", 3_000);
        Product product2 = new Product(23, "Чайник", 3_000);

        // Act & Assert
        assertFalse(product1.equals(product2));
    }

    @Test
    public void testEquals_DifferentTitle() {
        // Arrange
        Product product1 = new Product(24, "Кофемолка", 5_000);
        Product product2 = new Product(24, "Кофемашинка", 5_000);

        // Act & Assert
        assertFalse(product1.equals(product2));
    }

    @Test
    public void testEquals_DifferentPrice() {
        // Arrange
        Product product1 = new Product(25, "Кофемолка", 5_000);
        Product product2 = new Product(25, "Кофемолка", 6_000);

        // Act & Assert
        assertFalse(product1.equals(product2));
    }
}