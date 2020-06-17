import axios from 'axios';


export default class CustomerApiService{
	
	
	static getTrades = () => {
		
		return axios.get("http://localhost:8085/getTrades");
	}

	
	
	
	loginCustomer = (customer) => {

		console.log(customer);
		
		return axios.post('http://localhost:8085/logincustomer',customer)
		  .then(response =>
			  
			response.data
		  )
		  .catch(function (error) {
			console.log(error);
		  });
	}
	
	
	addCustomer = (customer) => {

		console.log(customer);
		
		return axios.post('http://localhost:8085/addCustomer',customer)
		  .then(function (response) {
			console.log(response);
		  })
		  .catch(function (error) {
			console.log(error);
		  });
	}

	addOrder = (order) => {

		console.log(order);
		
		return axios.post('http://localhost:8085/addOrder',order)
		  .then(function (response) {
			console.log(response);
		  })
		  .catch(function (error) {
			console.log(error);
		  });
	}





	
	
	
}

