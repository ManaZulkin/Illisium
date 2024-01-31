package com.illisium.resources.utilit;


import com.illisium.basic.en.ItemType;
import com.illisium.modelsDB.equpment.Item;

import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Method;

public class DataUtility {
    private final static String path = "src/main/java/com/illisium/data/";


    /**
     * Creating file <T> object and saving it in system using class name and name parameter of object like a path to file
     * @param object
     * @param <T>
     */
    public static <T> void save( T object){
        File fcreature = new File(path  + object.getClass().getSimpleName() + "/" + check(object) + ".file");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fcreature))){
            oos.writeObject(object);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Loading file and return object of this file by name
     * @param object
     * @param name
     * @return
     * @param <T>
     */
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
     * checking object for name parameter and returning value for this parameter if it exists
     * @param object
     * @return
     * @param <T>
     * @throws RuntimeException
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
