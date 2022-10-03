package com.assignment.goodies;

import java.io.*;
import java.util.*;

public class GoodiesMain {
        public static void main(String[] args) throws Exception {
            //fileinput reader to read from sample input text file
            FileInputStream fis=new FileInputStream("D:\\Family_Doc\\Nandu\\HighPeak_assignment\\Assignment\\input\\sample_input.txt");
            Scanner sc=new Scanner(fis);
            int number_of_employees = Integer.parseInt(sc.nextLine().split(": ")[1]);
            sc.nextLine(); sc.nextLine(); sc.nextLine();

            ArrayList<Goodies> goodies_List = new ArrayList<Goodies>();

            while(sc.hasNextLine())
            {
                String current[] = sc.nextLine().split(": ");
                goodies_List.add(new Goodies(current[0], Integer.parseInt(current[1])));
            }
            sc.close();

            Collections.sort(goodies_List, new Comparator<Goodies>(){
                public int compare(Goodies a, Goodies b) {
                    return a.price - b.price;
                }
            });
//logic check
            int min_diff = goodies_List.get(goodies_List.size()-1).price;
            int min_index = 0;
            for(int i=0;i<goodies_List.size()-number_of_employees+1;i++) {
                int diff = goodies_List.get(number_of_employees+i-1).price-goodies_List.get(i).price;

                if(diff<=min_diff) {
                    min_diff = diff;
                    min_index = i;
                }
            }
//file writer to generate output file with below details
            FileWriter fw = new FileWriter("sample_output.txt");
            fw.write("The goodies selected for distribution are:\n\n");
            for(int i=min_index;i<min_index + number_of_employees; i++) {
                fw.write(goodies_List.get(i).toString() + "\n");
            }

            fw.write("\nAnd the difference between the chosen with highest price and the lowest price is " + min_diff);
            fw.close();
        }
    }