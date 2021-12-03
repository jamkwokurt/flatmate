package com.example.flatmate;

import java.sql.ResultSet;

public class flatMate {
    String name;
    String email;
    String phonenum;
    int[] personalityTraits;
    static int numOfTraits = 4;
    //length is in months
    int length;
    //rent is in dollars a month
    int minRent;
    int maxRent;
    String location;
    flatMate(String csvRow){
        String[] valueArray = csvRow.split(",");
        for (String s:valueArray) {System.out.println(s);}
        name = valueArray[0];
        email = valueArray[1];
        phonenum = valueArray[2];
        personalityTraits = new int[numOfTraits];
        for(int i=0;i<numOfTraits;i++){
            personalityTraits[i] = Integer.parseInt(valueArray[2+i]);
        }
        length = Integer.parseInt(valueArray[3+numOfTraits]);
        minRent = Integer.parseInt(valueArray[4+numOfTraits]);
        maxRent = Integer.parseInt(valueArray[5+numOfTraits]);
        location = valueArray[6+numOfTraits];
    }
    flatMate(ResultSet resultSet){
        try{
        name = resultSet.getString("name");
        email = resultSet.getString("email");
        phonenum = resultSet.getString("phone");
        personalityTraits[0] =  resultSet.getInt("lbgtq_friendly");
            personalityTraits[1] =  resultSet.getInt("socially_active");
            personalityTraits[2] =  resultSet.getInt("eco_conciousness");
            personalityTraits[3] =  resultSet.getInt("cleanliness");

        length = resultSet.getInt("term_length");
        minRent = resultSet.getInt("rent");
        maxRent = resultSet.getInt("rent");
        location = resultSet.getString("phone");
        }catch(Exception e){

        }

    }

    public String getName(){
        return this.name;
    }
}
