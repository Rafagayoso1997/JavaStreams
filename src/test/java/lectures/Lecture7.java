package lectures;


import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    long count = MockData.getPeople()
        .stream()
        .filter(person -> person.getGender().equalsIgnoreCase("female"))
        .count();

    System.out.println(count);
  }

  @Test
  public void min() throws Exception {
    double min = MockData.getCars()
        .stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .min()
        .orElse(0);

    System.out.println(min);

  }

  @Test
  public void max() throws Exception {
    double max = MockData.getCars()
        .stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .max()
        .orElse(0);

    System.out.println(max);
  }


  @Test
  public void average() throws Exception {
    double average = MockData.getCars()
        .stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);

    System.out.println(average);

  }

  @Test
  public void sum() throws Exception {
    double sum = MockData.getCars()
        .stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimal = BigDecimal.valueOf(sum);
    System.out.println(bigDecimal);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();

    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());

  }

}