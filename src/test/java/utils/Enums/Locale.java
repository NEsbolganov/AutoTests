package utils.Enums;

public enum Locale {
    En("English"), RU("Русский"), KK("Қазақша");

    private String value;
    Locale(String s) {
        this.value = s;
    }

    public String getValue(){
        return this.value;
    }
}
