package com.mikolab;

/**
 * Created by User on 2016-01-11.
 */

import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataListener;
import com.pi4j.io.serial.SerialFactory;

public class Main{

    public static void main(String[] args) {
        System.out.println("<--GPSDemo--> GPS test program");

        // open serial port for communication
        final Serial serial = SerialFactory.createInstance();
        serial.addListener(listener);
        try {
            serial.open(Serial.DEFAULT_COM_PORT, 9600 );
        } catch (Exception f) {
            f.printStackTrace();
        }

        while(true){}

    }

    static SerialDataListener listener = new SerialDataListener() {
        @Override
        public void dataReceived(SerialDataEvent event) {
            System.out.print(event.getData() + "|<<");
            System.out.print("\n>>");
        }
    };



}


