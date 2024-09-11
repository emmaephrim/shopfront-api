package shopfront.product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // Product findByName(String name);
    // Product findByCategory(String category);
    // Product findByBrand(String brand);
    // Product findByColor(String color);
    // Product findBySize(String size);
    // Product findByWeight(String weight);
    // Product findByMaterial(String material);
    // Product findByPrice(double price);
    // Product findByStock(int stock);
    // Product findByImageUrl(String imageUrl);

}
