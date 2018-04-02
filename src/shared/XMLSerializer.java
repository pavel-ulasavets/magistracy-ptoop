package shared;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLSerializer {
    /**
     * serializes a give object to XML and write it to a file by a given path

     * @param object
     * @param path
     * @throws IOException
     */
    public static void serializeToXMLFile(Object object, String path) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(e -> System.out.println("Exception! :" + e.toString()));
        encoder.writeObject(object);
        encoder.close();
        fos.close();
    }

    /**
     * reads a xml by a given path, parses it and return as Java object
     *
     * @param path
     * @return
     */
    public static Object deserializeXML(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        XMLDecoder decoder = new XMLDecoder(fis);
        Object decodeObject = decoder.readObject();
        decoder.close();
        fis.close();

        return decodeObject;
    }
}
