package ebruyurtdas.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
    private int categoryId;

    @NotNull(message = "Category Name is required.")
    @Min(value = 3, message = "Category Name must consist of at least 3 characters.")
	@Column(name="category_name")
    private String categoryName;

    @NotNull
    @Size(min=2,message = "is required.")
    @Column(name="decription")
    private String description;
    
    private Collection<Product> products;  // collection navigation property

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
	@Override
	public String toString() {
		return "Category [id=" + categoryId + ", Category Name=" + categoryName + ", Description=" + description + ", products=" + products
				+ "]";
	}
}

