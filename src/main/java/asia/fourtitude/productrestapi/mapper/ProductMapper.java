package asia.fourtitude.productrestapi.mapper;

import asia.fourtitude.productrestapi.entity.Product;
import asia.fourtitude.productrestapi.model.ProductDTO;

public interface ProductMapper {

    ProductDTO productToProductDTO(Product product);

    Product productDtoToProduct(ProductDTO productDTO);

}
