package ga.matthewtgm.template.commands;

public enum CommandCategory {

    UTILITY("Utility"),
    FUN("Fun"),
    MODERATION("Moderation");

    private String categoryName;

    CommandCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

}