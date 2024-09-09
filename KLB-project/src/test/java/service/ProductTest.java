package service;

import com.KLBproject.KLB_project.model.Product;
import com.KLBproject.KLB_project.repository.ProductRepository;
import com.KLBproject.KLB_project.service.Product.IProductService;
import com.KLBproject.KLB_project.service.Product.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
    }

    @Test
    public void testGetAllProducts() {
        List<Product> mockProducts = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mockProducts.add(product);
        }

        // Thiết lập hành vi cho mock
        when(productRepository.findAll()).thenReturn(mockProducts);

        // Gọi phương thức của lớp cần test
        List<Product> products = productService.getAllProducts();

        // Kiểm tra kích thước của danh sách
        assertThat(products.size()).isEqualTo(mockProducts.size());

        // Kiểm tra phương thức của mock đã được gọi
        verify(productRepository).findAll();
    }
}
