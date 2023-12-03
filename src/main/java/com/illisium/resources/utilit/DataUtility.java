package com.illisium.resources.utilit;


import com.illisium.basic.en.ItemType;
import com.illisium.modelsDB.abylities.Skills;
import com.illisium.modelsDB.equpment.Item;
import com.illisium.modelsDB.equpment.Weapon;
import com.illisium.resources.creature.*;
import jakarta.persistence.Entity;

import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Method;

public class DataUtility {
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


    /**
     *розібратися як витягнути знаення параметра через рефлексію і аставити його в назву
     */
    public static <T> String check(T object) throws RuntimeException{
      String result = null;
      try{
          PropertyDescriptor pd = new PropertyDescriptor("name", object.getClass());
          Method get = pd.getReadMethod();
          result = (String) get.invoke(object);
      }catch (Exception e){
          e.printStackTrace();
      }
      if (result == null) throw new RuntimeException();
      else return result;
   }

    public static void main(String[] args) {
        Item item = new Item("rely", ItemType.Ingredient.toString(), true, false, "");
        System.out.println(check(item));
    }
}
