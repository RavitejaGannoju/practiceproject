package com.example.service;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Practice {

public static void main(String[] args) {
        
        String str = "JavaExamplesJavaCodeJavaProgram";
        
        String strFind = "Java";
        int count = 0, fromIndex = 0;
        
        while ((fromIndex = str.indexOf(strFind, fromIndex)) != -1 ){
 
            System.out.println("Found at index: " + fromIndex);
            count++;
            fromIndex++;
            
        }
        
        System.out.println("Total occurrences: " + count);
    }
}
