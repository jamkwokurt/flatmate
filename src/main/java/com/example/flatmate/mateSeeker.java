package com.example.flatmate;

public class mateSeeker {
    String name;
    String email;
    String phonenum;
    int[] personalityTraits;
    static int numOfTraits = 4;
    //length is in months
    int minLength;
    int maxLength;
    //rent is in dollars a month
    int rent;
    String location;
    String address;
    mateSeeker(String csvRow){
        String[] valueArray = csvRow.split(",");
        for (String s:valueArray) {System.out.println(s);}
        name = valueArray[0];
        email = valueArray[1];
        phonenum = valueArray[2];
        personalityTraits = new int[numOfTraits];
        for(int i=0;i<numOfTraits;i++){
            personalityTraits[i] = Integer.parseInt(valueArray[2+i]);
        }
        minLength = Integer.parseInt(valueArray[3+numOfTraits]);
        maxLength = Integer.parseInt(valueArray[4+numOfTraits]);
        rent = Integer.parseInt(valueArray[5+numOfTraits]);
        location = (valueArray[6+numOfTraits]);
        address = valueArray[7+numOfTraits];
    }
}
