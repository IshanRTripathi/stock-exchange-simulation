import axios from 'axios';


export default class CustomerApiService{
	
	
	getCustomers = () => {
		
		return axios.get("http://localhost:8080/getCustomers");
	}
	
	
	loginCustomer = (customer) => {

		console.log(customer);
		
		return axios.post('http://localhost:8080/logincustomer',customer)
		  .then(function (response) {
			console.log(response);
		  })
		  .catch(function (error) {
			console.log(error);
		  });
	}
	
	
	addCustomer = (customer) => {

		console.log(customer);
		
		return axios.post('http://localhost:8080/addCustomer',customer)
		  .then(function (response) {
			console.log(response);
		  })
		  .catch(function (error) {
			console.log(error);
		  });
	}
	
	
	
}

