package com.geosymp.blog.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.geosymp.blog.Data;
import com.geosymp.blog.models.Member;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Override
    public ObjectNode membersAsGeoJSon() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter();
            /*"crs": { "type": "name",
                "properties": { "name": "urn:ogc:def:crs:OGC:1.3:CRS84" }
            }*/
        ObjectNode featureCollection = mapper.createObjectNode();
        featureCollection.put("type", "FeatureCollection");
        ObjectNode crs = mapper.createObjectNode();
        crs.put("type", "name");
        ObjectNode crsProps = mapper.createObjectNode();
        crsProps.put("name", "urn:ogc:def:crs:OGC:1.3:CRS84");
        crs.putPOJO("properties", crsProps);
        featureCollection.putPOJO("crs", crs);
        ArrayNode features = mapper.createArrayNode();
        for (Member member : Data.members()) {
            ObjectNode feature = mapper.createObjectNode();
            feature.put("type", "Feature");
            //Geometry Object
            ObjectNode geometryObject = mapper.createObjectNode();
            ArrayNode coordinates = mapper.createArrayNode();
            coordinates.add(member.getLat());
            coordinates.add(member.getLon());
            geometryObject.put("type", "Point");
            geometryObject.putPOJO("coordinates", coordinates);

            //Properties
            ObjectNode properties = mapper.createObjectNode();
            properties.put("name", member.getName());
            properties.put("speciality", member.getSpeciality());

            feature.putPOJO("geometry", geometryObject);
            feature.putPOJO("properties", properties);
            features.addPOJO(feature);
        }
        featureCollection.putPOJO("features", features);
        return featureCollection;
    }
}
