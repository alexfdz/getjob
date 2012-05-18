package com.a2devel.getjob.dao;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * 
 * @author alexfdz
 *
 */
public class DaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(Integer.parseInt(args[0]), args[1]);

        addNote(schema);

        new de.greenrobot.daogenerator.DaoGenerator().generateAll(schema, args[2]);
    }

    private static void addNote(Schema schema) {
        Entity note = schema.addEntity("Note");
        note.addIdProperty();
        note.addStringProperty("text").notNull();
        note.addStringProperty("comment");
        note.addDateProperty("date");
    }

}
