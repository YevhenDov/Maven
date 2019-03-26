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

public class ToXml {
    private static final String FILE_NAME = "list.xml";

    public void createMultiballStructure() {
        List<Map<List<Set<Integer>>, String>> list = new ArrayList<Map<List<Set<Integer>>, String>>();
        int decimalInHashSet = 25;
        Set hashSetInList = new HashSet();
        hashSetInList.add(decimalInHashSet);
        List listInHashMap = new ArrayList();
        listInHashMap.add(hashSetInList);
        Map hashMapInList = new HashMap();
        hashMapInList.put(listInHashMap, "twenty five");
        list.add(hashMapInList);

        toXml(list);
    }

    private void toXml(List list) {
        try {
            XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILE_NAME)));
            xmlEncoder.writeObject(list);
            xmlEncoder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
