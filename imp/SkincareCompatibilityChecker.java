import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SkincareCompatibilityChecker {

    private List<SkincareProduct> skincareProducts;
    private Set<String> ingredientSet;
    private String benefitString;
    private String notCompString;

    public SkincareCompatibilityChecker(List<SkincareProduct> skincareProducts) {
        this.skincareProducts = skincareProducts;
        this.ingredientSet = new HashSet<>();
        this.benefitString = "";
        this.notCompString = "";
    }

    public boolean checkCompatibility() {
        buildIngredientSet();

        for (String ingredient : ingredientSet) {
            List<String> incompatibles = getIncompatibilities(ingredient);
            for (String incompatible : incompatibles) {
                if (ingredientSet.contains(incompatible)) {
                    notCompString = "Incompatibility found: " + ingredient + " and " + incompatible;
                    return false;
                }
            }
        }
        benefitString = "All ingredients are compatible.";
        return true;
    }

    private void buildIngredientSet() {
        for (SkincareProduct product : skincareProducts) {
            ingredientSet.addAll(product.getIngredients());
        }
    }

    private List<String> getIncompatibilities(String ingredient) {
        // Database query to retrieve a list of incompatible ingredients for the given ingredient
        // Return the list of incompatibles
        return new ArrayList<>(); // Placeholder return
    }

    // Getter methods for benefitString and notCompString
    public String getBenefitString() {
        return benefitString;
    }

    public String getNotCompString() {
        return notCompString;
    }
}

class SkincareProduct {
    // Assuming SkincareProduct has a method like getIngredients() that returns a list of ingredient names
    public List<String> getIngredients() {
        // Implementation
        return new ArrayList<>(); // Placeholder return
    }
}
