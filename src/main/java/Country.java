public enum Country {
    ARGENTINA("Аргентина", false),
    BRAZIL("Бразилия", true),
    BOLIVIA("Боливия", false),
    COLOMBIA("Колумбия", true),
    CUBA("Куба", true),
    CHILE("Чили", true),
    ECUADOR("Эквадор", true),
    GUATEMALA("Гватемала", true),
    MEXICO("Мексика", true),
    PARAGUAY("Парагвай", false),
    PANAMA("Панама", true),
    URUGUAY("Уругвай", false),
    VENEZUELA("Венесуэла", false);

    private final String ruName;
    private final boolean isOpen;

    Country(final String ruName, final boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }


    @Override
    public String toString() {
        return name() + " (" + ruName + ")";
    }

    public void statusLog() {
        String status;
        if (this.isOpen) {
            status = "открыта";
        } else {
            status = "закрыта";
        }
        System.out.println("Страна [" + toString() + "] " + status + " для посещения.");
    }

    public static Country getByRuName(final String name) throws NoCountryException {
        for (Country country : values()) {
            if (country.ruName.equalsIgnoreCase(name)) {
                return country;
            }
        }
        throw new NoCountryException(name);
    }
}