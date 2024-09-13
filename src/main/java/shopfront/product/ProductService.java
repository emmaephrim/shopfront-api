package shopfront.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
        private final ProductRepository productRepository;

        ProductService(ProductRepository productRepository) {
                this.productRepository = productRepository;
        }

        public void addProduct(Product product) {
                productRepository.save(product);
        }

        public List<Product> getAllProducts() {
                return productRepository.findAll();
        }

        public List<Product> getProductsByCategory(String category) {
                List<Product> productsByCategory = new ArrayList<>();
                List<Product> allProducts = productRepository.findAll();
                for (Product product : allProducts) {
                        if (product.getCategory().equals(category)) {
                                productsByCategory.add(product);
                        }
                }
                return productsByCategory;
        }

        public void deleteProduct(String id) {
                productRepository.deleteById(id);
        }

        public void deleteAllProducts() {
                productRepository.deleteAll();
        }

        public Product getProductById(String id) {
                return productRepository.findById(id).orElse(null);
        }

        public Product updateProduct(String id, Product product) {
                Product existingProduct = productRepository.findById(id).orElse(null);
                if (existingProduct == null) {
                        return null;
                }
                existingProduct.setName(product.getName());
                existingProduct.setDescription(product.getDescription());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setCategory(product.getCategory());
                existingProduct.setImageUrl(product.getImageUrl());
                // existingProduct.setStock(product.getStock());
                // existingProduct.setBrand(product.getBrand());
                // existingProduct.setColor(product.getColor());
                // existingProduct.setSize(product.getSize());
                // existingProduct.setWeight(product.getWeight());
                // existingProduct.setMaterial(product.getMaterial());
                return productRepository.save(existingProduct);
        }

        public List<Product> initialProducts() {
                // clothing, furniture, electronics, books

                List<Product> PRODUCTS = List.of(
                                new Product("Oversized T Shirts Graphic",
                                                "Aesthetic Graphic Tee: Made of cotton, blend fabric, super soft and good shape. Pull on closure. Vibrant and durable to use",
                                                "clothing",
                                                "https://m.media-amazon.com/images/I/61UgZ2G5JhL._AC_SX522_.jpg", 54.5),
                                new Product("Dokotoo Women Color Block",
                                                "Material: Dokotoo women's elastic knit striped T shirts, Crafted from ultra-soft, skin-friendly fabric that resists pilling for lasting comfort.",
                                                "clothing",
                                                "https://m.media-amazon.com/images/I/71ojUAIkEtL._AC_SY500_.jpg", 95.5),
                                new Product("Long Sleeve Henley T Shirts",
                                                "COMFY FABRIC: S=US 4-6，M=US 8-10，L=US 12-14，XL=US 16-18，XXL=US 20 Made from Soft Materials, Women’s Henley T-Shirt Feels Gentle and Comfortable against Your Skin, Providing A Cozy Experience",
                                                "clothing",
                                                "https://m.media-amazon.com/images/I/81Hr-JLtyrL._AC_SX425_.jpg",
                                                100.0),
                                new Product("Vintage Shirts for Women",
                                                "95% Polyester,5% Spandex.Skin-Friendly Material.It's Stretchable, Soft and Lightweight, Provide You a Pleasing Wearing Experience.",
                                                "clothing",
                                                "https://m.media-amazon.com/images/I/614e9N6xIKL._AC_SX522_.jpg", 95.5),
                                new Product("AUTOMET Womens Zip Up Hoodies",
                                                "Material: 50%polyester 50%cotton,lightweight, breathable,super soft and fuzzy fleece lined material,suit for fall and winter, keep you warm all day.",
                                                "clothing",
                                                "https://m.media-amazon.com/images/I/71OYYkapeDL._AC_SY500_.jpg", 780),
                                new Product("Gildan Men's Crew T-Shirts",
                                                "Moisture wicking technology keeps you cool and dry",
                                                "clothing",
                                                "https://m.media-amazon.com/images/I/71p-Sidcu8S._AC_SX522_.jpg", 60),
                                new Product("AUTOMET Jumpsuits for Women",
                                                "Made of 94% soft, comfortable cotton and 6% spandex for stretch and breathability",
                                                "clothing",
                                                "https://m.media-amazon.com/images/I/51-B-laB-2L._AC_SY500_.jpg", 450),
                                new Product("QINSEN Women's Square Neck Sleeveless",
                                                "Exceptionally Soft and Stretchy Fabric: Offer yourself the luxury of supreme comfort with our QINSEN sleeveless square-neck top.",
                                                "clothing",
                                                "https://m.media-amazon.com/images/I/614ysPx+URL._AC_SY500_.jpg", 110),
                                new Product("Summer Palazzo Pants Flowy Wide",
                                                "So slouchy and soft from our summer collection, these linen-blend pants feature an elastic waistband and adjustable drawstring with wide-legs",
                                                "clothing",
                                                "https://m.media-amazon.com/images/I/71dQYAjoG9L.__AC_SY445_SX342_QL70_FMwebp_.jpg",
                                                300),
                                new Product("LILLUSORY Women's Linen Summer Palazzo Pants",
                                                "So slouchy and soft from our summer collection, these linen-blend pants feature an elastic waistband and adjustable drawstring with wide-legs",
                                                "clothing",
                                                "https://m.media-amazon.com/images/I/61PGlUsum4L._AC_SY500_.jpg", 290),

                                new Product("VASAGLE Shoe Bench with Cushion",
                                                "[Everything in Order] End entryway messes with this shoe bench. It has 9 compartments that comfortably hold 9 pairs of shoes",
                                                "furniture",
                                                "https://m.media-amazon.com/images/I/81Lb9RvIRUL._AC_SX569_.jpg",
                                                40.30),
                                new Product("6 Shelf Retro Floor Standing Bookcase,",
                                                "We provide 1 year after-sales service for this book shelf organizer. If you have any questions and suggestions about",
                                                "furniture",
                                                "https://m.media-amazon.com/images/I/61pfi70XekL._AC_SL1500_.jpg",
                                                87.0),
                                new Product("MAXYOYO Folding Sofa Bed,",
                                                "Versatile Folding Sofa Bed: The folding sofa bed serves as both a comfortable sofa and a convenient bed, making it ideal for small living spaces or guest rooms. Foldable design saves your space.",
                                                "furniture",
                                                "https://m.media-amazon.com/images/I/81YNMADGQCL._AC_SL1500_.jpg",
                                                65.8),
                                new Product("SONGMICS 30 Inches Folding Storage Ottoman Bench",
                                                "[Easy to Set Up & Fold Away] With its unique folding design, this storage bench can be set up in just a few seconds. It conveniently folds flat for easy storage when not in use, saving space in your home",
                                                "furniture",
                                                "https://m.media-amazon.com/images/I/81yAea765YL._AC_SL1500_.jpg", 70),
                                new Product("HOOBRO End Tables Set of 2 with Charging Station",
                                                "Side Table with Outlets and USB Ports: The charging station includes 2 3-prong AC outlets and 2 USB ports, meeting your needs to charge your phone",
                                                "furniture",
                                                "https://m.media-amazon.com/images/I/71wY3U6LHbL._AC_SL1500_.jpg",
                                                32.0),
                                new Product("Furnulem Tall Nightstand with 4 Drawers ",
                                                " The 4 spacious fabric drawers provide ample storage space for your personal items organized, allowing you to keep your essentials organized.",
                                                "furniture",
                                                "https://m.media-amazon.com/images/I/71DOKFBzOYL._AC_SL1500_.jpg",
                                                21.80),

                                new Product("SAMSUNG 990 PRO SSD 4TB PCIe 4.0 M.2 2280",
                                                "MEET THE NEXT GEN: Consider this a cheat code; Our Samsung 990 PRO Gen4 SSD helps you reach near max performance* with lightning-fast speeds; Whether you’re a",
                                                "electronics",
                                                "https://m.media-amazon.com/images/I/81WuG6lQuDL._AC_SL1500_.jpg", 430),
                                new Product("Projector with WiFi and Bluetooth,",
                                                "[Convenient WiFi Connection] Connecting deivces with our wifi projector through wifi. We have TWO things to make it friendly user: (1) Updated the wifi connection steps,",
                                                "electronics",
                                                "https://m.media-amazon.com/images/I/71bPcqUviTL._AC_SL1000_.jpg", 620),
                                new Product("9\" Portable Carplay & Android Auto Touch Screen,",
                                                "Wireless Carplay & Android Auto - Portable Car Stereo technologies provide drivers with a seamless, connected experience like never before. With a simple Bluetooth and WiFi setup, your smartphone can automatically connect wirelessly to the car radio touchscreen when you step into the car, and be easily controlled via the car's touchscreen without any data cables.",
                                                "electronics",
                                                "https://m.media-amazon.com/images/I/7140OczUpBL._AC_SL1500_.jpg", 500),
                                new Product("Compressed Air Duster",
                                                "The air duster has a maximum speed of 100000 RPM motor with 3 different air speeds with button.You can have a deep cleaning，low energy consumption and low noise work on the different equipment while retaining powerful airflow.",
                                                "electronics",
                                                "https://m.media-amazon.com/images/I/719F4I7zVYL._AC_SL1500_.jpg", 230),
                                new Product("Massage Gun, Muscle Massage Gun for Athletes",
                                                "Beat soreness, back pain, and stress: For those who don't want muscle soreness to slow them down, our muscle massage gun deeply penetrates to help you cope with everyday stresses",
                                                "electronics",
                                                "https://m.media-amazon.com/images/I/712UHB03CbL._AC_SL1500_.jpg", 210),
                                new Product("Mini Projector, VISSPL Full HD 1080P Video Projector",
                                                "The VISSPL 2024 projector supports 1080P resolution for stunning visuals. Powered by advanced LED technology and a uniform illumination method, our projector guarantees exceptional image quality, ",
                                                "electronics",
                                                "https://m.media-amazon.com/images/I/61kRNDZh8UL._AC_SL1500_.jpg", 78),

                                new Product("Rich Dad Poor Dad",
                                                "April of 2022 marks a 25-year milestone for the personal finance classic Rich Dad Poor Dad that still ranks as the #1 Personal Finance book of all time. And although 25 years have passed since Rich Dad Poor Dad was first published, readers will find that very little in the book itself has changed",
                                                "books", "https://m.media-amazon.com/images/I/81BE7eeKzAL._SL1500_.jpg",
                                                45),
                                new Product("Atomic Habits",
                                                "No matter your goals, Atomic Habits offers a proven framework for improving - every day. James Clear, one of the world's leading experts on habit formation, reveals practical strategies that will teach you exactly how to form good habits, break bad ones, and master the tiny behaviors that lead to remarkable results",
                                                "books", "https://m.media-amazon.com/images/I/71F4+7rk2eL._SL1500_.jpg",
                                                90),
                                new Product("Good Energy",
                                                "What if depression, anxiety, infertility, insomnia, heart disease, erectile dysfunction, type 2 diabetes, Alzheimer’s, dementia, cancer and many other health conditions that torture and shorten our lives actually have the same root cause?",
                                                "books", "https://m.media-amazon.com/images/I/71KTwO53SnL._SL1500_.jpg",
                                                21),
                                new Product("Onyx Storm (Deluxe Limited Edition) (The Empyrean, 3)",
                                                "sprayed edges with stenciled artwork, as well as exclusive special design features. This incredible collectible is only available for a limited time, a must-have for any book lover while supplies last in the US and Canada only.",
                                                "books", "https://m.media-amazon.com/images/I/9101MLPcFTL._SL1500_.jpg",
                                                88),
                                new Product("It Starts with Us: A Novel",
                                                "Lily and her ex-husband, Ryle, have just settled into a civil coparenting rhythm when she suddenly bumps into her first love, Atlas, again. After nearly two years separated, she is elated that for once, time is on their side, and she immediately says yes when Atlas asks her on a date.",
                                                "books", "https://m.media-amazon.com/images/I/81ZEMiQ6B9L._SL1500_.jpg",
                                                99),
                                new Product("The Women: A Novel",
                                                "\"Kristin Hannah’s potent storytelling skills are brilliantly served by narrator Julia Whelan, whose limber, low-pitched voice moves nimbly from person to person, capturing personality and mood, her empathy palpable.\"—The Washington Post",
                                                "books", "https://m.media-amazon.com/images/I/91I78fRFUTL._SL1500_.jpg",
                                                45)

                );

                List<Product> initialProducts = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                        Product product = new Product();
                        product.setName("Product " + (i + 1));
                        product.setDescription("Description of Product " + (i + 1));
                        product.setPrice(10.0);
                        product.setCategory("Category " + (i + 10));
                        product.setImageUrl("https://picsum.photos/id/" + (i + 1) + "/500");
                        // product.setStock(100);
                        // product.setBrand("Brand " + (i + 1));
                        // product.setColor("Color " + (i + 1));
                        // product.setSize("Size " + (i + 1));
                        // product.setWeight("1.0kg");
                        // product.setMaterial("Material " + (i + 1));
                        initialProducts.add(product);
                }
                // return initialProducts;

                return PRODUCTS;
        }

}
