package com.example.flatmate;

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
    public mateSeeker findApartment(mateSeeker[] mateArray){
        mateSeeker ideal = new mateSeeker("No Match,0,0,00,0,0,0,0,0,0,0");
        //arbitrarily high
        int bestScore = 2147483647;
        for(mateSeeker m:mateArray){
            if(m.location == this.location){
                int score = 0;
                score += Math.abs(m.length-this.length);
                score += Math.abs(m.rent-((this.minRent + this.maxRent)/2));
                for(int i=0;i<numOfTraits;i++){
                    score += m.personalityTraits[i]-this.personalityTraits[i];
                }
                if(score <= bestScore){
                    bestScore = score;
                    ideal = m;
                }
            }
        }


        return ideal;
    }
}
