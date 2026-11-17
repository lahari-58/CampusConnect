
package campusconnect;

// Model carries data from Java to HTML pages.
import org.springframework.ui.Model;

// Controller annotation handles web requests.
import org.springframework.stereotype.Controller;

// GetMapping handles requests that display pages or data.
import org.springframework.web.bind.annotation.GetMapping;

// PostMapping handles form submissions.
import org.springframework.web.bind.annotation.PostMapping;

// RequestParam reads values sent through a URL or form.
import org.springframework.web.bind.annotation.RequestParam;

// PathVariable reads values from the URL path.
import org.springframework.web.bind.annotation.PathVariable;

// RedirectAttributes can send a message after redirecting.
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// Automatically connects this controller to ItemRepository.
import org.springframework.beans.factory.annotation.Autowired;

// Used for form submission data.
import org.springframework.web.bind.annotation.ModelAttribute;

// Used to work with multiple Item objects.
import java.util.List;

// @Controller tells Spring Boot that this class
// handles requests from the user's browser.
@Controller
public class HomeController {

    // Repository provides database operations for Item objects.
    private final ItemRepository itemRepository;

    // Constructor injection connects ItemRepository to this controller.
    public HomeController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Displays the homepage.
    // Model sends the item counts to the HTML page.
    @GetMapping("/")
    public String home(Model model) {

        // Count all items stored in the database.
        long totalItems = itemRepository.count();

        // Count reports marked as Lost.
        long lostItems = itemRepository.findAll().stream()
                .filter(item -> "LOST".equalsIgnoreCase(item.getReportType()))
                .count();

        // Count reports marked as Found.
        long foundItems = itemRepository.findAll().stream()
                .filter(item -> "FOUND".equalsIgnoreCase(item.getReportType()))
                .count();

        // Send these values to the homepage.
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("lostItems", lostItems);
        model.addAttribute("foundItems", foundItems);

        // Opens index.html from the templates folder.
        return "index";
    }

    // Opens the report form.
    // The type parameter decides whether it is Lost or Found.
    @GetMapping("/report")
    public String reportForm(@RequestParam(defaultValue = "LOST") String type,
                             Model model) {

        // Create an empty Item object for the form.
        Item item = new Item();

        // Set the report type selected by the user.
        item.setReportType(type.toUpperCase());

        // Send the Item object to the HTML form.
        model.addAttribute("item", item);

        // Opens report.html.
        return "report";
    }

    // Receives and saves the submitted report.
    @PostMapping("/save")
    public String saveItem(@ModelAttribute Item item) {

        // Save the item details in the database.
        itemRepository.save(item);

        // Redirect the user to the reports page.
        return "redirect:/items";
    }

    // Displays all lost and found reports.
    @GetMapping("/items")
    public String viewItems(Model model) {

        // Retrieve all items from the database.
        List<Item> items = itemRepository.findAll();

        // Send the list of items to the HTML page.
        model.addAttribute("items", items);

        // Opens items.html.
        return "items";
    }

    // Searches for items using their names.
    @GetMapping("/search")
    public String searchItems(@RequestParam String keyword, Model model) {

        // Find items whose names contain the search keyword.
        List<Item> items =
                itemRepository.findByItemNameContainingIgnoreCase(keyword);

        // Send search results and keyword to the HTML page.
        model.addAttribute("items", items);
        model.addAttribute("keyword", keyword);

        // Reuses the items.html page.
        return "items";
    }

    // Marks an item as returned using its ID from the URL.
    @PostMapping("/returned/{id}")
    public String markReturned(@PathVariable Long id) {

        // Find the item using its unique ID.
        Item item = itemRepository.findById(id).orElse(null);

        // Check whether the item exists.
        if (item != null) {

            // Update its returned status.
            item.setReturned(true);

            // Save the updated item in the database.
            itemRepository.save(item);
        }

        // Return to the reports page.
        return "redirect:/items";
    }
}
