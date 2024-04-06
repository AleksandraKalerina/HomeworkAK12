package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product item1 = new Product(1, "Хлеб", 50);
    Product item2 = new Product(2, "Яйца", 100);
    Product item3 = new Product(3, "Молоко", 70);

    @Test
    public void removeTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.remove(item2.getId());

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFoundExceptionTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(-100);
        });
    }

    @Test
    public void test() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        int price = repo.findById(2).price;
        int expected = 100;

        Assertions.assertEquals(expected, price);
    }

    @Test
    public void setTitleItem2() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.findById(2).setTitle("Мясо");
        String expected = "Мясо";
        String actual = repo.findById(2).getTitle();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void setPriceItem3() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.findById(3).setPrice(90);
        int expected = 90;
        int actual = repo.findById(3).getPrice();
        Assertions.assertEquals(expected, actual);
    }
}
