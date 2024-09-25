package com.example.productservice.adapters.driving;

import com.example.productservice.application.ports.ProductDTO;
import com.example.productservice.application.service.ProductService;
import com.example.productservice.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Mapper Method to convert Product to ProductDTO
    private ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setBasePrice(product.getBasePrice());
        return dto;
    }

    // Mapper Method to convert ProductDTO to Product
    private Product mapToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setBasePrice(dto.getBasePrice());
        return product;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        // Convert Product List to ProductDTO List
        return productService.getAllProducts().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<ProductDTO> getProductById(@PathVariable String id) {
        // Convert Optional<Product> to Optional<ProductDTO>
        return productService.getProductById(id)
                .map(this::mapToDTO);
    }

    @PostMapping
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO, @RequestHeader("Region") String region) {
        // Convert DTO to Entity, then back to DTO after saving
        Product product = mapToEntity(productDTO);
        Product savedProduct = productService.createOrUpdateProduct(product, region);
        return mapToDTO(savedProduct);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable String id, @Valid @RequestBody ProductDTO productDTO, @RequestHeader("Region") String region) {
        productDTO.setId(id); // Set the ID in the DTO
        Product product = mapToEntity(productDTO); // Convert DTO to Entity
        Product updatedProduct = productService.createOrUpdateProduct(product, region);
        return mapToDTO(updatedProduct); // Convert back to DTO
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/search")
    public List<ProductDTO> getProductsByName(@RequestParam String name) {
        return productService.getProductsByName(name).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/price-range")
    public List<ProductDTO> getProductsByPriceRange(@RequestParam int minPrice, @RequestParam int maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
