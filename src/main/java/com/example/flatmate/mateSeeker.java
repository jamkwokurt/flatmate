package com.example.flatmate;

public class mateSeeker {
    String name;
    String email;
    String phoneNum;
    int[] personalityTraits;
    static int numOfTraits = 4;
    //length is in months
    int length;
    //rent is in dollars a month
    int rent;
    String location;
    String address;
    mateSeeker(String csvRow){
        String[] valueArray = csvRow.split(",");
        for (String s:valueArray) {System.out.println(s);}
        name = valueArray[0];
        email = valueArray[1];
        phoneNum = valueArray[2];
        personalityTraits = new int[numOfTraits];
        for(int i=0;i<numOfTraits;i++){
            personalityTraits[i] = Integer.parseInt(valueArray[2+i]);
        }
        length = Integer.parseInt(valueArray[3+numOfTraits]);
        rent = Integer.parseInt(valueArray[4+numOfTraits]);
        location = (valueArray[5+numOfTraits]);
        address = valueArray[6+numOfTraits];
    }
    public flatMate findMate(flatMate[] mateArray){
        flatMate ideal = new flatMate("No Match,0,0,00,0,0,0,0,0,0,0");
        //arbitrarily high
        int bestScore = 2147483647;
        for(flatMate f:mateArray){
            if(f.location == this.location){
                int score = 0;
                score += Math.abs(f.length-this.length);
                score += Math.abs(((f.minRent + f.maxRent)/2)-this.rent);
                for(int i=0;i<numOfTraits;i++){
                    score += f.personalityTraits[i]-this.personalityTraits[i];
                }
                if(score <= bestScore){
                    bestScore = score;
                    ideal = f;
                }
            }
        }


        return ideal;
    }
}
