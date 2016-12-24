package com.calculator.history;

import com.calculator.equation.Coefficient;
import com.calculator.equation.Equation;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class History {

    public static ArrayList<StepData> history = new ArrayList<>();

    //called when closing the app
    public static void write(String fileName) {
        try {

            File file = new File(fileName);
            PrintWriter printWriter = new PrintWriter(file);
            for (StepData s : history) {
                printWriter.println(s.toString());
            }

            printWriter.close();
        } catch (Exception e) {
        }


    }

    //called when opening the app
    public static void read(String fileName) {

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();

            while (line != null) {
                if (line.contains("ARTHIMATIC")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(Double.parseDouble(data.get(0)), Double.parseDouble(data.get(1)), data.get(2)));

                }
                if (line.contains("SOLVINGONE") || line.contains("PLOTTING")) {
                    List<String> coefficientArray = Arrays.asList(line.split("_"));
                    ArrayList<Coefficient> ready = new ArrayList<Coefficient>();
                    for (String eq : coefficientArray) {
                        List<String> equationsCoeff = Arrays.asList(line.split(","));
                        ready.add(new Coefficient(Double.parseDouble(equationsCoeff.get(0)), Integer.parseInt(equationsCoeff.get(1))));
                        history.add(new StepData(new Equation(ready),Operation.ARTHIMATIC));
                    }
                }


                if (line.contains("SOLVINGMANY")) {
                    List<String> coefficientArray = Arrays.asList(line.split("_"));
                    ArrayList<Coefficient> ready = new ArrayList<Coefficient>();
                    for (String eq : coefficientArray) {
                        List<String> equationsCoeff = Arrays.asList(line.split(","));
                        ready.add(new Coefficient(Double.parseDouble(equationsCoeff.get(0)), Integer.parseInt(equationsCoeff.get(1))));
                        history.add(new StepData(new Equation(ready),Operation.ARTHIMATIC));
                    }


                }
                if (line.contains("CONVERTING")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(Double.parseDouble(data.get(0)), data.get(1), data.get(2)));

                }


                line = br.readLine();
            }

        } catch (Exception e) {
        }


    }


}