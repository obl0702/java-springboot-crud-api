package asia.fourtitude.productrestapi.model;

public class ProductDTO {

    private String code;
    private String name;
    private String category;
    private String brand;
    private String type;
    private String description;

    public ProductDTO(){

    };

    public ProductDTO(String code, String name, String category, String brand, String type, String description) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.type = type;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
