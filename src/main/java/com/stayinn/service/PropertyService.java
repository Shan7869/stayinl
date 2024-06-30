/**
 * 
 */
package com.stayinn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stayinn.entity.Property;
import com.stayinn.repository.PropertyRepository;
import com.stayinn.repository.UserRepository;

/**
 * 
 */
@Service
public class PropertyService implements IPropertyService {
	@Autowired
	PropertyRepository propertyRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Property> getAllProperties() {
		return propertyRepository.findAll();
	}

	@Override
	public Property getPropertyById(Long id) {

		Optional<Property> propertyOptional = propertyRepository.findById(id);
		if (propertyOptional.isPresent())
			return propertyOptional.get();
		return null;
	}

	@Override
	public Property createProperty(Property property) {
		Property createdPropery = propertyRepository.save(property);
		createdPropery.setOwner(userRepository.findById(createdPropery.getOwner().getId()).get());
		return createdPropery;
	}

	@Override
	public Property updateProperty(Long id, Property updatedProperty) {
		 Optional<Property> optionalProperty = propertyRepository.findById(id);
		    
		    if (optionalProperty.isEmpty()) {
		        return null;
		    }

		    Property existingProperty = optionalProperty.get();

		    // Update the existing property with new data
		    existingProperty.setName(updatedProperty.getName());
		    existingProperty.setDescription(updatedProperty.getDescription());
		    existingProperty.setLocation(updatedProperty.getLocation());
		    existingProperty.setType(updatedProperty.getType());
		    existingProperty.setOwner(updatedProperty.getOwner());
		    return propertyRepository.save(existingProperty);
	}

	@Override
	public Long deleteProperty(Long id) {
		    if (!propertyRepository.existsById(id)) {
		        return null;
		    }

		    // Delete the property by id
		    propertyRepository.deleteById(id);

		    // Return ResponseEntity with 204 No Content status
		    return id;
		
		
	}

}
