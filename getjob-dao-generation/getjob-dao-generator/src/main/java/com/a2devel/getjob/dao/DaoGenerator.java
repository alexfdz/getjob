package com.a2devel.getjob.dao;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;
import de.greenrobot.daogenerator.ToOne;

/**
 * 
 * @author alexfdz
 *
 */
public class DaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(Integer.parseInt(args[0]), args[1]);

        defineSchema(schema);

        new de.greenrobot.daogenerator.DaoGenerator().generateAll(schema, args[2]);
    }

    private static void defineSchema(Schema schema) {
    	Entity search = schema.addEntity("Search");
    	search.addIdProperty();
    	search.addStringProperty("url").notNull();
    	search.addStringProperty("search").notNull();
    	search.addDateProperty("timestamp").notNull();
    	
    	Entity result = schema.addEntity("Result");
        Property resultId = result.addIdProperty().getProperty();
        result.addStringProperty("text").notNull();
        result.addStringProperty("url").notNull();
        result.addDateProperty("timestamp").notNull();
        result.addIntProperty("favorite");
        result.addIntProperty("applied");
        
        Property resultSearchId = result.addLongProperty("searchId").notNull().getProperty();
        ToOne resultToSearch = result.addToOne(search, resultSearchId);
        resultToSearch.setName("search");
        
        ToMany searchToResults = search.addToMany(result, resultSearchId);
        searchToResults.setName("results");
        searchToResults.orderAsc(resultId);
    }

}
