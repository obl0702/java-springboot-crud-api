package com.ongbl.productrestapi.services;

import com.ongbl.productrestapi.entity.Product;
import com.ongbl.productrestapi.mapper.ProductMapper;
import com.ongbl.productrestapi.model.ProductDTO;
import com.ongbl.productrestapi.repositories.ItemRepository;
import com.ongbl.productrestapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;


    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository, ItemRepository itemRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
        this.itemRepository = itemRepository;
    }

    public List<ProductDTO> getAllProducts(Integer pageNo, Integer pageSize, String sortBy){

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        return productRepository.findAll(paging)
                .stream()
                .map(product -> {
                    ProductDTO productDTO = productMapper.productToProductDTO(product);
                    return productDTO;
                })
                .collect(Collectors.toList());
    }


    public ProductDTO getProductByCode(String code){

        return productRepository.getProductByCode(code)
                .map(productMapper::productToProductDTO)
                .orElseThrow(RuntimeException::new);
    }

    public ProductDTO createNewProducts(ProductDTO productDTO){
        return saveAndReturnDTO(productMapper.productDtoToProduct(productDTO));
    }

    private ProductDTO saveAndReturnDTO(Product product) {
        Product savedProduct = productRepository.save(product);
        ProductDTO returnDto = productMapper.productToProductDTO(savedProduct);

        return returnDto;
    }

    public ProductDTO updateProduct(String code, ProductDTO productDTO) {
        return productRepository.getProductByCode(code).map(product -> {

            if(productDTO.getCode() != null){
                product.setCode(productDTO.getCode());
            }
            if(productDTO.getName() != null){
                product.setName(productDTO.getName());
            }
            if(productDTO.getCategory() != null){
                product.setCategory(productDTO.getCategory());
            }
            if(productDTO.getBrand() != null){
                product.setBrand(productDTO.getBrand());
            }
            if(productDTO.getType() != null){
                product.setType(productDTO.getType());
            }
            if(productDTO.getDescription() != null){
                product.setDescription(productDTO.getDescription());
            }

            ProductDTO returnDto = productMapper.productToProductDTO(productRepository.save(product));
            return returnDto;

        }).orElseThrow(RuntimeException::new);
    }

    public void deleteProduct(String code){
        ProductDTO productDTO = getProductByCode(code);

        productRepository.getProductByCode(code).map(product -> {

            if(productDTO.getCode() != null){
                product.setCode(productDTO.getCode());
            }
            if(productDTO.getName() != null){
                product.setName(productDTO.getName());
            }
            if(productDTO.getCategory() != null){
                product.setCategory(productDTO.getCategory());
            }
            if(productDTO.getBrand() != null){
                product.setBrand(productDTO.getBrand());
            }
            if(productDTO.getType() != null){
                product.setType(productDTO.getType());
            }
            if(productDTO.getDescription() != null){
                product.setDescription(productDTO.getDescription());
            }

            productRepository.delete(product);
            return product;
        }).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void updateItems(List<Long> id){
        String status = "Annulled";
        itemRepository.updateItemsByIdIn(status, id);
    }

}
