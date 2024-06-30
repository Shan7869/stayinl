/**
 * 
 */
package com.stayinn.service;

import java.util.List;

import com.stayinn.entity.Property;

/**
 * 
 */
public interface IPropertyService {

	List<Property> getAllProperties();

	Property getPropertyById(Long id);

	Property createProperty(Property property);

	Property updateProperty(Long id, Property propertyDetails);

	Long deleteProperty(Long id);

}
