package com.timesquare.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timesquare.models.Address;
import com.timesquare.repos.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepo;
	
	public List<Address> getAllAddresses() {
		return addressRepo.findAll();
	}
	
	public List<Address> getAllUserAddresses(Long userId) {
		return addressRepo.findAll().stream()
					.filter((address) -> address.getUser().getUserId() == userId)
					.collect(Collectors.toList());
	}
	
	public Address getAddressById(Long addressId) throws Exception {
		return addressRepo.findById(addressId).orElseThrow(
				() -> new Exception("Address not found with id: " 
						+ addressId));
	}
	
	public void addAddress(Address address) {
		addressRepo.save(address);
	}
	
	public void updateAddress(Address address) {
		if (addressRepo.findById(address.getAddressId()).isPresent()) {
			addressRepo.save(address);
		}
	}
	
	public String removeAddress(Long addressId) {
		if (addressRepo.findById(addressId).isPresent()) {
			addressRepo.deleteById(addressId);
			return "Users address has been deleted.";
		}
		return "Could not find address with id: " + addressId;
	}

}
