package com.techelevator.Product;

import org.junit.Assert;

import com.techelevator.Product.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.Map;

public class ProductTest {


        ProductGS productGS = new ProductGS();
        Map<String,Product> cvsFileMap=productGS.buildMenu();

        Product product1= productGS.buildMenu().get("A1");
        Product product2= productGS.buildMenu().get("A2");
        Product product16= productGS.buildMenu().get("D4");

        Product candy = new Candy("A Candy",2.00);
        Product drink = new Drink("A Drink",3.00);
        Product chip = new Chip("A Chip",4.00);
        Product gum = new Gum("A Gum",1.00);


        public ProductTest() throws FileNotFoundException {
        }

        @Test
        public void TestSound(){

            String[] expectedSounds = {"Munch, Munch, Yum!","Glug, Glug, Yum!","Crunch, Crunch, Yum!","Chew, Chew, Yum!"};
            Assert.assertEquals(expectedSounds[0],candy.sound());
            Assert.assertEquals(expectedSounds[1],drink.sound());
            Assert.assertEquals(expectedSounds[2],chip.sound());
            Assert.assertEquals(expectedSounds[3],gum.sound());
        }
        @Test
        public void TestReduceQuantity(){
            Assert.assertEquals(5,candy.getQuantity());
            candy.reduceQuantity();
            Assert.assertEquals(4,candy.getQuantity());
            candy.reduceQuantity();
            Assert.assertEquals(3,candy.getQuantity());
            candy.reduceQuantity();
            Assert.assertEquals(2,candy.getQuantity());
            candy.reduceQuantity();
            Assert.assertEquals(1,candy.getQuantity());
            candy.reduceQuantity();
            Assert.assertEquals(0,candy.getQuantity());
            candy.reduceQuantity();
            Assert.assertEquals(0,candy.getQuantity());
        }
        @Test
        public void testSaveCsvFileInMap(){
            String[] line1= {"Potato Crisps","3.05"};
            String[] line2= {"Stackers","1.45"};
            String[] line16= {"Triplemint","0.75"};

            Assert.assertEquals(line1[0],product1.getName());
            Assert.assertEquals(line1[1],product1.getPrice()+"");

            Assert.assertEquals(line2[0],product2.getName());
            Assert.assertEquals(line2[1],product2.getPrice()+"");

            Assert.assertEquals(line16[0],product16.getName());
            Assert.assertEquals(line16[1],product16.getPrice()+"");
        }




    }












