
package campusconnect;

// JpaRepository = Java Persistence API Repository.
// It provides ready-made methods to save, retrieve,
// update and delete database records.
import org.springframework.data.jpa.repository.JpaRepository;

// List is used to store multiple Item objects.
import java.util.List;

// This interface connects the Item class with the database.
// Item is the entity class and Long is the ID data type.
public interface ItemRepository extends JpaRepository<Item, Long> {

    // Finds items whose names contain the given text.
    // IgnoreCase means uppercase and lowercase are treated equally.
    List<Item> findByItemNameContainingIgnoreCase(String itemName);
}
