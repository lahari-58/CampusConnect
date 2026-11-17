
package campusconnect;

// JPA = Java Persistence API.
// It provides annotations that help Java classes
// connect with database tables.
import jakarta.persistence.*;

// LocalDate is a Java class used to store dates
// without storing the time.
import java.time.LocalDate;

// @Entity tells JPA that this Java class represents
// a table in the database.
@Entity
public class Item {

    // @Id means Identifier.
    // It marks this variable as the primary key.
    // A primary key uniquely identifies each record.
    @Id

    // @GeneratedValue automatically generates a unique ID
    // whenever a new item is saved.
    // IDENTITY means the database generates the ID.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Stores the name of the lost or found item.
    private String itemName;

    // Stores the category of the item.
    // Example: Electronics, Books, ID Card.
    private String category;

    // Stores additional information about the item.
    // @Column is used to configure a database column.
    // length = 1000 allows up to 1000 characters.
    @Column(length = 1000)
    private String description;

    // Stores the location where the item was lost or found.
    private String location;

    // Stores the date when the item was lost or discovered.
    private LocalDate itemDate;

    // Stores the contact details of the person reporting the item.
    private String contact;

    // Stores whether the report is Lost or Found.
    private String reportType;

    // Stores whether the item has been returned.
    // Initially, the value is false.
    private boolean returned = false;

    // Default constructor.
    // JPA uses this constructor to create Item objects.
    public Item() {
    }

    // Getter method to retrieve the item ID.
    public Long getId() {
        return id;
    }

    // Getter method to retrieve the item name.
    public String getItemName() {
        return itemName;
    }

    // Setter method to assign the item name.
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter method to retrieve the category.
    public String getCategory() {
        return category;
    }

    // Setter method to assign the category.
    public void setCategory(String category) {
        this.category = category;
    }

    // Getter method to retrieve the description.
    public String getDescription() {
        return description;
    }

    // Setter method to assign the description.
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter method to retrieve the location.
    public String getLocation() {
        return location;
    }

    // Setter method to assign the location.
    public void setLocation(String location) {
        this.location = location;
    }

    // Getter method to retrieve the item date.
    public LocalDate getItemDate() {
        return itemDate;
    }

    // Setter method to assign the item date.
    public void setItemDate(LocalDate itemDate) {
        this.itemDate = itemDate;
    }

    // Getter method to retrieve contact details.
    public String getContact() {
        return contact;
    }

    // Setter method to assign contact details.
    public void setContact(String contact) {
        this.contact = contact;
    }

    // Getter method to retrieve the report type.
    public String getReportType() {
        return reportType;
    }

    // Setter method to assign the report type.
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    // Getter method to check whether the item is returned.
    // isReturned() is used because the variable is boolean.
    public boolean isReturned() {
        return returned;
    }

    // Setter method to update the returned status.
    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
