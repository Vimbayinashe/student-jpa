package org.example.student;

public class Guard {

    public static class Against {

        public static void InvalidTuitionFormat(String value) {
            try {
                if(value.contains(","))
                    Double.parseDouble(value.replace(",", "."));
                else
                    Double.parseDouble(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(value + " is not a valid value format.");
            }
        }

        public static void EmptyString(String name, String value) {
            if(value.isEmpty())
                throw new IllegalArgumentException(name + " is an empty string.");
        }

        public static void InvalidCredits(int credits) {
            if(credits < 60)
                throw new IllegalArgumentException("Minimum possible credits are 60.");
        }

        public static void InvalidSSN(String ssn) {
            if(ssn.length() != 13)
                throw new IllegalArgumentException("Invalid SSN.");
        }
    }

}
