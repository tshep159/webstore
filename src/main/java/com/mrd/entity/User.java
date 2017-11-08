package com.mrd.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.json.JSONArray;
import org.json.JSONObject;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "Users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3339066954014697122L;
	/*
	 * private fields for user
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	@Column(name = "first_name")
	@NotBlank(message = "Please enter first name")
	private String firstName;
	@Column(name = "last_name")
	@NotBlank(message = "Please enter last name")
	private String lastName;
	@NotBlank(message = "Please enter email")
	private String email;
	@NotBlank(message = "Please enter contact number")
	private String contactNumber;
	public String role;
	private String password;
        @Column(name="image", length=510000)
        private String image;
	
       @Column(name="discription")
        private String disc;
        @Column(name="street")
        private String street;
        @Column(name="town")
        private String town;
	private boolean enabled;

//@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//private OrderDetails orderDetails;
        @OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private Set <Product> product;
//  @OneToMany()
// private Payments payments;

    public User() {
    }

    public User(int user_id, String firstName, String lastName, String email, String contactNumber, String role, String password, String image, String disc, String street, String town, boolean enabled, Set<Product> product) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.role = role;
        this.password = password;
        this.image = image;
        this.disc = disc;
        this.street = street;
        this.town = town;
        this.enabled = enabled=true;
        this.product = product;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    
    
    
    
 public String toString(){
    	String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("firstName",this.firstName);
        
        JSONArray productArray = new JSONArray();
        if(this.product != null){
            this.product.forEach(product->{
                JSONObject subJson = new JSONObject();
                subJson.put("firstName", product.getName());
                productArray.put(subJson);
            });
        }
        jsonInfo.put("product", productArray);
        info = jsonInfo.toString();
        return info;
    }
}
