package com.geosymp.blog.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

@Service("myService")
public interface MyService {
    /**
     * Generating a geoJSon in Java armed with just a
     * Geojson Specification and Json parser in this example we use Gson
     * @return a GeoJSon String.
     */
    public ObjectNode membersAsGeoJSon();
}
