import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import CustomerApiService  from "../services/RestApiService";
import StockImage from '../StockImage.jpeg';

class MakeTrade extends Component {
	constructor(props) {
		super(props);

		this.state = {

            client: '',
            type: '',
            price: '',
            quantity: '',
            stock:''
            
		};

		this.update = this.update.bind(this);

		this.displayLogin = this.displayLogin.bind(this);
	}

	update(e) {
		let name = e.target.name;
		let value = e.target.value;
		this.setState({
			[name]: value
		});
	}
	displayLogin(e) {
		e.preventDefault();
		console.log('You have successfully ordered');
		console.log(this.state);
		this.setState({
            client: '',
            type: '',
            price: '',
            quantity: '',
            stock:''
		});
	}




	render() {
		return (
			<div className="maketrade">
			<h2>Make Trade</h2>

			<div className="logo"> <img src={StockImage} width="100" height="50" top="100" left="30"/> <span><p> Current Price - 100$</p></span></ div>

				<form onSubmit={this.displayLogin}>
					

					<div className="client">
						<input
							type="text"
							placeholder="client Name"
							name="client"
							value={this.state.client}
							onChange={this.update}
						/>
					</div>


					<div className="type">
						<input
							type="text"
							placeholder="type"
							name="type"
							value={this.state.type}
							onChange={this.update}
						/>
					</div>

					<div className="price">
						<input
							type="text"
							placeholder="price"
							name="price"
							value={this.state.price}
							onChange={this.update}
						/>
					</div>
                    <div className="quantity">
						<input
							type="text"
							placeholder="quantity"
							name="quantity"
							value={this.state.quantity}
							onChange={this.update}
						/>
					</div>
                    <div className="stock">
						<input
							type="text"
							placeholder="stock"
							name="stock"
							value={this.state.stock}
							onChange={this.update}
						/>
					</div> 

					
					
					

					

					<button onClick={() => {new CustomerApiService().addOrder(
                            {client: this.state.client,
							type: this.state.type, 
                            price: this.state.price,
                            quantity:this.state.quantity,
                            stock:this.state.stock})}
                            }>Place Order</button>
				</form>

				
				
				<Link to="/TradeStatus">Check trade status</Link>
			</div>
		);
	}
}

export default MakeTrade;
