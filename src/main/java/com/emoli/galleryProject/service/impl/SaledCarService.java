package com.emoli.galleryProject.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emoli.galleryProject.dto.CurrencyResponse;
import com.emoli.galleryProject.dto.DtoCar;
import com.emoli.galleryProject.dto.DtoCustomer;
import com.emoli.galleryProject.dto.DtoGalleriest;
import com.emoli.galleryProject.dto.DtoSaledCar;
import com.emoli.galleryProject.dto.DtoSaledCarIU;
import com.emoli.galleryProject.enums.CarStatusType;
import com.emoli.galleryProject.exception.BaseException;
import com.emoli.galleryProject.exception.ErrorMessage;
import com.emoli.galleryProject.exception.MessageType;
import com.emoli.galleryProject.model.Car;
import com.emoli.galleryProject.model.Customer;
import com.emoli.galleryProject.model.SaledCar;
import com.emoli.galleryProject.repo.CarRepository;
import com.emoli.galleryProject.repo.CustomerRepository;
import com.emoli.galleryProject.repo.GalleriestRepository;
import com.emoli.galleryProject.repo.SaledCarRepository;
import com.emoli.galleryProject.service.ICurrencyService;
import com.emoli.galleryProject.service.ISaledCarService;
import com.emoli.galleryProject.utils.DateUtils;


@Service
public class SaledCarService implements ISaledCarService {

	
	
	@Autowired 
	private SaledCarRepository saledCarRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private GalleriestRepository galleriestRepository;
	
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private ICurrencyService currencyService;
	
	
	
	public BigDecimal converCustomerAmountUSD(Customer customer) {
		
		CurrencyResponse currencyResponse = currencyService.getCurrency(DateUtils.getCurrentDate(new Date()), DateUtils.getCurrentDate(new Date()));
		//güncel kuru çektik
		BigDecimal usd = new BigDecimal(currencyResponse.getItems().get(0).getUsd());
	
		// müşterinin tl parasını kur  değerine bölerek dolar cinsine çevirdik (2 basamak dön ve yukarıya yuvarla)
		BigDecimal customerUSDAmount = customer.getAccount().getAmount().divide(usd, 2, RoundingMode.HALF_UP);
		return customerUSDAmount;
	}
	
	
	
	
	private BigDecimal kalanCustomerBakiye(Customer customer , Car car) {

			BigDecimal customerUSDBakiye = converCustomerAmountUSD(customer);
			
			BigDecimal kalanUSDBakiye = customerUSDBakiye.subtract(car.getPrice());
						
			//tekrardan kalan parayı tl ye çeviriyoruz
			CurrencyResponse currencyResponse = currencyService.getCurrency(DateUtils.getCurrentDate(new Date()), DateUtils.getCurrentDate(new Date()));
		
		
			BigDecimal usd = new BigDecimal(currencyResponse.getItems().get(0).getUsd()); 
			
			return kalanUSDBakiye.multiply(usd);
			
			
		
	}
	
	
	
	
	
	
	public boolean checkAmount(DtoSaledCarIU dtoSaledCarIU) {
		
		Optional<Customer> optCustomer = customerRepository.findById(dtoSaledCarIU.getCustomerId());
		
		if(optCustomer.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoSaledCarIU.getCustomerId().toString()));
		}
		
		Optional<Car> optCar = carRepository.findById(dtoSaledCarIU.getCarId());
		
		if(optCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoSaledCarIU.getCarId().toString()));
		}

		
		BigDecimal customerUSDAmount = converCustomerAmountUSD(optCustomer.get());
		
		if(customerUSDAmount.compareTo(optCar.get().getPrice()) == 0  || customerUSDAmount.compareTo(optCar.get().getPrice()) > 0){
			return true;
		}
		
		return false;
		
	}
	
	
	
	
	public boolean checkCarStatus(Long carId) {
		Optional<Car> optCar =  carRepository.findById(carId);
		if(optCar.isPresent() && optCar.get().getCarStatusType().name().equals(CarStatusType.SALED.name())) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	private SaledCar createSaledCar(DtoSaledCarIU dtoSaledCarIU) {
		
		SaledCar saledCar = new SaledCar();
		
		saledCar.setCreateTime(new Date());
		
		saledCar.setCar(carRepository.findById(dtoSaledCarIU.getCarId()).orElse(null));
		saledCar.setCustomer(customerRepository.findById(dtoSaledCarIU.getCarId()).orElse(null));
		saledCar.setGalleriest(galleriestRepository.findById(dtoSaledCarIU.getGalleryId()).orElse(null));
		
		return saledCar;
			
	}

	
	
	
	
	
	
	
	public DtoSaledCar toDTO(SaledCar saledCar) {
		DtoSaledCar dtoSaledCar = new DtoSaledCar();
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoGalleriest dtoGallerist = new DtoGalleriest();
		DtoCar dtoCar = new DtoCar();
		
		BeanUtils.copyProperties(saledCar, dtoSaledCar);
		BeanUtils.copyProperties(saledCar.getCustomer(), dtoCustomer);
		BeanUtils.copyProperties(saledCar.getGalleriest(), dtoGallerist);
		BeanUtils.copyProperties(saledCar.getCar(), dtoCar);
		
		dtoSaledCar.setDtoCustomer(dtoCustomer);
		dtoSaledCar.setDtoGalleriest(dtoGallerist);
		dtoSaledCar.setDtoCar(dtoCar);
		return dtoSaledCar;
	}
	
	
	
	
	
	
	
	@Override
	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU) {
		
		if(!checkAmount(dtoSaledCarIU)) {
			throw new BaseException(new ErrorMessage(MessageType.CUSTOMER_AMOUNT_NOT_ENOUGH,""));
		}
		
		
		if(!checkCarStatus(dtoSaledCarIU.getCarId())) {
			throw new BaseException(new ErrorMessage(MessageType.CAR_STATUS_IS_ALREADY_SALED,dtoSaledCarIU.getCarId().toString()));
		}
		
		SaledCar savedSaledCar = saledCarRepository.save(createSaledCar(dtoSaledCarIU));
		
		Car car =  savedSaledCar.getCar();
		car.setCarStatusType(CarStatusType.SALED);	
		carRepository.save(car); 
		
		
		Customer customer = savedSaledCar.getCustomer();
		customer.getAccount().setAmount(kalanCustomerBakiye(customer, car));
		customerRepository.save(customer);
		
		
		
		return  toDTO(savedSaledCar);
	}

	
	
	
	
	

	
	
	
	
	
	
}
