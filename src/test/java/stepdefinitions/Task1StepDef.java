package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Task1StepDef {

    List<Integer> myList = new ArrayList<>();

    @Given("user gives {string}")
    public void userGives(String numberOfList) {

        //Creating array by using split() method
        String[] myArray = numberOfList.split(",");

        for (String str : myArray) {
            myList.add(Integer.parseInt(str));
        }
        System.out.println("List: "+myList);

    }

    @When("removes elements greater than {int} using")
    public void removesElementsGreaterThanUsing(int num) {

/*  // 1.Way: can be done with use of Iterator

        // Creating iterator object
//        Iterator itr = myList.iterator();

        // Holds true till there is single element
        // remaining in the object
        while (itr.hasNext()) {

         // Remove elements greater than 100 using
        // Iterator.remove()
            int x = (Integer)itr.next();
            if (x > num)
                itr.remove();
        }
*/

    // 2.Way: can be done with use of Lambda
          myList.removeIf(x->x>num);

        // Printing the updated ArrayList
        System.out.println("Updated list: "+ myList);
    }

    @Then("then verifies check the list of Integer")
    public void thenVerifiesCheckTheListOfInteger() {

        Assert.assertTrue(myList.stream().noneMatch(a->a>100));
    }
}
