package asia.fourtitude.productrestapi.mapper;

import asia.fourtitude.productrestapi.entity.Product;
import asia.fourtitude.productrestapi.model.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements  ProductMapper{

    @Override
    public ProductDTO productToProductDTO(Product product) {

        if(product == null){
            return null;
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode(product.getCode());
        productDTO.setName(product.getName());
        productDTO.setCategory(product.getCategory());
        productDTO.setBrand(product.getBrand());
        productDTO.setType(product.getType());
        productDTO.setDescription(product.getDescription());

        return productDTO;
    }

    @Override
    public Product productDtoToProduct(ProductDTO productDTO) {

        if(productDTO == null){
            return null;
        }

        Product product = new Product();
        product.setCode(productDTO.getCode());
        product.setName(productDTO.getName());
        product.setCategory(productDTO.getCategory());
        product.setBrand(productDTO.getBrand());
        product.setType(productDTO.getType());
        product.setDescription(productDTO.getDescription());

        return product;
    }
}
