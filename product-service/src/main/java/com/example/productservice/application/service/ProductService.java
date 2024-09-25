package com.example.productservice.application.service;

import com.example.productservice.application.ports.InboundPort;
import com.example.productservice.application.ports.OutboundPort;
import com.example.productservice.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements InboundPort {

    @Autowired
    private OutboundPort productRepository;
    @Autowired
    private VatRateService vatRateService; // Inject VAT Rate Service



    // Pricing rules in cents (1€ = 100 cents)
    private static final int MINIMUM_PRICE_CENTS = 500; // 5€
    private static final int HIGH_PRICE_THRESHOLD_CENTS = 10000; // 100€
    private static final int MID_PRICE_THRESHOLD_CENTS = 5000; // 50€

    // Discount percentages
    private static final double HIGH_PRICE_DISCOUNT = 0.15; // 15% for expensive products
    private static final double MID_PRICE_DISCOUNT = 0.10;  // 10% for mid-range products
    private static final double LOW_PRICE_DISCOUNT = 0.05;  // 5% for cheaper products




    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }


    @Override
    public Product createOrUpdateProduct(Product product, String region) {
        calculateFinalPriceWithVAT(product, region);
        return productRepository.save(product);
    }


    @Override
    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }

    // Realistic Business Logic: Apply tiered discount based on price range
    private void applyRealisticDiscount(Product product) {
        int originalPrice = product.getFinalPrice();
        int discountedPrice = originalPrice;

        if (originalPrice > HIGH_PRICE_THRESHOLD_CENTS) {
            discountedPrice -= originalPrice * HIGH_PRICE_DISCOUNT;
        } else if (originalPrice > MID_PRICE_THRESHOLD_CENTS) {
            discountedPrice -= originalPrice * MID_PRICE_DISCOUNT;
        } else {
            discountedPrice -= originalPrice * LOW_PRICE_DISCOUNT;
        }

        // Ensure the discounted price doesn't fall below the minimum price
        if (discountedPrice < MINIMUM_PRICE_CENTS) {
            discountedPrice = MINIMUM_PRICE_CENTS;
        }

        product.setFinalPrice(discountedPrice);
    }



    private void calculateFinalPriceWithVAT(Product product, String region) {
        int basePriceCents = product.getBasePrice(); // Base price in cents
        double vatRate = vatRateService.getVatRate(region); // Get VAT rate based on region
        int vatAmountCents = (int) (basePriceCents * vatRate); // VAT amount in cents
        int finalPriceCents = basePriceCents + vatAmountCents;  // Final price including VAT

        product.setVatAmount(vatAmountCents);  // Store VAT amount in the product
        product.setFinalPrice(finalPriceCents); // Store the final price in the product

    }
    // New method to fetch products by name
    public List<Product> getProductsByName(String name) {
        // Call the repository or perform the logic to retrieve products by name
        // Assuming a repository is being used
        return productRepository.findByName(name);
    }

    // New method to fetch products by price range
    public List<Product> getProductsByPriceRange(int minPrice, int maxPrice) {
        // Call the repository to find products by price range
        return productRepository.findProductsByPriceRange(minPrice, maxPrice);
    }
}
