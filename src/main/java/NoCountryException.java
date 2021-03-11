public class NoCountryException extends IllegalArgumentException {

    NoCountryException(final String country) {
        super("Страны '" + country + "' не существует.");
    }

}