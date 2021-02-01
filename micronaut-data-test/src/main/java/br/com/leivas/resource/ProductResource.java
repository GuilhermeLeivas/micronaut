package br.com.leivas.resource;

import br.com.leivas.model.Product;
import br.com.leivas.repository.ProductRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller("/products")
public class ProductResource {

    @Inject
    private ProductRepository productRepository;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<Iterable<Product>> getProducts() {
        return HttpResponse.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<Product> getProductById(@PathVariable Integer id) {
        return HttpResponse.status(HttpStatus.OK).body(productRepository.findById(id).get());
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<Product> createProduct(@Body @Valid Product product) {
        return HttpResponse.status(HttpStatus.CREATED).body(productRepository.save(product));
    }

    @Delete("/{id}")
    public HttpResponse<?> deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
        return HttpResponse.noContent();
    }

}
