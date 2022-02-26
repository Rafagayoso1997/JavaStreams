package beans;

public class Country {

  private Integer id;
  private String countryName;
  private String countryCode;
  private String language;

  public Country(Integer id, String countryName, String countryCode, String language) {
    this.id = id;
    this.countryName = countryName;
    this.countryCode = countryCode;
    this.language = language;
  }

  public Integer getCountryId() {
    return id;
  }

  public String getCountryName() {
    return countryName;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public String getLanguage() {
    return language;
  }

  @Override
  public String toString() {
    return "Country{" +
        "countryId=" + id +
        ", countryName='" + countryName + '\'' +
        ", countryCode='" + countryCode + '\'' +
        ", language='" + language + '\'' +
        '}';
  }
}
