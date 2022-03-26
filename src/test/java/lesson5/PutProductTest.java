package lesson5;

import lesson5.api.ProductService;
import lesson5.dto.Product;
import lesson5.utils.RetrofitUtils;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class PutProductTest {
        static ProductService productService;
        Product product = null;
        Faker faker = new Faker();
        int id;

        @BeforeAll
        static void beforeAll() {
            productService = RetrofitUtils.getRetrofit()
                    .create(ProductService.class);
        }

        @BeforeEach
        void setUp() {
            product = new Product()
                    .withTitle(faker.food().ingredient())
                    .withCategoryTitle("Food")
                    .withPrice((int) (Math.random() * 10000));
        }

        @Test
        void putProductCategoryTest() throws IOException {
            Response<Product> response = productService.createProduct(product)
                    .execute();
            assert response.body() != null;
            System.out.println(response.body().getId());
            id =  response.body().getId();
            Response<Product> response2 = productService.modifyProduct(product.withCategoryTitle("Food"), product.withId(id)).execute();
            assertThat(response2.isSuccessful(), CoreMatchers.is(true));
        }

        @SneakyThrows
        @AfterEach
        void tearDown() {
            Response<ResponseBody> response = productService.deleteProduct(id).execute();
            assertThat(response.isSuccessful(), CoreMatchers.is(true));
        }
    }
