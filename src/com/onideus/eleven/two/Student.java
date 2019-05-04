package com.onideus.eleven.two;

public class Student implements Comparable {
    private String firstName;
    private String lastName;
    private int score;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        // I'm cheating to use the toString() method to write out the output that we expect to see, instead of implementing it elsewhere
        return String.format("Last name: %s\n" +
                "First name: %s\n" +
                "Score: %d\n", lastName, firstName, score);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student) { // this confirms that the object passed is an instance of our Student class, otherwise we throw an exception (we don't want it)

            // I'm returning the result of a short-hand if-then statement; if the compareTo functions returns 0, that means
            //  that the two are identical, so based on the assignment we need to find out the comparison of first names,
            //   otherwise, we can use the last name to compare. I could have also written it as follows:

//            if(((Student) o).getLastName().compareTo(this.lastName) == 0) {
//                return ((Student) o).getFirstName().compareTo(this.firstName);
//            } else {
//                return ((Student) o).getLastName().compareTo(this.lastName);
//            }

            // Finally, the (Student) in front of the o object is just me casting, or translating, that object to be of the
            //  Student class; by doing so I get access to all of the Student class methods (mainly the getters that help me with the
            //   comparison)

            return (((Student) o).getLastName().compareTo(this.lastName) == 0) ?
                    ((Student) o).getFirstName().compareTo(this.firstName) :
                    ((Student) o).getLastName().compareTo(this.lastName);
        } else {
            throw new ClassCastException();
        }
    }
}
