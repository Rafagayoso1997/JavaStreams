package lectures;


import static org.assertj.core.api.Java6Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    final Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

    List<Car> carsFiltered = cars.stream().filter(carPredicate).collect(Collectors.toList());

    carsFiltered.forEach(System.out::println);
    System.out.println(carsFiltered.size());
  }


  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    //Normal approach
    /*List<Person> people = MockData.getPeople();
    List<PersonDTO> peopleDTO = people.stream()
        .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
        .collect(Collectors.toList());

    peopleDTO.forEach(System.out::println);
    assertThat(peopleDTO).hasSize(1000);*/

    //Functional Interface approach
    /*List<Person> people = MockData.getPeople();
    Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(),
        person.getFirstName(), person.getAge());
    List<PersonDTO> peopleDTO = people.stream()
        .map(*personPersonDTOFunction)
        .collect(Collectors.toList());

    peopleDTO.forEach(System.out::println);
    assertThat(peopleDTO).hasSize(1000);*/

    //Method Reference approach
    List<Person> people = MockData.getPeople();
    List<PersonDTO> peopleDTO = people.stream()
        .map(PersonDTO::map)
        .collect(Collectors.toList());

    peopleDTO.forEach(System.out::println);
    assertThat(peopleDTO).hasSize(1000);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    double average = MockData.getCars()
        .stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);

    System.out.println(average);
  }

  @Test
  public void test() throws Exception {

  }
}



