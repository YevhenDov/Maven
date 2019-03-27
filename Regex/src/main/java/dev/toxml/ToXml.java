package dev.toxml;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

public class ToXml {
    private static final Logger LOGGER = Logger.getLogger(ToXml.class);
    private static final String FILE_NAME = ".\\src\\main\\resources\\list.xml";

    public void createMultiballStructure() {
        List<Map<List<Set<Integer>>, String>> list = new ArrayList<Map<List<Set<Integer>>, String>>();
        LOGGER.info("List has been created");
        Integer value = 5;
        LOGGER.info("The value were provided");
        HashSet<Integer> hashSet = new HashSet<Integer>(value);
        List<Set<Integer>> setList = new ArrayList<Set<Integer>>();
        setList.add(hashSet);
        HashMap<List<Set<Integer>>, String> listStringHashMap = new HashMap<List<Set<Integer>>, String>();
        listStringHashMap.put(setList, "Smth");
        list.add(listStringHashMap);
        toXml(list);
    }

    private void toXml(List list) {
        XMLEncoder xmlEncoder = null;
        try {
            xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILE_NAME)));
            xmlEncoder.writeObject(list);
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        } finally {
            xmlEncoder.close();
        }
    }
}
