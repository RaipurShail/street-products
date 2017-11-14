package com.business.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productmaster")
public class ProductMaster {

	private static final long serialVersionUID = 453693552059515150L;
	private Long productId;
	private String productName;
	private String productCode;
	private Float price;
	private String manufacturer;
	private Integer availableStock;
	private Long categoryId;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;

	public ProductMaster(Long productId, String productName, String productCode, Float price, String manufacturer,
			Integer availableStock, Long categoryId, String createdDate, String createdBy, String modifiedDate,
			String modifiedBy) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.price = price;
		this.manufacturer = manufacturer;
		this.availableStock = availableStock;
		this.categoryId = categoryId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
	}

	public ProductMaster() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/*
	 * @ManyToMany(cascade = CascadeType.ALL) // Many Products belongs to one
	 * category //@JoinColumn(name = "category_id") public List<CategoryMaster>
	 * getCategoryMaster() { return categoryMaster; }
	 * 
	 * public void setCategoryMaster(List<CategoryMaster> categoryMaster) {
	 * this.categoryMaster = categoryMaster; }
	 */

	@Column(name = "product_name")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "product_code", unique = true)
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name = "price")
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "manufacturer")
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Column(name = "available_stock")
	public Integer getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(Integer availableStock) {
		this.availableStock = availableStock;
	}

	@Column(name = "category_id")
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "created_date")
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "modified_date")
	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "modified_by")
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * @ManyToOne(fetch = FetchType.LAZY ,optional=false) optional=false means
	 * this relationship becomes mandatory
	 * 
	 * @JoinColumn(name = "STOCK_ID", nullable = false) name = column name of
	 * the current table - foreign key
	 * 
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "AUTHOR_ID")
	 * 
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name =
	 * "STUDENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "COURSE_ID")
	 * })
	 *
	 * @Entity: is required for every model class.
	 * 
	 * @Table: maps the class with the corresponding database table. If omitted,
	 * Hibernate will use the class name.
	 * 
	 * @Column: maps the field with the corresponding table column. If omitted,
	 * Hibernate will infer the column name and type based on signatures of the
	 * getter/setter.
	 * 
	 * @Id and @GeneratedValue: are used in conjunction for a field that maps to
	 * the primary key. The values for this field are auto generated.
	 * 
	 * @Temporal: must be used with a java.util.Date field to specify the actual
	 * SQL type of the column.
	 * 
	 * @OneToOne and @JoinColumn: are used together to specify a one-to-one
	 * association and the join column.
	 * 
	 * @ManyToMany annotation is used to create the many-to-many relationship
	 * between two entities.
	 * 
	 * @JoinTable annotation is used to create the STUDENT_COURSE link table
	 * 
	 * @JoinColumn annotation is used to refer the linking columns in both the
	 * tables.
	 */
}