package com.google.array;

public class TestRandomizedSet {

    /**
     *
     * ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
     * [    [],            [1],     [2],    [2],        [],        [1],     [2],    []]
     */
    public static void main(String[] args) {

        try {
            RandomizedSet randomizedSet = new RandomizedSet();
            randomizedSet.insert(1);
            randomizedSet.remove(2);
            randomizedSet.insert(2);
            System.out.println(randomizedSet.getRandom());
            randomizedSet.remove(1);
            randomizedSet.insert(2);
            System.out.println(randomizedSet.getRandom());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
