package asia.fourtitude.productrestapi.controllers;

import asia.fourtitude.productrestapi.model.ProductDTO;
import asia.fourtitude.productrestapi.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping(value = ProductController.BASE_URL)
@Tag(name = "products", description = "the products API")
public class ProductController {

    public static final String BASE_URL = "/api/products";

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(summary = "productList",
                description = "Get the list of products. (by pagination)"
    )
    public ResponseEntity<List<ProductDTO>> getListofProductsByPagination(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "code") String sortBy
    ){
        List<ProductDTO> list = productService.getAllProducts(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<ProductDTO>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping({"/{code}"})
    @Operation(summary = "productItem",
            description = "Get one product by code.")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProductByCode(@PathVariable String code){
        return productService.getProductByCode(code);
    }


    @PostMapping
    @Operation(summary = "createProduct",
            description = "Create a new product.")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createNewProduct(@RequestBody ProductDTO product){
        return productService.createNewProducts(product);
    }

    @PutMapping({"/{code}"})
    @Operation(summary = "updateProduct",
            description = "Update an existing product.")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateCustomer(@PathVariable String code, @RequestBody ProductDTO product){
        return productService.updateProduct(code, product);
    }

    @DeleteMapping({"/{code}"})
    @Operation(summary = "deleteProduct",
            description = "Delete existing product by code.")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable String code){
        productService.deleteProduct(code);
    }

}
