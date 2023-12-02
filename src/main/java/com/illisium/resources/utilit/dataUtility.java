package com.illisium.resources.utilit;

import com.illisium.resources.creature.*;

import java.io.*;

public class dataUtility {
    private final static String path = "src/main/java/com/illisium/data/";



    public static <T> void save( T object){
        File fcreature = new File(path  + object.getClass().getSimpleName() + "/" + check(object) + ".file");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fcreature))){
            oos.writeObject(object);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static <T> T  load(T object, String name){
        File fCreature = new File(path  + object.getClass().getSimpleName() + "/" + name + ".file");

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fCreature))){
            object = (T) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }

        return object;
    }

    public static String check(Object object){
        if (object.getClass() == Creature.class){
            return ((Creature) object).getCreatureInfo().getCreatureName();
        }

    return "error";}
}
